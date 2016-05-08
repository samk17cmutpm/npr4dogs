package novahub.vn.npr4dogs.main;

/**
 * Created by samnguyen on 5/4/16.
 */
public class MainPresenter implements MainContract.Presenter{
    private final MainContract.View mainView;
    private final String TAG = "MainPresenter";

    public MainPresenter(MainContract.View mainView) {
        this.mainView = mainView;
        this.mainView.setPresenter(this);
    }

    @Override
    public void loadBottomNavigation() {
        mainView.showBottomNavigation();
    }

    @Override
    public void loadViewPagers() {
        mainView.showViewPagers();
    }

    @Override
    public void loadTabDetails(int position) {
        mainView.showTabDetails(position);
    }

    @Override
    public void loadTabBottomWithoutAction() {

    }

    @Override
    public void start() {

    }
}
