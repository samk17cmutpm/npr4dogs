package novahub.vn.npr4dogs.main;

/**
 * Created by samnguyen on 5/7/16.
 */
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.SectionIndexer;
import android.widget.TextView;

import java.util.ArrayList;

import novahub.vn.npr4dogs.R;
import novahub.vn.npr4dogs.data.Pile;
import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

public class TestBaseAdapter extends ArrayAdapter<Pile> implements
        StickyListHeadersAdapter, SectionIndexer {

    private final Context mContext;
    private String[] mCountries;
    private int[] mSectionIndices;
    private ArrayList<String> mSectionLetters;
    private LayoutInflater mInflater;
    private ArrayList<Pile> piles;

    public TestBaseAdapter(Context context, ArrayList<Pile> piles) {
        super(context, 0, piles);
        this.piles = piles;
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mCountries = context.getResources().getStringArray(R.array.countries);
//        mSectionIndices = getSectionIndices();
        mSectionLetters = new ArrayList<>();
        mSectionLetters.add("Dogs");
        mSectionLetters.add("Piles");

        mSectionIndices = new int[2];
        mSectionIndices[0] = 0;
        mSectionIndices[1] = 2;


    }



//    private int[] getSectionIndices() {
//        ArrayList<Integer> sectionIndices = new ArrayList<Integer>();
//        char lastFirstChar = mCountries[0].charAt(0);
//        sectionIndices.add(0);
//        for (int i = 1; i < mCountries.length; i++) {
//            if (mCountries[i].charAt(0) != lastFirstChar) {
//                lastFirstChar = mCountries[i].charAt(0);
//                sectionIndices.add(i);
//            }
//        }
//        int[] sections = new int[sectionIndices.size()];
//        for (int i = 0; i < sectionIndices.size(); i++) {
//            sections[i] = sectionIndices.get(i);
//        }
//        return sections;
//    }
//
//    private Character[] getSectionLetters() {
//        Character[] letters = new Character[mSectionIndices.length];
//        for (int i = 0; i < mSectionIndices.length; i++) {
//            letters[i] = mCountries[mSectionIndices[i]].charAt(0);
//        }
//        return letters;
//    }

    @Override
    public int getItemViewType(int position) {
        if (position < 2) {
            return 0;
        } else return 1;
    }

    // Total number of types is the number of enum values
    @Override
    public int getViewTypeCount() {
        return piles.size();
    }

    @Override
    public int getCount() {
        return piles.size();
    }

    @Override
    public Pile getItem(int position) {
        return this.piles.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            int type = getItemViewType(position);
            convertView = getInflatedLayoutForType(type, parent);
//            convertView = mInflater.inflate(R.layout.test_list_item_layout, parent, false);
//            holder.text = (TextView) convertView.findViewById(R.id.text);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

//        holder.text.setText(mCountries[position]);

        return convertView;
    }

    private View getInflatedLayoutForType(int type, ViewGroup viewGroup) {
        if (type == 0) {
            return mInflater.inflate(R.layout.test_list_item_layout, viewGroup, false);
        } else  {
            return mInflater.inflate(R.layout.test_list, viewGroup, false);
        }
    }

    @Override
    public View getHeaderView(int position, View convertView, ViewGroup parent) {
        HeaderViewHolder holder;

        if (convertView == null) {
            holder = new HeaderViewHolder();
            convertView = mInflater.inflate(R.layout.header, parent, false);
            holder.text = (TextView) convertView.findViewById(R.id.text1);
            convertView.setTag(holder);
        } else {
            holder = (HeaderViewHolder) convertView.getTag();
        }

        // set header text as first char in name
//        CharSequence headerChar = mCountries[position].subSequence(0, 1);
        String headerChar = "Piles";
        if (position < 2) {
            headerChar = "Dogs";
        }

        holder.text.setText(headerChar);

        return convertView;
    }

    /**
     * Remember that these have to be static, postion=1 should always return
     * the same Id that is.
     */
    @Override
    public long getHeaderId(int position) {
        // return the first character of the country as ID because this is what
        // headers are based upon
        return mCountries[position].subSequence(0, 1).charAt(0);
    }

    @Override
    public int getPositionForSection(int section) {
        if (mSectionIndices.length == 0) {
            return 0;
        }

        if (section >= mSectionIndices.length) {
            section = mSectionIndices.length - 1;
        } else if (section < 0) {
            section = 0;
        }
        return mSectionIndices[section];
    }

    @Override
    public int getSectionForPosition(int position) {
        for (int i = 0; i < mSectionIndices.length; i++) {
            if (position < mSectionIndices[i]) {
                return i - 1;
            }
        }
        return mSectionIndices.length - 1;
    }

    @Override
    public Object[] getSections() {
        return null;
    }

    public void clear() {
        mCountries = new String[0];
        mSectionIndices = new int[0];
//        mSectionLetters = new Character[0];
        notifyDataSetChanged();
    }

    public void restore() {
        mCountries = mContext.getResources().getStringArray(R.array.countries);
//        mSectionIndices = getSectionIndices();
//        mSectionLetters = getSectionLetters();
        notifyDataSetChanged();
    }

    class HeaderViewHolder {
        TextView text;
    }

    class ViewHolder {
        TextView text;
    }

}
