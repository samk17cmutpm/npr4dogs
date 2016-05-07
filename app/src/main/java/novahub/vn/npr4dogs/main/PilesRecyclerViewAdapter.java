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
public class PilesRecyclerViewAdapter extends RecyclerView.Adapter<PilesRecyclerViewAdapter.ViewHolder> {

    private List<Pile> piles;
    private static OnItemClickListener listener;

    public PilesRecyclerViewAdapter(List<Pile> piles) {
        this.piles = piles;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.test_list, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return piles.size();
    }

    public interface OnItemClickListener {
        void onItemClick(View itemVIew, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView tvId;
        public ViewHolder(final View itemView) {
            super(itemView);
            tvId = (TextView) itemView.findViewById(R.id.textView79);

            // attach events here
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onItemClick(itemView, getLayoutPosition());
                    }
                }
            });
        }
    }
}

