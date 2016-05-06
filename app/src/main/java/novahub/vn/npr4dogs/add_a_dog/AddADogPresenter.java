package novahub.vn.npr4dogs.add_a_dog;

import android.view.View;

/**
 * Created by samnguyen on 5/6/16.
 */
public class AddADogPresenter implements AddADogContract.Presenter {
    private final AddADogContract.View view;

    public AddADogPresenter(AddADogContract.View view) {
        this.view = view;
        this.view.setPresenter(this);
    }
    @Override
    public void loadView() {

    }

    @Override
    public void goNext(int page) {
        AddADogActivity.viewPager.setCurrentItem(page, true);
    }

    @Override
    public void setIndicatorVisibility(boolean visibility) {
        if (visibility) {
            AddADogActivity.indicator.setVisibility(View.VISIBLE);
        } else {
            AddADogActivity.indicator.setVisibility(View.GONE);
        }
    }

    @Override
    public void start() {

    }
}
