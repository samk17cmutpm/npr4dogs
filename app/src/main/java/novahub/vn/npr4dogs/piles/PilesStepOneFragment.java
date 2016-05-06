package novahub.vn.npr4dogs.piles;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andexert.library.RippleView;

import novahub.vn.npr4dogs.Base;
import novahub.vn.npr4dogs.BaseFragment;
import novahub.vn.npr4dogs.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PilesStepOneFragment extends BaseFragment implements PilesContract.View, Base {

    private PilesContract.Presenter presenter;
    private View root;
    private RippleView rippleView;

    public PilesStepOneFragment() {
        // Required empty public constructor
    }
    public static PilesStepOneFragment newInstance() {
        PilesStepOneFragment pilesStepOneFragment = new PilesStepOneFragment();
        return pilesStepOneFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_piles_step_one, container, false);
        rippleView = (RippleView) root.findViewById(R.id.rpv_next);
        rippleView.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {

            @Override
            public void onComplete(RippleView rippleView) {
                Log.d("Sample", "Ripple completed");
                presenter.goNext(1);
            }

        });
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
