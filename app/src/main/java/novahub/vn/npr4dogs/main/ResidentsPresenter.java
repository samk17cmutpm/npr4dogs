package novahub.vn.npr4dogs.main;

/**
 * Created by samnguyen on 5/5/16.
 */
public class ResidentsPresenter implements MainContract.BaseResidentsPresenter {

    private final MainContract.BaseResidentsView residentsView;

    public ResidentsPresenter(MainContract.BaseResidentsView residentsView) {
        this.residentsView = residentsView;
        this.residentsView.setPresenter(this);
    }
    @Override
    public void loadView() {

    }

    @Override
    public void start() {

    }
}
