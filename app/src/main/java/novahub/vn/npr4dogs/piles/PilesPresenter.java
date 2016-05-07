package novahub.vn.npr4dogs.piles;

/**
 * Created by samnguyen on 5/6/16.
 */
public class PilesPresenter implements PilesContract.Presenter {

    private final PilesContract.View pilesView;

    public PilesPresenter(PilesContract.View pilesView) {
        this.pilesView = pilesView;
        this.pilesView.setPresenter(this);
    }
    @Override
    public void loadView() {

    }

    @Override
    public void goNext(int page) {
        PilesActivity.viewPager.setCurrentItem(page, true);
    }

    @Override
    public void setIndicatorVisibility(boolean visibility) {

    }

    @Override
    public void finish() {
        pilesView.comeBack();
    }

    @Override
    public void cancel() {

    }

    @Override
    public void start() {

    }
}
