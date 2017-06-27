package mobile.forkit.forkit_client.browse;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import mobile.forkit.forkit_client.R;
import mobile.forkit.forkit_client.apis.ForkitAPI;
import mobile.forkit.forkit_client.browse.adapters.EateriesSearchListAdapter;
import mobile.forkit.forkit_client.models.Venue;
import mobile.forkit.forkit_client.models.VenueMetadata;
import mobile.forkit.forkit_client.utils.LocationMonitor;

public class EateriesSearchFragment extends Fragment {

    public static final String HANDLE = "eateriessearch";
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
        adapter = new EateriesSearchListAdapter(new ArrayList<>());
        browseSearchEateriesList.setLayoutManager(new LinearLayoutManager(getActivity()));
        // browseSearchEateriesList.setAdapter(adapter);
        getEateriesNearLocation();
        return v;
    }

    private void getEateriesNearLocation() {

        Location ll = LocationMonitor.getLastKnownUserLocation(getActivity().getApplicationContext());
        double lat = ll.getLatitude(); double lng = ll.getLongitude();
        ForkitAPI.getVenuesForLocation(lat, lng, 3000)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(vs -> {
                    for (VenueMetadata v : vs) {
                        Log.e(HANDLE, v.id);
                    }
                    loadToVenuesList(vs);
                }, err -> Log.e(HANDLE + "0", err.getMessage()));

    }

    private void loadToVenuesList(List<VenueMetadata> venueIds) {
        for (VenueMetadata v : venueIds) {
            ForkitAPI.getVenueById(v.id)
                .subscribeOn(Schedulers.io()).doOnError(err -> Log.e(HANDLE + "1", err.getMessage()))
                .observeOn(AndroidSchedulers.mainThread())
                .toList()
                .toObservable()
                .subscribe(adapter::addAll, err -> Log.e(HANDLE + "2", err.getMessage()));
        }
    }
}
