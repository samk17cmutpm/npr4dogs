package novahub.vn.npr4dogs.sign_in;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import novahub.vn.npr4dogs.Base;
import novahub.vn.npr4dogs.BaseFragment;
import novahub.vn.npr4dogs.R;
import novahub.vn.npr4dogs.main.MainActivity;


public class SignInFragment extends BaseFragment implements SignInContract.View, View.OnClickListener, Base{
    private final String TAG = "SignInFragment";
    private SignInContract.Presenter presenter;
    private View root;
    private TextView tvForgotPassword;
    private TextView tvSignUp;
    private Button btSignIn;

    public SignInFragment() {
        // Required empty public constructor
    }

    public static SignInFragment newInstance() {
        SignInFragment fragment = new SignInFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_sign_in, container, false);
        presenter.loadForm();
        return root;
    }

    @Override
    public void showView() {

    }

    @Override
    public void showForm() {
        // show form here to sign in
        TextView textViewAppName = (TextView) root.findViewById(R.id.textViewAppName);
        Typeface custom_font = Typeface.createFromAsset(getActivity().getAssets(), FONT);
        textViewAppName.setTypeface(custom_font);
        tvForgotPassword = (TextView) root.findViewById(R.id.tv_forgot_password);
        tvForgotPassword.setOnClickListener(this);
        tvSignUp = (TextView) root.findViewById(R.id.tv_sign_up);
        tvSignUp.setOnClickListener(this);
        btSignIn = (Button) root.findViewById(R.id.bt_sign_in);
        btSignIn.setOnClickListener(this);

        EditText editText = (EditText) root.findViewById(R.id.password);
        editText.getBackground().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_IN);

    }

    @Override
    public void goToWebViewSignUp() {

    }

    @Override
    public void goToGetPasswordForm() {

    }

    @Override
    public void signInSuccessfully(boolean success) {

        if (success) {
            Log.d(TAG, "Sign in success");
            Intent intent = new Intent(getContext(), MainActivity.class);
            getContext().startActivity(intent);
        } else {
            Log.d(TAG, "Sign in unsuccess");
        }

    }

    @Override
    public void setPresenter(SignInContract.Presenter prensenter) {
        this.presenter = prensenter;
    }

    @Override
    public void onResume() {
        super.onResume();
        this.presenter.start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_forgot_password:
                presenter.forgotPassword();
                break;
            case R.id.bt_sign_in:
                presenter.signIn();
                break;
            case R.id.tv_sign_up:
                presenter.signUpNewAccount();
        }
    }
}
