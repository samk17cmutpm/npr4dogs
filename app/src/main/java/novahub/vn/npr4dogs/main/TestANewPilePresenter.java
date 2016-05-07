package novahub.vn.npr4dogs.main;

import java.util.ArrayList;
import java.util.List;

import novahub.vn.npr4dogs.data.Pile;

/**
 * Created by samnguyen on 5/7/16.
 */
public class TestANewPilePresenter implements MainContract.BaseTestANewPilePresenter {
    private final MainContract.BaseTestANewPileView testANewPileView;
    public TestANewPilePresenter(MainContract.BaseTestANewPileView testANewPileView) {
        this.testANewPileView = testANewPileView;
        this.testANewPileView.setPresenter(this);
    }
    @Override
    public void loadView() {

    }

    @Override
    public void loadRecyclerView() {
        List<Pile> piles = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            piles.add(new Pile(i));
        }
        testANewPileView.showRecyclerView(piles);
    }

    @Override
    public void start() {

    }
}
