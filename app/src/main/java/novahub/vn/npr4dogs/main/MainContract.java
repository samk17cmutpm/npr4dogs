package novahub.vn.npr4dogs.main;

import novahub.vn.npr4dogs.BasePresenter;
import novahub.vn.npr4dogs.BaseView;

/**
 * Created by samnguyen on 5/4/16.
 */
public interface MainContract {

    interface View extends BaseView<Presenter> {
        void showBottomNavigation();
        void showViewPagers();
        void showTabDetails(int position);
    }

    interface Presenter extends BasePresenter {
        void loadBottomNavigation();
        void loadViewPagers();
        void loadTabDetails(int position);

    }

    interface BaseAddADogView extends BaseView<BaseAddADogPresenter> {
        void showView();
    }

    interface BaseAddADogPresenter extends BasePresenter {
        void loadView();
    }


    interface BasePilesView extends BaseView<BasePilesPresenter> {
        void showView();
    }

    interface BasePilesPresenter extends BasePresenter {
        void loadView();
    }

    interface BaseResidentsView extends BaseView<BaseResidentsPresenter> {
        void showView();
    }

    interface BaseResidentsPresenter extends BasePresenter {
        void loadView();
    }

    interface BaseSettingsView extends BaseView<BaseSettingsPresenter> {
        void showView();
    }

    interface BaseSettingsPresenter extends BasePresenter {
        void loadView();
    }
}
