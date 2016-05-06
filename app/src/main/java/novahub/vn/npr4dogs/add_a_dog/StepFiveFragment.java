package novahub.vn.npr4dogs.add_a_dog;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andexert.library.RippleView;

import novahub.vn.npr4dogs.BaseFragment;
import novahub.vn.npr4dogs.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class StepFiveFragment extends BaseFragment implements AddADogContract.View {

    private AddADogContract.Presenter presenter;
    private View root;
    private RippleView rippleView;
    public StepFiveFragment() {
        // Required empty public constructor
    }

    public static StepFiveFragment newInstance() {
        StepFiveFragment stepFiveFragment = new StepFiveFragment();
        return stepFiveFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_step_five, container, false);
        rippleView = (RippleView) root.findViewById(R.id.rpv_take_photo_owner);
        rippleView.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {

            @Override
            public void onComplete(RippleView rippleView) {
                presenter.goNext(5);
            }

        });
        return root;
    }

    @Override
    public void showView() {

    }

    @Override
    public void setPresenter(AddADogContract.Presenter prensenter) {
        this.presenter = prensenter;
    }
}
