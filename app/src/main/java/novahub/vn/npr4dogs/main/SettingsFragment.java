package novahub.vn.npr4dogs.main;


import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.andexert.library.RippleView;

import novahub.vn.npr4dogs.Base;
import novahub.vn.npr4dogs.BaseFragment;
import novahub.vn.npr4dogs.R;
import novahub.vn.npr4dogs.splash_screen.SplashActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends BaseFragment implements MainContract.BaseSettingsView, Base {

    private MainContract.BaseSettingsPresenter presenter;
    private View root;
    private TextView textViewDepartment;
    private RippleView rippleViewSignOut;
    private RippleView rippleViewFeedBack;
    private RippleView rippleViewHelp;
    public SettingsFragment() {
        // Required empty public constructor
    }

    public static SettingsFragment newInstance() {
        SettingsFragment settingsFragment = new SettingsFragment();
        return settingsFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_settings, container, false);
        textViewDepartment = (TextView) root.findViewById(R.id.textViewDepartment);
        Typeface custom_font = Typeface.createFromAsset(getActivity().getAssets(), FONT);
        textViewDepartment.setTypeface(custom_font);
        rippleViewSignOut = (RippleView) root.findViewById(R.id.rpv_signout);
        rippleViewSignOut.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {

            @Override
            public void onComplete(RippleView rippleView) {
                Intent intent = new Intent(getContext(), SplashActivity.class);
                getActivity().startActivity(intent);
                getActivity().finish();
            }
        });

        rippleViewFeedBack = (RippleView) root.findViewById(R.id.rvp_submit_feedback);
        rippleViewFeedBack.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
            @Override
            public void onComplete(RippleView rippleView) {
                Toast.makeText(getContext(), "Feed Back !", Toast.LENGTH_SHORT).show();
            }
        });

        rippleViewHelp = (RippleView) root.findViewById(R.id.help);
        rippleViewHelp.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
            @Override
            public void onComplete(RippleView rippleView) {
                Toast.makeText(getContext(), "Help !", Toast.LENGTH_SHORT).show();
            }
        });
        return root;
    }

    @Override
    public void showView() {

    }

    @Override
    public void setPresenter(MainContract.BaseSettingsPresenter prensenter) {
        this.presenter = prensenter;
    }
}
