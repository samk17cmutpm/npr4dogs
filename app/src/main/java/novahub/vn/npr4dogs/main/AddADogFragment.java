package novahub.vn.npr4dogs.main;


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
import novahub.vn.npr4dogs.add_a_dog.AddADogActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddADogFragment extends BaseFragment implements MainContract.BaseAddADogView {

    private MainContract.BaseAddADogPresenter presenter;
    private View root;
    private RippleView rippleViewAddADog;
    public AddADogFragment() {
        // Required empty public constructor
    }

    public static AddADogFragment newInstance() {
        AddADogFragment addADogFragment = new AddADogFragment();
        return addADogFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_add_adog, container, false);
        rippleViewAddADog = (RippleView) root.findViewById(R.id.rpv_add_a_dog);
        rippleViewAddADog.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {

            @Override
            public void onComplete(RippleView rippleView) {
                Log.d("Sample", "Ripple completed");
                presenter.addADog();
            }

        });
        return root;
    }

    @Override
    public void showView() {

    }

    @Override
    public void goToAddADog() {
        Intent intent = new Intent(getContext(), AddADogActivity.class);
        getContext().startActivity(intent);
    }

    @Override
    public void setPresenter(MainContract.BaseAddADogPresenter prensenter) {
        this.presenter = prensenter;
    }

}
