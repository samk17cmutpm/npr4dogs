package novahub.vn.npr4dogs.piles;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import novahub.vn.npr4dogs.Base;
import novahub.vn.npr4dogs.lib.SmartFragmentStatePagerAdapter;

/**
 * Created by samnguyen on 5/6/16.
 */
public class PilesPagerAdapter extends SmartFragmentStatePagerAdapter implements Base {
    private PilesContract.Presenter presenter;

    public PilesPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        switch (position) {
            case 0:
                fragment = new PilesStepOneFragment().newInstance();
                presenter = new
                        PilesPresenter((PilesContract.View) fragment);
                return fragment;
            case 1:
                fragment = new PilesStepTwoFragment().newInstance();
                presenter = new
                        PilesPresenter((PilesContract.View) fragment);
                return fragment;
            case 2:
                fragment = new PilesStepThreeFragment().newInstance();
                presenter = new
                        PilesPresenter((PilesContract.View) fragment);
                return fragment;
            case 3:
                fragment = new PilesStepFourFragment().newInstance();
                presenter = new
                        PilesPresenter((PilesContract.View) fragment);
                return fragment;
            case 4:
                fragment = new PilesStepFiveFragment().newInstance();
                presenter = new
                        PilesPresenter((PilesContract.View) fragment);
                return fragment;

        }
        return null;
    }

    @Override
    public int getCount() {
        return PILES;
    }
}
