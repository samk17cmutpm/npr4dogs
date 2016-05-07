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
public class PilesStepThreeFragment extends BaseFragment implements PilesContract.View, Base {

    private PilesContract.Presenter presenter;
    private View root;
    private RippleView rippleView;

    public PilesStepThreeFragment() {
        // Required empty public constructor
    }

    public static PilesStepThreeFragment newInstance() {
        PilesStepThreeFragment pilesStepThreeFragment = new PilesStepThreeFragment();
        return pilesStepThreeFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_piles_step_three, container, false);
        rippleView = (RippleView) root.findViewById(R.id.rpv_take_photo);
        rippleView.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {

            @Override
            public void onComplete(RippleView rippleView) {
                Log.d("Sample", "Ripple completed");
                presenter.goNext(3);
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
