package novahub.vn.npr4dogs.main;


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
import novahub.vn.npr4dogs.piles.PilesActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class PilesFragment extends BaseFragment implements MainContract.BasePilesView, Base {

    private MainContract.BasePilesPresenter presenter;
    private View root;
    private RippleView rippleView;

    public PilesFragment() {
        // Required empty public constructor
    }

    public static PilesFragment newInstance() {
        PilesFragment pilesFragment = new PilesFragment();
        return pilesFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_piles, container, false);
        rippleView = (RippleView) root.findViewById(R.id.abcddd);
        rippleView.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {

            @Override
            public void onComplete(RippleView rippleView) {
                presenter.loadPiles();
            }

        });
        return root;
    }

    @Override
    public void showView() {

    }

    @Override
    public void showPiles() {
        Intent intent = new Intent(getContext(), PilesActivity.class);
        getContext().startActivity(intent);
    }

    @Override
    public void setPresenter(MainContract.BasePilesPresenter prensenter) {
        this.presenter = prensenter;
    }
}
