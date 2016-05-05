package novahub.vn.npr4dogs.main;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import novahub.vn.npr4dogs.data.Resident;

/**
 * Created by samnguyen on 5/5/16.
 */
public class ResidentsPresenter implements MainContract.BaseResidentsPresenter {

    private final MainContract.BaseResidentsView residentsView;

    public ResidentsPresenter(MainContract.BaseResidentsView residentsView) {
        this.residentsView = residentsView;
        this.residentsView.setPresenter(this);
    }
    @Override
    public void loadView() {

    }

    @Override
    public void loadSegments() {
        residentsView.showSegments();
    }

    @Override
    public void loadViewPagers() {
        residentsView.showViewPagers();
    }

    @Override
    public void loadRecyclerView() {
        List<Resident> residents = new ArrayList<>();
        for ( int i = 0; i < 15; i++) {
            residents.add(new Resident("" + i, "sam"));
            Log.d("===>", "" + i);
        }
        residentsView.showRecyclerView(residents);
    }

    @Override
    public void start() {

    }
}
