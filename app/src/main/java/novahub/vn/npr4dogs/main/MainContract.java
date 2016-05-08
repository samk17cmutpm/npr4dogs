package novahub.vn.npr4dogs.main;

import java.util.List;

import novahub.vn.npr4dogs.BasePresenter;
import novahub.vn.npr4dogs.BaseView;
import novahub.vn.npr4dogs.data.Pile;
import novahub.vn.npr4dogs.data.Resident;

/**
 * Created by samnguyen on 5/4/16.
 */
public interface MainContract {

    interface View extends BaseView<Presenter> {
        void showBottomNavigation();
        void showViewPagers();
        void showTabDetails(int position);
        void showTabBottomWithoutAction();
    }

    interface Presenter extends BasePresenter {
        void loadBottomNavigation();
        void loadViewPagers();
        void loadTabDetails(int position);
        void loadTabBottomWithoutAction();

    }

    interface BaseAddADogView extends BaseView<BaseAddADogPresenter> {
        void showView();
        void goToAddADog();
    }

    interface BaseAddADogPresenter extends BasePresenter {
        void loadView();
        void addADog();
    }


    interface BasePilesView extends BaseView<BasePilesPresenter> {
        void showView();
        void showPiles();
    }

    interface BasePilesPresenter extends BasePresenter {
        void loadView();
        void loadPiles();
    }

    interface BaseResidentsView extends BaseView<BaseResidentsPresenter> {
        void showView();
        void showSegments();
        void showViewPagers();
        void showRecyclerView(List<Resident> residents);
    }

    interface BaseResidentsPresenter extends BasePresenter {
        void loadView();
        void loadSegments();
        void loadViewPagers();
        void loadRecyclerView();
    }

    interface BaseSettingsView extends BaseView<BaseSettingsPresenter> {
        void showView();
    }

    interface BaseSettingsPresenter extends BasePresenter {
        void loadView();
    }

    interface BaseAddADogPastView extends BaseView<BaseAddADogPastPresenter> {
        void showView();
    }

    interface BaseAddADogPastPresenter extends BasePresenter {
        void loadView();
    }

    interface BaseTestANewPileView extends BaseView<BaseTestANewPilePresenter> {
        void showView();
        void showRecyclerView(List<Pile> piles);
    }

    interface BaseTestANewPilePresenter extends BasePresenter {
        void loadView();
        void loadRecyclerView();
    }

    interface BaseResidentsDetailView extends BaseView<BaseResidentsDetailPresenter> {
        void showView();
    }

    interface BaseResidentsDetailPresenter extends BasePresenter {
        void loadView();
    }

    interface BasePilesDetailView extends BaseView<BasePilesDetailView> {
        void showView();
    }

    interface BasePilesDetailPresenter extends BasePresenter {
        void loadView();
    }

}
