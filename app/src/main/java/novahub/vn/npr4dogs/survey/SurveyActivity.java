package novahub.vn.npr4dogs.survey;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.andexert.library.RippleView;

import novahub.vn.npr4dogs.Base;
import novahub.vn.npr4dogs.R;
import novahub.vn.npr4dogs.add_a_dog.AddADogActivity;
import novahub.vn.npr4dogs.main.MainActivity;
import novahub.vn.npr4dogs.piles.PilesActivity;
import novahub.vn.npr4dogs.utils.ActivityUtils;

public class SurveyActivity extends AppCompatActivity implements Base{

    private RippleView rippleView;
    private RippleView rippleViewCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rippleView = (RippleView) findViewById(R.id.rpv_submit);
        rippleView.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
            @Override
            public void onComplete(RippleView rippleView) {
                int from = getIntent().getIntExtra(FROM, 0);
                int page = getIntent().getIntExtra(PAGE, 0);
                Intent intent = null;
                switch (from) {
                    case FROM_ADD_A_DOG:
                        intent = new Intent(SurveyActivity.this, AddADogActivity.class);
                        break;

                    case FROM_PILES:
                        intent = new Intent(SurveyActivity.this, PilesActivity.class);
                        break;

                    default:
                        intent = new Intent(SurveyActivity.this, MainActivity.class);
                        break;

                }
                intent.putExtra(IS_FROM_ACTION, true);
                intent.putExtra(PAGE, page);
                startActivity(intent);
                finish();
            }
        });

        rippleViewCancel = (RippleView) findViewById(R.id.rpv_cancel);
        rippleViewCancel.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
            @Override
            public void onComplete(RippleView rippleView) {

                int from = getIntent().getIntExtra(FROM, 0);
                int page = getIntent().getIntExtra(PAGE, 0);
                Intent intent = null;
                switch (from) {
                    case FROM_ADD_A_DOG:
                        intent = new Intent(SurveyActivity.this, AddADogActivity.class);
                        break;

                    case FROM_PILES:
                        intent = new Intent(SurveyActivity.this, PilesActivity.class);
                        break;

                    default:
                        intent = new Intent(SurveyActivity.this, MainActivity.class);
                        break;

                }
                intent.putExtra(IS_FROM_ACTION, true);
                intent.putExtra(PAGE, page);
                startActivity(intent);
                finish();

            }
        });
    }

}
