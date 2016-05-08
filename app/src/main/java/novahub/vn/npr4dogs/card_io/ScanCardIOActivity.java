package novahub.vn.npr4dogs.card_io;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.andexert.library.RippleView;

import io.card.payment.CardIOActivity;
import io.card.payment.CreditCard;
import novahub.vn.npr4dogs.Base;
import novahub.vn.npr4dogs.R;
import novahub.vn.npr4dogs.add_a_dog.AddADogActivity;
import novahub.vn.npr4dogs.main.MainActivity;

public class ScanCardIOActivity extends AppCompatActivity implements Base{
    private final String TAG = getClass().getName();
    private int MY_SCAN_REQUEST_CODE = 100; // arbitrary int
    private RippleView rippleView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_card_io);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        rippleView = (RippleView) findViewById(R.id.rpv_cancel);
        rippleView.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {

            @Override
            public void onComplete(RippleView rippleView) {
                Intent intent = new Intent(ScanCardIOActivity.this, AddADogActivity.class);
                intent.putExtra(PAGE, 1);
                startActivity(intent);
                finish();
            }

        });
        onScanPress();

    }

    @Override
    protected void onResume() {
        super.onResume();

        if (CardIOActivity.canReadCardWithCamera()) {
            Log.d(TAG,"Scan a credit card with card.io");
        } else {
            Log.d(TAG,"Enter credit card information");
        }
    }


    public void onScanPress() {
        // This method is set up as an onClick handler in the layout xml
        // e.g. android:onClick="onScanPress"

        Intent scanIntent = new Intent(this, CardIOActivity.class);

        // customize these values to suit your needs.
        scanIntent.putExtra(CardIOActivity.EXTRA_REQUIRE_EXPIRY, true); // default: false
        scanIntent.putExtra(CardIOActivity.EXTRA_REQUIRE_CVV, false); // default: false
        scanIntent.putExtra(CardIOActivity.EXTRA_REQUIRE_POSTAL_CODE, false); // default: false
        scanIntent.putExtra(CardIOActivity.EXTRA_RESTRICT_POSTAL_CODE_TO_NUMERIC_ONLY, false); // default: false
        scanIntent.putExtra(CardIOActivity.EXTRA_REQUIRE_CARDHOLDER_NAME, false); // default: false

        // hides the manual entry button
        // if set, developers should provide their own manual entry mechanism in the app
        scanIntent.putExtra(CardIOActivity.EXTRA_SUPPRESS_MANUAL_ENTRY, false); // default: false

        // matches the theme of your application
        scanIntent.putExtra(CardIOActivity.EXTRA_KEEP_APPLICATION_THEME, false); // default: false

        // MY_SCAN_REQUEST_CODE is arbitrary and is only used within this activity.
        startActivityForResult(scanIntent, MY_SCAN_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String resultStr;
        boolean scanOk = true;
        if (data != null && data.hasExtra(CardIOActivity.EXTRA_SCAN_RESULT)) {
            CreditCard scanResult = data.getParcelableExtra(CardIOActivity.EXTRA_SCAN_RESULT);

            // Never log a raw card number. Avoid displaying it, but if necessary use getFormattedCardNumber()
            resultStr = "Card Number: " + scanResult.getRedactedCardNumber() + "\n";

            // Do something with the raw number, e.g.:
            // myService.setCardNumber( scanResult.cardNumber );

            if (scanResult.isExpiryValid()) {
                resultStr += "Expiration Date: " + scanResult.expiryMonth + "/" + scanResult.expiryYear + "\n";
                Log.d(TAG, resultStr);
            }

            if (scanResult.cvv != null) {
                // Never log or display a CVV
                resultStr += "CVV has " + scanResult.cvv.length() + " digits.\n";
                Log.d(TAG, resultStr);
            }

            if (scanResult.postalCode != null) {
                resultStr += "Postal Code: " + scanResult.postalCode + "\n";
                Log.d(TAG, resultStr);
            }

            if (scanResult.cardholderName != null) {
                resultStr += "Cardholder Name : " + scanResult.cardholderName + "\n";
                Log.d(TAG, resultStr);
            }
        } else {
            resultStr = "Scan was canceled.";
            scanOk = false;
        }


        int from = getIntent().getIntExtra(FROM, 0);
        int page = getIntent().getIntExtra(PAGE, 0);
        Intent intent = null;
        switch (from) {
            case FROM_ADD_A_DOG:
                intent = new Intent(ScanCardIOActivity.this, AddADogActivity.class);
                break;

            default:
                intent = new Intent(ScanCardIOActivity.this, MainActivity.class);
                break;

        }
        intent.putExtra(IS_FROM_ACTION, true);
        intent.putExtra(PAGE, page);
        startActivity(intent);
        finish();


    }

}
