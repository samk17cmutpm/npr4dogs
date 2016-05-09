package novahub.vn.npr4dogs.main;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

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
    private int position;
    private RelativeLayout relativeLayout;
    private TextView textViewIndetify;
    public PilesDetailFragment() {
        // Required empty public constructor
    }

    public static PilesDetailFragment newInstance(int position) {
        PilesDetailFragment pilesDetailFragment = new PilesDetailFragment();
        Bundle args = new Bundle();
        args.putInt(POSITION, position);
        pilesDetailFragment.setArguments(args);
        return pilesDetailFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_piles_detail, container, false);
        position = getArguments().getInt(POSITION, MATCH_FOUND);
        rippleViewPiles = (RippleView) root.findViewById(R.id.resident_move_out);
        rippleViewPiles.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {

            @Override
            public void onComplete(RippleView rippleView) {
                Intent intent = new Intent(getContext(), MainActivity.class);
                intent.putExtra(IS_FROM_ACTION, true);
                intent.putExtra(FROM, FROM_ADD_A_DOG);
                intent.putExtra(PAGE, TAB_TEST_A_NEW_PILE);
                intent.putExtra(CURRENT_TAB, TAB_PILES);
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
                intent.putExtra(PAGE, TAB_ADD_A_DOG_PAST);
                intent.putExtra(CURRENT_TAB, TAB_RESIDENTS);
                getContext().startActivity(intent);
                getActivity().finish();

            }

        });

        relativeLayout = (RelativeLayout) root.findViewById(R.id.detail_match_found);
        textViewIndetify = (TextView) root.findViewById(R.id.tv_indentify);
        switch (position % 3) {
            case PENDING_TO_TEST:
                relativeLayout.setVisibility(View.GONE);
                textViewIndetify.setText("Pending To Test");
                textViewIndetify.setTextColor(ContextCompat.getColor(getContext(), R.color.orange));
                break;
            case UNABLE_TO_MATCH:
                relativeLayout.setVisibility(View.GONE);
                textViewIndetify.setText("Unable To Match");
                textViewIndetify.setTextColor(ContextCompat.getColor(getContext(), R.color.red));
                break;


        }
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
