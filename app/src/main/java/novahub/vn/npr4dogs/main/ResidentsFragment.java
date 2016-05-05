package novahub.vn.npr4dogs.main;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import novahub.vn.npr4dogs.Base;
import novahub.vn.npr4dogs.BaseFragment;
import novahub.vn.npr4dogs.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ResidentsFragment extends BaseFragment implements MainContract.BaseResidentsView, Base {

    private MainContract.BaseResidentsPresenter presenter;
    public ResidentsFragment() {
        // Required empty public constructor
    }

    public static ResidentsFragment newInstance() {
        ResidentsFragment residentsFragment = new ResidentsFragment();
        return residentsFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_residents, container, false);
    }

    @Override
    public void showView() {

    }

    @Override
    public void setPresenter(MainContract.BaseResidentsPresenter prensenter) {
        this.presenter = prensenter;
    }
}
