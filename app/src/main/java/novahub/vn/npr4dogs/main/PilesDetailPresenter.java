package novahub.vn.npr4dogs.main;

/**
 * Created by samnguyen on 5/8/16.
 */
public class PilesDetailPresenter implements MainContract.BasePilesDetailPresenter {

    private final MainContract.BasePilesDetailView pilesDetailView;

    public PilesDetailPresenter(MainContract.BasePilesDetailView pilesDetailView) {
        this.pilesDetailView = pilesDetailView;
        this.pilesDetailView.setPresenter(this);
    }
    @Override
    public void loadView() {

    }

    @Override
    public void start() {

    }
}
