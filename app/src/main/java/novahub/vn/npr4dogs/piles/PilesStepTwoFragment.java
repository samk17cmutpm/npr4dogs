package novahub.vn.npr4dogs.piles;


import android.content.Intent;
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
import novahub.vn.npr4dogs.scan_barcode.ScanBarcodeActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class PilesStepTwoFragment extends BaseFragment implements PilesContract.View, Base {

    private PilesContract.Presenter presenter;
    private View root;
    private RippleView rippleView;
    public PilesStepTwoFragment() {
        // Required empty public constructor
    }

    public static PilesStepTwoFragment newInstance() {
        PilesStepTwoFragment pilesStepTwoFragment = new PilesStepTwoFragment();
        return pilesStepTwoFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_piles_step_two, container, false);
        rippleView = (RippleView) root.findViewById(R.id.rpv_scan_barcode);
        rippleView.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {

            @Override
            public void onComplete(RippleView rippleView) {
                Log.d("Sample", "Ripple completed");
//                presenter.goNext(2);
                Intent intent = new Intent(getContext(), ScanBarcodeActivity.class);
                intent.putExtra(FROM, FROM_PILES);
                intent.putExtra(PAGE, GO_TO_PILES_STEP_THREE);
                getContext().startActivity(intent);
                getActivity().finish();

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
