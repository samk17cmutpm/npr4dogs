package novahub.vn.npr4dogs.add_a_dog;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import me.relex.circleindicator.CircleIndicator;
import novahub.vn.npr4dogs.R;
import novahub.vn.npr4dogs.lib.NonSwipeableViewPager;
import novahub.vn.npr4dogs.main.MainTabsPagerAdapter;

public class AddADogActivity extends AppCompatActivity {

    public static NonSwipeableViewPager viewPager;
    public static CircleIndicator indicator;
    private AddADogPresenter addADogPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_adog);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        AddADogPagerAdapter addADogPagerAdapter = new AddADogPagerAdapter(getSupportFragmentManager());

        viewPager = (NonSwipeableViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(addADogPagerAdapter);

        indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(viewPager);
        addADogPagerAdapter.registerDataSetObserver(indicator.getDataSetObserver());


    }

}
