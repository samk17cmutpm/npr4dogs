package novahub.vn.npr4dogs.main;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

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
    private RelativeLayout relativeLayoutResidentMoveOut;
    private RelativeLayout relativeLayoutDogMoveOut;

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

        rippleViewDone = (RippleView) root.findViewById(R.id.rpv_cancel);
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

        relativeLayoutResidentMoveOut = (RelativeLayout) root.findViewById(R.id.resident_move_out);
        relativeLayoutDogMoveOut = (RelativeLayout) root.findViewById(R.id.dog_move_out);

        relativeLayoutResidentMoveOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Residents move out", Toast.LENGTH_SHORT).show();
            }
        });

        relativeLayoutDogMoveOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Dogs move out", Toast.LENGTH_SHORT).show();
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
