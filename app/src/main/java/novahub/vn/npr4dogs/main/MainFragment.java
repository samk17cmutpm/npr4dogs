package novahub.vn.npr4dogs.main;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;

import novahub.vn.npr4dogs.Base;
import novahub.vn.npr4dogs.BaseFragment;
import novahub.vn.npr4dogs.R;
import novahub.vn.npr4dogs.lib.NonSwipeableViewPager;
import novahub.vn.npr4dogs.utils.ActivityUtils;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends BaseFragment implements MainContract.View, Base {

    private MainContract.Presenter presenter;
    private View root;
    private NonSwipeableViewPager viewPager;
    private boolean from;
    private int page;
    private AHBottomNavigation bottomNavigation;

    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment newInstance(boolean from, int page) {

        MainFragment mainFragment = new MainFragment();
        Bundle args = new Bundle();
        args.putInt(PAGE, page);
        args.putBoolean(FROM, from);
        mainFragment.setArguments(args);
        return mainFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_main, container, false);
        page = getArguments().getInt(PAGE, 0);
        from = getArguments().getBoolean(FROM, false);
        presenter.loadBottomNavigation();
        presenter.loadViewPagers();
        if (from) {
            presenter.loadTabDetails(page);
        } else {
            bottomNavigation.setCurrentItem(0);
        }
        return root;
    }

    @Override
    public void showBottomNavigation() {

        bottomNavigation = (AHBottomNavigation) root.findViewById(R.id.bottom_navigation);

        // Create items
        AHBottomNavigationItem tabAddADog =
                new AHBottomNavigationItem(R.string.tab_add_a_dog, R.drawable.add_a_dog_icon, R.color.tab_background);

        AHBottomNavigationItem tabPiles =
                new AHBottomNavigationItem(R.string.tab_piles, R.drawable.ic_apps_black_24dp, R.color.tab_background);

        AHBottomNavigationItem tabResidents =
                new AHBottomNavigationItem(R.string.tab_residents, R.drawable.residents_icon, R.color.tab_background);

        AHBottomNavigationItem tabSettings =
                new AHBottomNavigationItem(R.string.tab_setting, R.drawable.settings_icon, R.color.tab_background);

        // Add items
        bottomNavigation.addItem(tabAddADog);
        bottomNavigation.addItem(tabPiles);
        bottomNavigation.addItem(tabResidents);
        bottomNavigation.addItem(tabSettings);

        // Set background color
        bottomNavigation.setDefaultBackgroundColor(Color.parseColor("#3C9A06"));

        // Disable the translation inside the CoordinatorLayout
        bottomNavigation.setBehaviorTranslationEnabled(false);

        // Change colors
        bottomNavigation.setAccentColor(Color.parseColor("#3C9A06"));
        bottomNavigation.setInactiveColor(Color.parseColor("#3C9A06"));

        // Force to tint the drawable (useful for font with icon for example)
        bottomNavigation.setForceTint(true);


        // Force the titles to be displayed (against Material Design guidelines!)
        bottomNavigation.setForceTitlesDisplay(true);

        // Use colored navigation with circle reveal effect
        bottomNavigation.setColored(true);

        // Set current item programmatically

        // Customize notification (title, background, typeface)
        bottomNavigation.setNotificationBackgroundColor(Color.parseColor("#FF4081"));

        // Set listener
        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position, boolean wasSelected) {
                presenter.loadTabDetails(position);
            }
        });
    }

    @Override
    public void showViewPagers() {
        viewPager = (NonSwipeableViewPager) root.findViewById(R.id.viewpager);
        viewPager.setAdapter(new MainTabsPagerAdapter(getFragmentManager()));
    }

    @Override
    public void showTabDetails(int position) {
        viewPager.setCurrentItem(position, false);
    }

    @Override
    public void setPresenter(MainContract.Presenter prensenter) {
        this.presenter = prensenter;

    }

    @Override
    public void onResume() {
        super.onResume();
        this.presenter.start();
    }
}
