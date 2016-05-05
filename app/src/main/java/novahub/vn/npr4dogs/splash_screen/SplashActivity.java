package novahub.vn.npr4dogs.splash_screen;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import novahub.vn.npr4dogs.Base;
import novahub.vn.npr4dogs.BaseActivity;
import novahub.vn.npr4dogs.R;
import novahub.vn.npr4dogs.sign_in.SignInActivity;

public class SplashActivity extends BaseActivity implements Base{

    private static long TimeShowSplashScreen = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TextView textViewAppName = (TextView) findViewById(R.id.textViewAppName);
        Typeface custom_font = Typeface.createFromAsset(getAssets(), FONT);
        textViewAppName.setTypeface(custom_font);

        // show the splash screen for 2 seconds

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, SignInActivity.class);
                startActivity(intent);
                finish();
            }
        }, TimeShowSplashScreen);
    }
}

