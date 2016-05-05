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
public class PilesFragment extends BaseFragment implements MainContract.BasePilesView, Base {

    private MainContract.BasePilesPresenter presenter;

    public PilesFragment() {
        // Required empty public constructor
    }

    public static PilesFragment newInstance() {
        PilesFragment pilesFragment = new PilesFragment();
        return pilesFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_piles, container, false);
    }

    @Override
    public void showView() {

    }

    @Override
    public void setPresenter(MainContract.BasePilesPresenter prensenter) {
        this.presenter = prensenter;
    }
}
