package novahub.vn.npr4dogs.main;

/**
 * Created by samnguyen on 5/5/16.
 */
public class AddADogPresenter implements MainContract.BaseAddADogPresenter {

    private final MainContract.BaseAddADogView addADogView;

    public AddADogPresenter(MainContract.BaseAddADogView addADogView) {
        this.addADogView = addADogView;
        this.addADogView.setPresenter(this);
    }
    @Override
    public void loadView() {

    }

    @Override
    public void start() {

    }
}
