package novahub.vn.npr4dogs.scan_barcode;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;
import novahub.vn.npr4dogs.Base;
import novahub.vn.npr4dogs.R;
import novahub.vn.npr4dogs.add_a_dog.AddADogActivity;
import novahub.vn.npr4dogs.main.MainActivity;

public class ScanBarcodeActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler, Base {
    private ZXingScannerView mScannerView;
    private String TAG = getClass().getName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_barcode);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mScannerView = new ZXingScannerView(this);   // Programmatically initialize the scanner view
        setContentView(mScannerView);

    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        mScannerView.startCamera();          // Start camera on resume
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();           // Stop camera on pause
    }

    @Override
    public void handleResult(Result rawResult) {
        // Do something with the result here
        Log.v(TAG, rawResult.getText()); // Prints scan results
        Log.v(TAG, rawResult.getBarcodeFormat().toString()); // Prints the scan format (qrcode, pdf417 etc.)

        Toast.makeText(getApplicationContext(), "Scan suceessfull : " + rawResult.getText(), Toast.LENGTH_LONG).show();

        int from = getIntent().getIntExtra(FROM, 0);
        int page = getIntent().getIntExtra(PAGE, 0);
        Intent intent = null;
        switch (from) {
            case FROM_ADD_A_DOG:
                intent = new Intent(ScanBarcodeActivity.this, AddADogActivity.class);
                break;

            default:
                intent = new Intent(ScanBarcodeActivity.this, MainActivity.class);
                break;

        }
        intent.putExtra(IS_FROM_ACTION, true);
        intent.putExtra(PAGE, page);
        startActivity(intent);
        finish();

        // If you would like to resume scanning, call this method below:
//        mScannerView.resumeCameraPreview(this);
    }
}
