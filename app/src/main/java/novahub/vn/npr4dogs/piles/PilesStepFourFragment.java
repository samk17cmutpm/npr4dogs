package novahub.vn.npr4dogs.piles;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andexert.library.RippleView;

import novahub.vn.npr4dogs.BaseFragment;
import novahub.vn.npr4dogs.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PilesStepFourFragment extends BaseFragment implements PilesContract.View {

    private PilesContract.Presenter presenter;
    private View root;
    private RippleView rippleView;

    public PilesStepFourFragment() {
            // Required empty public constructor
    }

    public static PilesStepFourFragment newInstance() {
        PilesStepFourFragment pilesStepFourFragment = new PilesStepFourFragment();
        return pilesStepFourFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_piles_step_four, container, false);
        rippleView = (RippleView) root.findViewById(R.id.rpv_next);
        rippleView.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {

            @Override
            public void onComplete(RippleView rippleView) {
                Log.d("Sample", "Ripple completed");
                presenter.goNext(4);
            }

        });
        return root;
    }

    @Override
    public void showView() {

    }

    @Override
    public void comeBack() {

    }

    @Override
    public void setPresenter(PilesContract.Presenter prensenter) {
        this.presenter = prensenter;
    }
}
