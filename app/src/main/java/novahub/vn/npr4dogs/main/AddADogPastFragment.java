package novahub.vn.npr4dogs.main;


import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.andexert.library.RippleView;

import java.util.ArrayList;
import java.util.WeakHashMap;

import novahub.vn.npr4dogs.Base;
import novahub.vn.npr4dogs.BaseFragment;
import novahub.vn.npr4dogs.R;
import novahub.vn.npr4dogs.data.Pile;
import se.emilsjolander.stickylistheaders.ExpandableStickyListHeadersListView;
import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddADogPastFragment extends BaseFragment implements MainContract.BaseAddADogPastView, Base {
    private MainContract.BaseAddADogPastPresenter presenter;
    private View root;
    private ExpandableStickyListHeadersListView mListView;
    TestBaseAdapter mTestBaseAdapter;
    WeakHashMap<View,Integer> mOriginalViewHeightPool = new WeakHashMap<View, Integer>();
    private RippleView rippleViewResidents;
    private RippleView rippleViewEdit;
    public AddADogPastFragment() {
        // Required empty public constructor
    }

    public static AddADogPastFragment newInstance() {
        AddADogPastFragment addADogPastFragment = new AddADogPastFragment();
        return addADogPastFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_add_adog_past, container, false);
        mListView = (ExpandableStickyListHeadersListView) root.findViewById(R.id.list);
        ArrayList<Pile> piles = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            piles.add(new Pile(i));
        }
        //custom expand/collapse animation
        mListView.setAnimExecutor(new AnimationExecutor());
        mTestBaseAdapter = new TestBaseAdapter(getContext(), piles);
        mListView.setAdapter(mTestBaseAdapter);
        mListView.setOnHeaderClickListener(new StickyListHeadersListView.OnHeaderClickListener() {
            @Override
            public void onHeaderClick(StickyListHeadersListView l, View header, int itemPosition, long headerId, boolean currentlySticky) {
                if(mListView.isHeaderCollapsed(headerId)){
                    mListView.expand(headerId);
                }else {
                    mListView.collapse(headerId);
                }
            }
        });

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position > 1) {
                    Intent intent = new Intent(getContext(), MainActivity.class);
                    intent.putExtra(IS_FROM_ACTION, true);
                    intent.putExtra(FROM, FROM_ADD_A_DOG);
                    intent.putExtra(PAGE, TAB_PILES_DETAIL);
                    intent.putExtra(CURRENT_TAB, TAB_PILES);
                    getContext().startActivity(intent);
                    getActivity().finish();

                }
            }
        });

        rippleViewResidents = (RippleView) root.findViewById(R.id.resident_move_out);
        rippleViewResidents.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {

            @Override
            public void onComplete(RippleView rippleView) {
                Intent intent = new Intent(getContext(), MainActivity.class);
                intent.putExtra(IS_FROM_ACTION, true);
                intent.putExtra(FROM, FROM_ADD_A_DOG);
                intent.putExtra(PAGE, TAB_RESIDENTS);
                intent.putExtra(CURRENT_TAB, TAB_RESIDENTS);
                getContext().startActivity(intent);
                getActivity().finish();
            }

        });

        rippleViewEdit = (RippleView) root.findViewById(R.id.rpv_cancel);
        rippleViewEdit.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {

            @Override
            public void onComplete(RippleView rippleView) {
                Intent intent = new Intent(getContext(), MainActivity.class);
                intent.putExtra(IS_FROM_ACTION, true);
                intent.putExtra(FROM, FROM_ADD_A_DOG);
                intent.putExtra(PAGE, TAB_RESIDENTS_DETAIL);
                intent.putExtra(CURRENT_TAB, TAB_RESIDENTS);
                getContext().startActivity(intent);
                getActivity().finish();
            }

        });
        return root;
    }

    @Override
    public void showView() {

    }

    @Override
    public void setPresenter(MainContract.BaseAddADogPastPresenter prensenter) {
        this.presenter = prensenter;
    }

    //animation executor
    class AnimationExecutor implements ExpandableStickyListHeadersListView.IAnimationExecutor {

        @Override
        public void executeAnim(final View target, final int animType) {
            if(ExpandableStickyListHeadersListView.ANIMATION_EXPAND==animType&&target.getVisibility()==View.VISIBLE){
                return;
            }
            if(ExpandableStickyListHeadersListView.ANIMATION_COLLAPSE==animType&&target.getVisibility()!=View.VISIBLE){
                return;
            }
            if(mOriginalViewHeightPool.get(target)==null){
                mOriginalViewHeightPool.put(target,target.getHeight());
            }
            final int viewHeight = mOriginalViewHeightPool.get(target);
            float animStartY = animType == ExpandableStickyListHeadersListView.ANIMATION_EXPAND ? 0f : viewHeight;
            float animEndY = animType == ExpandableStickyListHeadersListView.ANIMATION_EXPAND ? viewHeight : 0f;
            final ViewGroup.LayoutParams lp = target.getLayoutParams();
            ValueAnimator animator = ValueAnimator.ofFloat(animStartY, animEndY);
            animator.setDuration(200);
            target.setVisibility(View.VISIBLE);
            animator.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animator) {
                }

                @Override
                public void onAnimationEnd(Animator animator) {
                    if (animType == ExpandableStickyListHeadersListView.ANIMATION_EXPAND) {
                        target.setVisibility(View.VISIBLE);
                    } else {
                        target.setVisibility(View.GONE);
                    }
                    target.getLayoutParams().height = viewHeight;
                }

                @Override
                public void onAnimationCancel(Animator animator) {

                }

                @Override
                public void onAnimationRepeat(Animator animator) {

                }
            });
            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    lp.height = ((Float) valueAnimator.getAnimatedValue()).intValue();
                    target.setLayoutParams(lp);
                    target.requestLayout();
                }
            });
            animator.start();

        }
    }
}
