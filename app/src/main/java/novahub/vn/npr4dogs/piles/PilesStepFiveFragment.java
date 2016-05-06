package novahub.vn.npr4dogs.piles;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import novahub.vn.npr4dogs.BaseFragment;
import novahub.vn.npr4dogs.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PilesStepFiveFragment extends BaseFragment implements PilesContract.View {

    private PilesContract.Presenter presenter;
    private View root;
    public PilesStepFiveFragment() {
        // Required empty public constructor
    }

    public static PilesStepFiveFragment newInstance() {
        PilesStepFiveFragment pilesStepFiveFragment = new PilesStepFiveFragment();
        return pilesStepFiveFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_piles_step_five, container, false);
        return root;
    }

    @Override
    public void showView() {

    }

    @Override
    public void setPresenter(PilesContract.Presenter prensenter) {
        this.presenter = prensenter;
    }
}
