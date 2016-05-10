package novahub.vn.npr4dogs.main;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.SearchView;

import com.andexert.library.RippleView;

import java.util.ArrayList;
import java.util.List;

import info.hoang8f.android.segmented.SegmentedGroup;
import novahub.vn.npr4dogs.Base;
import novahub.vn.npr4dogs.BaseFragment;
import novahub.vn.npr4dogs.R;
import novahub.vn.npr4dogs.data.Resident;
import novahub.vn.npr4dogs.lib.NonSwipeableViewPager;
import novahub.vn.npr4dogs.utils.ActivityUtils;

/**
 * A simple {@link Fragment} subclass.
 */
public class ResidentsFragment extends BaseFragment implements MainContract.BaseResidentsView, Base {

    private MainContract.BaseResidentsPresenter presenter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ResidentsRecyclerViewAdapter residentsRecyclerViewAdapter;
    private View root;
    private RippleView rippleViewSearch;
    private EditText editTextSearch;
    private ImageView imageViewCloseSearch;
    public ResidentsFragment() {
        // Required empty public constructor
    }

    public static ResidentsFragment newInstance() {
        ResidentsFragment residentsFragment = new ResidentsFragment();
        return residentsFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_residents, container, false);
        presenter.loadSegments();
        presenter.loadRecyclerView();

        rippleViewSearch = (RippleView) root.findViewById(R.id.rpv_search);
        rippleViewSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rippleViewSearch.setVisibility(View.GONE);
                editTextSearch.setVisibility(View.VISIBLE);
                imageViewCloseSearch.setVisibility(View.VISIBLE);
                editTextSearch.performClick();
                ActivityUtils.showSoftKeyboard(editTextSearch, getContext());
            }
        });


        editTextSearch = (EditText) root.findViewById(R.id.editTextSearch);
        imageViewCloseSearch = (ImageView) root.findViewById(R.id.imageViewCloseSearch);
        imageViewCloseSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityUtils.hideSoftKeyboard(root, getContext());
                editTextSearch.setVisibility(View.GONE);
                imageViewCloseSearch.setVisibility(View.GONE);
                rippleViewSearch.setVisibility(View.VISIBLE);
            }
        });

//        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
//            @Override
//            public boolean onClose() {
//                searchView.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        searchView.setIconified(true);
//                        rippleViewSearch.setVisibility(View.VISIBLE);
//                    }
//                });
//                return false;
//            }
//        });
        return root;
    }

    @Override
    public void showView() {

    }

    @Override
    public void showSegments() {
        SegmentedGroup segmentedGroup = (SegmentedGroup) root.findViewById(R.id.segment);
        segmentedGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.button_current:
                        break;
                    case R.id.button_former:
                        break;
                }
            }
        });

    }

    @Override
    public void showViewPagers() {
//        viewPager = (NonSwipeableViewPager) root.findViewById(R.id.viewpager);
//        viewPager.setAdapter(new ResidentsListAdapter(getFragmentManager()));
    }

    @Override
    public void showRecyclerView(List<Resident> residents) {
        recyclerView = (RecyclerView) root.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        residentsRecyclerViewAdapter = new ResidentsRecyclerViewAdapter(residents);
        recyclerView.setAdapter(residentsRecyclerViewAdapter);

        residentsRecyclerViewAdapter.setOnItemClickListener(new ResidentsRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View itemVIew, int position) {
                Intent intent = new Intent(getContext(), MainActivity.class);
                intent.putExtra(IS_FROM_ACTION, true);
                intent.putExtra(FROM, FROM_ADD_A_DOG);
                intent.putExtra(PAGE, TAB_ADD_A_DOG_PAST);
                intent.putExtra(CURRENT_TAB, TAB_RESIDENTS);
                getContext().startActivity(intent);
                getActivity().finish();
            }
        });
    }

    @Override
    public void setPresenter(MainContract.BaseResidentsPresenter prensenter) {
        this.presenter = prensenter;
    }
}
