package novahub.vn.npr4dogs.add_a_dog;


import android.app.ProgressDialog;
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
import novahub.vn.npr4dogs.card_io.ScanCardIOActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class StepThreeFragment extends BaseFragment implements AddADogContract.View, Base {
    private AddADogContract.Presenter presenter;
    private View root;
    private RippleView rippleView;
    private RippleView rippleViewScanCardIO;
    public StepThreeFragment() {
        // Required empty public constructor
    }

    public static StepThreeFragment newInstance() {
        StepThreeFragment stepThreeFragment = new StepThreeFragment();
        return stepThreeFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_step_three, container, false);
        rippleView = (RippleView) root.findViewById(R.id.rpv_pay_pee);
        rippleView.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {

            @Override
            public void onComplete(RippleView rippleView) {
                presenter.goNext(3);
                presenter.setIndicatorVisibility(true);
            }

        });

        rippleViewScanCardIO = (RippleView) root.findViewById(R.id.rpv_scan_card_io);

        rippleViewScanCardIO.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {

            @Override
            public void onComplete(RippleView rippleView) {
                ProgressDialog progressDialog = new ProgressDialog(getContext());
                progressDialog.setIndeterminate(true);
                progressDialog.setMessage("Please wait ");
                progressDialog.show();
                Intent intent = new Intent(getContext(), ScanCardIOActivity.class);
                intent.putExtra(FROM, FROM_ADD_A_DOG);
                intent.putExtra(PAGE, GO_TO_TAKE_PHOTO_DOG);
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
    public void setPresenter(AddADogContract.Presenter prensenter) {
        this.presenter = prensenter;
    }
}
