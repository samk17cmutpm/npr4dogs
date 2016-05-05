package novahub.vn.npr4dogs.main;

/**
 * Created by samnguyen on 5/5/16.
 */
public class PilesPresenter implements MainContract.BasePilesPresenter {

    private final MainContract.BasePilesView pilesView;

    public PilesPresenter(MainContract.BasePilesView pilesView) {
        this.pilesView = pilesView;
        this.pilesView.setPresenter(this);
    }
    @Override
    public void loadView() {

    }

    @Override
    public void start() {

    }
}
