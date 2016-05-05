package novahub.vn.npr4dogs.sign_in;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import novahub.vn.npr4dogs.BaseActivity;
import novahub.vn.npr4dogs.R;
import novahub.vn.npr4dogs.utils.ActivityUtils;

public class SignInActivity extends BaseActivity {

    private SignInContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        SignInFragment signInFragment =
                (SignInFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);

        if (signInFragment == null) {
            signInFragment = SignInFragment.newInstance();

            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(), signInFragment, R.id.contentFrame
            );
        }

        presenter = new SignInPresenter(signInFragment);
    }

}
