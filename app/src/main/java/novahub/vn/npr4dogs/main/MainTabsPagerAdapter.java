package novahub.vn.npr4dogs.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import novahub.vn.npr4dogs.Base;
import novahub.vn.npr4dogs.lib.SmartFragmentStatePagerAdapter;

/**
 * Created by samnguyen on 5/5/16.
 */
public class MainTabsPagerAdapter extends SmartFragmentStatePagerAdapter implements Base{

    private AddADogPresenter addADogPresenter;
    private PilesPresenter pilesPresenter;
    private ResidentsPresenter residentsPresenter;
    private SettingsPresenter settingsPresenter;

    public MainTabsPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }
    @Override
    public Fragment getItem(int position) {
        Fragment fragment;

        switch (position) {
            case 0:
                fragment = new AddADogFragment().newInstance();
                addADogPresenter = new
                        AddADogPresenter((MainContract.BaseAddADogView) fragment);
                return fragment;
            case 1:
                fragment = new PilesFragment().newInstance();
                pilesPresenter = new
                        PilesPresenter((MainContract.BasePilesView) fragment);
                return fragment;
            case 2:
                fragment = new ResidentsFragment().newInstance();
                residentsPresenter = new
                        ResidentsPresenter((MainContract.BaseResidentsView) fragment);
                return fragment;
            case 3:
                fragment = new SettingsFragment().newInstance();
                settingsPresenter = new
                        SettingsPresenter((MainContract.BaseSettingsView) fragment);
                return fragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        return TABS;
    }

}
