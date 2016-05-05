package novahub.vn.npr4dogs.main;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import novahub.vn.npr4dogs.BaseFragment;
import novahub.vn.npr4dogs.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddADogFragment extends BaseFragment implements MainContract.BaseAddADogView {

    private MainContract.BaseAddADogPresenter presenter;
    private View root;
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
        return root;
    }

    @Override
    public void showView() {

    }

    @Override
    public void setPresenter(MainContract.BaseAddADogPresenter prensenter) {
        this.presenter = prensenter;
    }

}
