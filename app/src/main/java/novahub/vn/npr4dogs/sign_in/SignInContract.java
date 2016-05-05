package novahub.vn.npr4dogs.sign_in;

import novahub.vn.npr4dogs.BasePresenter;
import novahub.vn.npr4dogs.BaseView;

/**
 * Created by samnguyen on 5/4/16.
 */
public interface SignInContract {

    interface View extends BaseView<Presenter> {
        void showView();
        void showForm();
        void goToWebViewSignUp();
        void goToGetPasswordForm();
        void signInSuccessfully(boolean success);
    }

    interface Presenter extends BasePresenter {
        void loadView();
        void loadForm();
        void signUpNewAccount();
        void forgotPassword();
        void signIn();
    }
}
