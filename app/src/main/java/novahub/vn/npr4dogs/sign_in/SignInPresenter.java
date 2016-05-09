package novahub.vn.npr4dogs.sign_in;

import android.util.Log;

/**
 * Created by samnguyen on 5/4/16.
 */
public class SignInPresenter implements SignInContract.Presenter{
    private final SignInContract.View signInView;
    private final String TAG = "SignInPresenter";

    public SignInPresenter(SignInContract.View signInView) {
        this.signInView = signInView;
        this.signInView.setPresenter(this);
    }

    @Override
    public void loadView() {

    }

    @Override
    public void loadForm() {
        // load form from view => fragment
        signInView.showForm();
    }

    @Override
    public void signUpNewAccount() {
        Log.d(TAG, "sign up new account");
        signInView.goToWebViewSignUp();
    }

    @Override
    public void forgotPassword() {
        Log.d(TAG, "forgot password");
        signInView.goToGetPasswordForm();
    }

    @Override
    public void signIn() {
        signInView.signInSuccessfully(true);
    }

    @Override
    public void start() {

    }
}
