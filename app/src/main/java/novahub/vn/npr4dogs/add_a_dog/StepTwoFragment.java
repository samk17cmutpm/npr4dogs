package novahub.vn.npr4dogs.add_a_dog;


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
public class StepTwoFragment extends BaseFragment implements AddADogContract.View {
    private AddADogContract.Presenter presenter;
    private View root;
    private RippleView rippleView;

    public StepTwoFragment() {
        // Required empty public constructor
    }

    public static StepTwoFragment newInstance() {
        StepTwoFragment stepTwoFragment = new StepTwoFragment();
        return stepTwoFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_step_two, container, false);
        rippleView = (RippleView) root.findViewById(R.id.rpv_begin_survey);
        rippleView.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {

            @Override
            public void onComplete(RippleView rippleView) {
                Log.d("Sample", "Ripple completed");
                presenter.goNext(2);
                presenter.setIndicatorVisibility(false);
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
