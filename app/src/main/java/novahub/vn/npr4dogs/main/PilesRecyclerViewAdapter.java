package novahub.vn.npr4dogs.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import novahub.vn.npr4dogs.R;
import novahub.vn.npr4dogs.data.Pile;

/**
 * Created by samnguyen on 5/7/16.
 */
public class PilesRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Pile> piles;
    private static OnItemClickListener listener;

    private final int MATCH_FOUND = 1;
    private final int PENDING_TO_TEST = 2;
    private final int UNABLE_TO_MATCH = 3;

    public PilesRecyclerViewAdapter(List<Pile> piles) {
        this.piles = piles;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType) {
            case MATCH_FOUND:
                View viewMatchFound = inflater.inflate(R.layout.pile_detail_match_found, parent, false);
                viewHolder = new PilesViewHolderMatchFound(viewMatchFound);
                break;
            case PENDING_TO_TEST:
                View viewPendingToTest = inflater.inflate(R.layout.pile_detail_pending_to_test, parent, false);
                viewHolder = new PilesViewHolderPendingToTest(viewPendingToTest);
                break;
            case UNABLE_TO_MATCH:
                View viewUnableToMatch = inflater.inflate(R.layout.pile_detail_unable_to_match, parent, false);
                viewHolder = new PilesViewHolderUnableToMatch(viewUnableToMatch);
        }

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return piles.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (piles.get(position).getId() % 3 == 0) {
            return MATCH_FOUND;
        } else if (piles.get(position).getId() % 3 == 1) {
            return PENDING_TO_TEST;
        } else {
            return UNABLE_TO_MATCH;
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View itemVIew, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

//    public static class ViewHolder extends RecyclerView.ViewHolder {
//        // each data item is just a string in this case
//        public TextView tvId;
//        public ViewHolder(final View itemView) {
//            super(itemView);
//            tvId = (TextView) itemView.findViewById(R.id.textView79);
//
//            // attach events here
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (listener != null) {
//                        listener.onItemClick(itemView, getLayoutPosition());
//                    }
//                }
//            });
//        }
//    }
}

