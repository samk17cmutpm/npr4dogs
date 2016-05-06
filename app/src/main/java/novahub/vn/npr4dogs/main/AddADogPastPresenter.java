package novahub.vn.npr4dogs.main;

/**
 * Created by samnguyen on 5/6/16.
 */
public class AddADogPastPresenter implements MainContract.BaseAddADogPastPresenter {
    private final MainContract.BaseAddADogPastView baseAddADogPastView;

    public AddADogPastPresenter(MainContract.BaseAddADogPastView baseAddADogPastView) {
        this.baseAddADogPastView = baseAddADogPastView;
        this.baseAddADogPastView.setPresenter(this);
    }
    @Override
    public void loadView() {

    }

    @Override
    public void start() {

    }
}
