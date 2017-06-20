package mobile.forkit.forkit_client.browse;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import mobile.forkit.forkit_client.R;
import mobile.forkit.forkit_client.browse.adapters.EateriesSearchListAdapter;

public class EateriesSearchFragment extends Fragment {

    public EateriesSearchFragment() {

    }

    @BindView(R.id.browse_search_eateries_list)
    RecyclerView browseSearchEateriesList;

    EateriesSearchListAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_eateries_search, container, false);
        ButterKnife.bind(this, v);
        adapter = new EateriesSearchListAdapter();
        browseSearchEateriesList.setLayoutManager(new LinearLayoutManager(getActivity()));
        browseSearchEateriesList.setAdapter(adapter);
        return v;
    }
    private void getEateriesNearLocation() {

    }
}
