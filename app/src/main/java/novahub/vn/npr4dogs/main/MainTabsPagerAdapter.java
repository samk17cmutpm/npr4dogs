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
    private AddADogPastPresenter addADogPastPresenter;
    private TestANewPilePresenter testANewPilePresenter;
    private ResidentsDetailPresenter residentsDetailPresenter;
    private PilesDetailPresenter pilesDetailPresenter;
    private final int position;

    public MainTabsPagerAdapter(FragmentManager fragmentManager, int position) {
        super(fragmentManager);
        this.position = position;
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
            case 4:
                fragment = new AddADogPastFragment().newInstance();
                addADogPastPresenter = new
                        AddADogPastPresenter((MainContract.BaseAddADogPastView) fragment);
                return fragment;
            case 5:
                fragment = new TestANewPileFragment().newInstance();
                testANewPilePresenter = new
                        TestANewPilePresenter((MainContract.BaseTestANewPileView) fragment);
                return fragment;
            case 6:
                fragment = new ResidentsDetailFragment().newInstance();
                residentsDetailPresenter = new
                        ResidentsDetailPresenter((MainContract.BaseResidentsDetailView) fragment);
                return fragment;
            case 7:
                fragment = new PilesDetailFragment().newInstance(this.position);
                pilesDetailPresenter = new
                        PilesDetailPresenter((MainContract.BasePilesDetailView) fragment);
                return fragment;

        }
        return null;
    }

    @Override
    public int getCount() {
        return TABS;
    }

}
