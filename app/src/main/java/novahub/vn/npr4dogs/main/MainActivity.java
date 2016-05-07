package novahub.vn.npr4dogs.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import novahub.vn.npr4dogs.Base;
import novahub.vn.npr4dogs.R;
import novahub.vn.npr4dogs.utils.ActivityUtils;

public class MainActivity extends AppCompatActivity implements Base{
    private MainContract.Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainFragment mainFragment =
                    (MainFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);

        if (mainFragment == null) {

            int page = getIntent().getIntExtra(PAGE, 0);
            if (page == 1) {
                mainFragment = MainFragment.newInstance(true, 4);
            } else {
                mainFragment = MainFragment.newInstance(false, 0);
            }
            ActivityUtils.addFragmentToActivity(
                getSupportFragmentManager(), mainFragment, R.id.contentFrame
            );
        }
        presenter = new MainPresenter(mainFragment);







    }


}
