package novahub.vn.npr4dogs.add_a_dog;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andexert.library.RippleView;

import novahub.vn.npr4dogs.Base;
import novahub.vn.npr4dogs.BaseFragment;
import novahub.vn.npr4dogs.R;
import novahub.vn.npr4dogs.card_io.ScanCardIOActivity;
import novahub.vn.npr4dogs.take_photo.TakeAPhotoActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class StepFourFragment extends BaseFragment implements AddADogContract.View, Base {

    private AddADogContract.Presenter presenter;
    private View root;
    private RippleView rippleView;
    public StepFourFragment() {
        // Required empty public constructor
    }

    public static StepFourFragment newInstance() {
        StepFourFragment stepFourFragment = new StepFourFragment();
        return stepFourFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_step_four, container, false);
        rippleView = (RippleView) root.findViewById(R.id.rpv_take_photo_dog);
        rippleView.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {

            @Override
            public void onComplete(RippleView rippleView) {
                Intent intent = new Intent(getContext(), TakeAPhotoActivity.class);
                intent.putExtra(FROM, FROM_ADD_A_DOG);
                intent.putExtra(PAGE, GO_TO_TAKE_PHOTO_OWNER);
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
