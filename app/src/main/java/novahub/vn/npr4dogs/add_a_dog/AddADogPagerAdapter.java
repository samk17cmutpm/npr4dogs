package novahub.vn.npr4dogs.add_a_dog;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import novahub.vn.npr4dogs.Base;
import novahub.vn.npr4dogs.lib.SmartFragmentStatePagerAdapter;

/**
 * Created by samnguyen on 5/5/16.
 */
public class AddADogPagerAdapter extends SmartFragmentStatePagerAdapter implements Base {
    private AddADogContract.Presenter presenter;
    public AddADogPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }
    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        switch (position) {
            case 0:
                fragment = new StepOneFragment().newInstance();
                presenter = new
                        AddADogPresenter((AddADogContract.View) fragment);
                return fragment;
            case 1:
                fragment = new StepTwoFragment().newInstance();
                presenter = new
                        AddADogPresenter((AddADogContract.View) fragment);
                return fragment;
            case 2:
                fragment = new StepThreeFragment().newInstance();
                presenter = new
                        AddADogPresenter((AddADogContract.View) fragment);
                return fragment;
            case 3:
                fragment = new StepFourFragment().newInstance();
                presenter = new
                        AddADogPresenter((AddADogContract.View) fragment);
                return fragment;
            case 4:
                fragment = new StepFiveFragment().newInstance();
                presenter = new
                        AddADogPresenter((AddADogContract.View) fragment);
                return fragment;
            case 5:
                fragment = new StepSixFragment().newInstance();
                presenter = new
                        AddADogPresenter((AddADogContract.View) fragment);
                return fragment;
            case 6:
                fragment = new StepSevenFragment().newInstance();
                presenter = new
                        AddADogPresenter((AddADogContract.View) fragment);
                return fragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        return ADD_A_DOG;
    }
}
