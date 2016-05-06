package novahub.vn.npr4dogs.add_a_dog;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andexert.library.RippleView;

import novahub.vn.npr4dogs.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class StepSevenFragment extends Fragment implements AddADogContract.View {

    private AddADogContract.Presenter presenter;
    private View root;
    private RippleView rippleView;
    public StepSevenFragment() {
        // Required empty public constructor
    }

    public static StepSevenFragment newInstance() {
        StepSevenFragment stepSevenFragment = new StepSevenFragment();
        return stepSevenFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_step_seven, container, false);
        rippleView = (RippleView) root.findViewById(R.id.rpv_finish);
        rippleView.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {

            @Override
            public void onComplete(RippleView rippleView) {

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
