package novahub.vn.npr4dogs.piles;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import novahub.vn.npr4dogs.BaseFragment;
import novahub.vn.npr4dogs.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PilesStepFiveFragment extends BaseFragment implements PilesContract.View {

    private PilesContract.Presenter presenter;
    private View root;
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
        
        return root;
    }

    @Override
    public void showView() {

    }

    @Override
    public void setPresenter(PilesContract.Presenter prensenter) {
        this.presenter = prensenter;
    }
}
