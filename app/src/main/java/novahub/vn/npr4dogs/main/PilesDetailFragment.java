package novahub.vn.npr4dogs.main;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import novahub.vn.npr4dogs.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PilesDetailFragment extends Fragment {


    public PilesDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_piles_detail, container, false);
    }

}
