package mobile.forkit.forkit_client.browse.adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import mobile.forkit.forkit_client.models.Venue;

/**
 * Created by horimori on 6/20/17.
 */

public class EateriesSearchListAdapter extends RecyclerView.Adapter<EateriesSearchListAdapter.SearchResultItemHolder> {
    private List<Venue> venues;
    public EateriesSearchListAdapter(List<Venue> venues) {
        this.venues = venues;
    }

    public void addOne(Venue v) {
        venues.add(v);
        Log.e("EATERY", v.toString());
        notifyDataSetChanged();
    }

    public void addAll(List<Venue> vs) {
        venues.clear();
        venues.addAll(vs);
        for (Venue v : venues) {
            Log.e("EATERIES", v.toString());
        }
        notifyDataSetChanged();
    }

    public void addAllDoNotClear(List<Venue> vs) {
        venues.addAll(vs);
        notifyDataSetChanged();
    }

    public void clearAll() {
        venues.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public SearchResultItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(SearchResultItemHolder holder, int p) {

    }
    class SearchResultItemHolder extends RecyclerView.ViewHolder {
        public SearchResultItemHolder(View v) {
            super(v);
        }
    }
}
