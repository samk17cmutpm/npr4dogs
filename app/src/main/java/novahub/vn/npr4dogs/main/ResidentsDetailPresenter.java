package novahub.vn.npr4dogs.main;

/**
 * Created by samnguyen on 5/7/16.
 */
public class ResidentsDetailPresenter implements MainContract.BaseResidentsDetailPresenter{

    private final MainContract.BaseResidentsDetailView residentsDetailView;

    public ResidentsDetailPresenter(MainContract.BaseResidentsDetailView residentsDetailView) {
        this.residentsDetailView = residentsDetailView;
        this.residentsDetailView.setPresenter(this);
    }
    @Override
    public void loadView() {

    }

    @Override
    public void start() {

    }
}
