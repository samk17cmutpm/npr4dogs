package novahub.vn.npr4dogs.add_a_dog;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andexert.library.RippleView;

import novahub.vn.npr4dogs.BaseFragment;
import novahub.vn.npr4dogs.R;
import novahub.vn.npr4dogs.scan_barcode.ScanBarcodeActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class StepOneFragment extends BaseFragment implements AddADogContract.View{
    private AddADogContract.Presenter presenter;
    private View root;
    private RippleView rippleView;

    public StepOneFragment() {
        // Required empty public constructor
    }

    public static StepOneFragment newInstance() {
        StepOneFragment stepOneFragment = new StepOneFragment();
        return stepOneFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_step_one, container, false);
        rippleView = (RippleView) root.findViewById(R.id.rpv_scan_barcode);
        rippleView.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {

            @Override
            public void onComplete(RippleView rippleView) {
                Intent intent = new Intent(getContext(), ScanBarcodeActivity.class);
                getContext().startActivity(intent);
                getActivity().finish();
//                presenter.goNext(1);
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
    public void setPresenter(AddADogContract.Presenter prensenter) {
        this.presenter = prensenter;
    }
}
