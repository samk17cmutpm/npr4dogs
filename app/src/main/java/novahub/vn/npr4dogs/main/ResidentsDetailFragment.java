package novahub.vn.npr4dogs.main;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import novahub.vn.npr4dogs.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ResidentsDetailFragment extends Fragment implements MainContract.BaseResidentsDetailView{

    private MainContract.BaseResidentsDetailPresenter presenter;

    public ResidentsDetailFragment() {
        // Required empty public constructor
    }

    public static ResidentsDetailFragment newInstance() {
        ResidentsDetailFragment residentsDetailFragment = new ResidentsDetailFragment();
        return residentsDetailFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_residents_detail, container, false);
    }

    @Override
    public void showView() {

    }

    @Override
    public void setPresenter(MainContract.BaseResidentsDetailPresenter prensenter) {
        this.presenter = prensenter;
    }
}
