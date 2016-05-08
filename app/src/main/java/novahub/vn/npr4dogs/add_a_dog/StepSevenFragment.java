package novahub.vn.npr4dogs.add_a_dog;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andexert.library.RippleView;

import novahub.vn.npr4dogs.Base;
import novahub.vn.npr4dogs.R;
import novahub.vn.npr4dogs.main.MainActivity;
import novahub.vn.npr4dogs.utils.Cookie;

/**
 * A simple {@link Fragment} subclass.
 */
public class StepSevenFragment extends Fragment implements AddADogContract.View, Base{

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
                Cookie.isDoneAddADog = true;
                presenter.finish();
            }

        });
        return root;
    }

    @Override
    public void showView() {

    }

    @Override
    public void comeBack() {
        Intent intent = new Intent(getContext(), MainActivity.class);
        intent.putExtra(IS_FROM_ACTION, true);
        intent.putExtra(FROM, FROM_ADD_A_DOG);
        intent.putExtra(PAGE, TAB_ADD_A_DOG_PAST);
        intent.putExtra(CURRENT_TAB, TAB_RESIDENTS);
        getContext().startActivity(intent);
        getActivity().finish();
    }

    @Override
    public void setPresenter(AddADogContract.Presenter prensenter) {
        this.presenter = prensenter;
    }
}
