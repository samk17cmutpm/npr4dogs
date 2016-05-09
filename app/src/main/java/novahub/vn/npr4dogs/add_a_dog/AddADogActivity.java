package novahub.vn.npr4dogs.add_a_dog;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.andexert.library.RippleView;

import me.relex.circleindicator.CircleIndicator;
import novahub.vn.npr4dogs.Base;
import novahub.vn.npr4dogs.R;
import novahub.vn.npr4dogs.lib.NonSwipeableViewPager;
import novahub.vn.npr4dogs.main.MainActivity;

public class AddADogActivity extends AppCompatActivity implements Base {

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

        rippleViewCancel = (RippleView) findViewById(R.id.rpv_done);
        rippleViewCancel.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
            @Override
            public void onComplete(RippleView rippleView) {
                Intent intent = new Intent(AddADogActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }

        });


        boolean isFromAction = getIntent().getBooleanExtra(IS_FROM_ACTION, false);
        if (isFromAction) {
            int page = getIntent().getIntExtra(PAGE, 0);
            viewPager.setCurrentItem(page, false);
        }

    }

    public void comeBack(int page) {

        Intent intent = new Intent(AddADogActivity.this, MainActivity.class);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(AddADogActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
