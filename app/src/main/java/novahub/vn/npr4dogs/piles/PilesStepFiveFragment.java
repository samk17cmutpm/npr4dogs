package novahub.vn.npr4dogs.piles;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.andexert.library.RippleView;

import novahub.vn.npr4dogs.Base;
import novahub.vn.npr4dogs.BaseFragment;
import novahub.vn.npr4dogs.R;
import novahub.vn.npr4dogs.main.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class PilesStepFiveFragment extends BaseFragment implements PilesContract.View, Base {

    private PilesContract.Presenter presenter;
    private View root;
    private RippleView rippleView;
    public PilesStepFiveFragment() {
        // Required empty public constructor
    }

    public static PilesStepFiveFragment newInstance() {
        PilesStepFiveFragment pilesStepFiveFragment = new PilesStepFiveFragment();
        return pilesStepFiveFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_piles_step_five, container, false);
        TextView textViewAdd1 = (TextView) root.findViewById(R.id.textViewAdd1);
        TextView textViewAdd2 = (TextView) root.findViewById(R.id.textViewAdd2);
        TextView textViewAdd3 = (TextView) root.findViewById(R.id.textViewAdd3);
        TextView textViewAdd4 = (TextView) root.findViewById(R.id.textViewAdd4);

        String htmlString1 = "<u>npr4dogs Genetics Lab</u>";
        String htmlString2 = "<u>UC Davis</u>";
        String htmlString3 = "<u>Old Davis Road</u>";
        String htmlString4 = "<u>Davis, CA 95616</u>";

        textViewAdd1.setText(Html.fromHtml(htmlString1));
        textViewAdd2.setText(Html.fromHtml(htmlString2));
        textViewAdd3.setText(Html.fromHtml(htmlString3));
        textViewAdd4.setText(Html.fromHtml(htmlString4));

        rippleView = (RippleView) root.findViewById(R.id.rpv_finish);
        rippleView.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {

            @Override
            public void onComplete(RippleView rippleView) {
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
        intent.putExtra(PAGE, TAB_TEST_A_NEW_PILE);
        intent.putExtra(CURRENT_TAB, TAB_PILES);
        getContext().startActivity(intent);
        getActivity().finish();
    }

    @Override
    public void setPresenter(PilesContract.Presenter prensenter) {
        this.presenter = prensenter;
    }
}
