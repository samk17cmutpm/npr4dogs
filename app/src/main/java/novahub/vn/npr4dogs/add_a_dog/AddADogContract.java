package novahub.vn.npr4dogs.add_a_dog;

import novahub.vn.npr4dogs.BasePresenter;
import novahub.vn.npr4dogs.BaseView;

/**
 * Created by samnguyen on 5/5/16.
 */
public interface AddADogContract {
    interface View extends BaseView<Presenter> {
        void showView();
        void comeBack();
    }
    interface Presenter extends BasePresenter {
        void loadView();
        void goNext(int page);
        void setIndicatorVisibility(boolean visibility);
        void finish();
        void cancel();
    }

}
