package novahub.vn.npr4dogs.main;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andexert.library.RippleView;

import novahub.vn.npr4dogs.Base;
import novahub.vn.npr4dogs.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ResidentsDetailFragment extends Fragment implements MainContract.BaseResidentsDetailView, Base{

    private MainContract.BaseResidentsDetailPresenter presenter;
    private RippleView rippleViewCancel;
    private RippleView rippleViewDone;
    private View root;

    public ResidentsDetailFragment() {
        // Required empty public constructor
    }

    public static ResidentsDetailFragment newInstance() {
        ResidentsDetailFragment residentsDetailFragment = new ResidentsDetailFragment();
        return residentsDetailFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_residents_detail, container, false);
        rippleViewCancel = (RippleView) root.findViewById(R.id.rpv_cancel);
        rippleViewCancel.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {

            @Override
            public void onComplete(RippleView rippleView) {
                Intent intent = new Intent(getContext(), MainActivity.class);
                intent.putExtra(IS_FROM_ACTION, true);
                intent.putExtra(FROM, FROM_ADD_A_DOG);
                intent.putExtra(PAGE, TAB_ADD_A_DOG_PAST);
                intent.putExtra(CURRENT_TAB, TAB_RESIDENTS);
                getContext().startActivity(intent);
                getActivity().finish();
            }

        });

        rippleViewDone = (RippleView) root.findViewById(R.id.rpv_done);
        rippleViewDone.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {

            @Override
            public void onComplete(RippleView rippleView) {
                Intent intent = new Intent(getContext(), MainActivity.class);
                intent.putExtra(IS_FROM_ACTION, true);
                intent.putExtra(FROM, FROM_ADD_A_DOG);
                intent.putExtra(PAGE, TAB_ADD_A_DOG_PAST);
                intent.putExtra(CURRENT_TAB, TAB_RESIDENTS);
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
    public void setPresenter(MainContract.BaseResidentsDetailPresenter prensenter) {
        this.presenter = prensenter;
    }
}
