package novahub.vn.npr4dogs.main;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andexert.library.RippleView;

import java.util.List;

import novahub.vn.npr4dogs.Base;
import novahub.vn.npr4dogs.BaseFragment;
import novahub.vn.npr4dogs.R;
import novahub.vn.npr4dogs.data.Pile;
import novahub.vn.npr4dogs.piles.PilesActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class TestANewPileFragment extends BaseFragment implements MainContract.BaseTestANewPileView, Base {

    private MainContract.BaseTestANewPilePresenter presenter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private PilesRecyclerViewAdapter pilesRecyclerViewAdapter;
    private View root;
    private RippleView rippleView;
    public TestANewPileFragment() {
        // Required empty public constructor
    }

    public static TestANewPileFragment newInstance() {
        TestANewPileFragment testANewPileFragment = new TestANewPileFragment();

        return testANewPileFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_test_anew_pile, container, false);
        rippleView = (RippleView) root.findViewById(R.id.rpv_take_new_pile);
        rippleView.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
            @Override
            public void onComplete(RippleView rippleView) {
                Intent intent = new Intent(getContext(), PilesActivity.class);
                getActivity().startActivity(intent);
                getActivity().finish();
            }
        });
        presenter.loadRecyclerView();
        return root;
    }

    @Override
    public void showView() {

    }

    @Override
    public void showRecyclerView(List<Pile> piles) {
        recyclerView = (RecyclerView) root.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        pilesRecyclerViewAdapter = new PilesRecyclerViewAdapter(piles);
        recyclerView.setAdapter(pilesRecyclerViewAdapter);
        pilesRecyclerViewAdapter.setOnItemClickListener(new PilesRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View itemVIew, int position) {
                Intent intent = new Intent(getContext(), MainActivity.class);
                intent.putExtra(IS_FROM_ACTION, true);
                intent.putExtra(FROM, FROM_ADD_A_DOG);
                intent.putExtra(PAGE, TAB_PILES_DETAIL);
                intent.putExtra(CURRENT_TAB, TAB_PILES);
                intent.putExtra(POSITION, position);
                getContext().startActivity(intent);
                getActivity().finish();
            }
        });

    }

    @Override
    public void setPresenter(MainContract.BaseTestANewPilePresenter prensenter) {
        this.presenter = prensenter;
    }
}
