package novahub.vn.npr4dogs.main;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import novahub.vn.npr4dogs.BaseFragment;
import novahub.vn.npr4dogs.R;
import novahub.vn.npr4dogs.data.Pile;

/**
 * A simple {@link Fragment} subclass.
 */
public class TestANewPileFragment extends BaseFragment implements MainContract.BaseTestANewPileView {

    private MainContract.BaseTestANewPilePresenter presenter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private PilesRecyclerViewAdapter pilesRecyclerViewAdapter;
    private View root;
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
    }

    @Override
    public void setPresenter(MainContract.BaseTestANewPilePresenter prensenter) {
        this.presenter = prensenter;
    }
}
