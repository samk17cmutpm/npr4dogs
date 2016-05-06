package novahub.vn.npr4dogs.add_a_dog;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.andexert.library.RippleView;

import me.relex.circleindicator.CircleIndicator;
import novahub.vn.npr4dogs.R;
import novahub.vn.npr4dogs.lib.NonSwipeableViewPager;
import novahub.vn.npr4dogs.main.MainActivity;
import novahub.vn.npr4dogs.main.MainTabsPagerAdapter;

public class AddADogActivity extends AppCompatActivity {

    public static NonSwipeableViewPager viewPager;
    public static CircleIndicator indicator;
    private AddADogPresenter addADogPresenter;
    private RippleView rippleViewCancel;

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

        rippleViewCancel = (RippleView) findViewById(R.id.rpv_cancel);
        rippleViewCancel.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
            @Override
            public void onComplete(RippleView rippleView) {
                Intent intent = new Intent(AddADogActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }

        });


    }

}
