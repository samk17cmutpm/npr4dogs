package novahub.vn.npr4dogs.main;


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

/**
 * A simple {@link Fragment} subclass.
 */
public class PilesDetailFragment extends BaseFragment implements MainContract.BasePilesDetailView, Base {

    private MainContract.BasePilesDetailPresenter presenter;
    private RippleView rippleViewPiles;
    private RippleView rippleViewResidents;
    private View root;
    public PilesDetailFragment() {
        // Required empty public constructor
    }

    public static PilesDetailFragment newInstance() {
        PilesDetailFragment pilesDetailFragment = new PilesDetailFragment();
        return pilesDetailFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_piles_detail, container, false);
        rippleViewPiles = (RippleView) root.findViewById(R.id.rpv_piles);
        rippleViewPiles.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {

            @Override
            public void onComplete(RippleView rippleView) {
                Intent intent = new Intent(getContext(), MainActivity.class);
                intent.putExtra(IS_FROM_ACTION, true);
                intent.putExtra(FROM, FROM_ADD_A_DOG);
                intent.putExtra(PAGE, TAB_RESIDENTS);
                intent.putExtra(CURRENT_TAB, TAB_RESIDENTS);
                getContext().startActivity(intent);
                getActivity().finish();

            }

        });

        rippleViewResidents = (RippleView) root.findViewById(R.id.rvp_residents);
        rippleViewResidents.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {

            @Override
            public void onComplete(RippleView rippleView) {
                Intent intent = new Intent(getContext(), MainActivity.class);
                intent.putExtra(IS_FROM_ACTION, true);
                intent.putExtra(FROM, FROM_ADD_A_DOG);
                intent.putExtra(PAGE, TAB_RESIDENTS);
                intent.putExtra(CURRENT_TAB, TAB_ADD_A_DOG_PAST);
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
    public void setPresenter(MainContract.BasePilesDetailPresenter prensenter) {
        this.presenter = prensenter;
    }
}
