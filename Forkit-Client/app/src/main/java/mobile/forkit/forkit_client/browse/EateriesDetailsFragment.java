package mobile.forkit.forkit_client.browse;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mobile.forkit.forkit_client.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EateriesDetailsFragment extends Fragment {


    public EateriesDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_eateries_details, container, false);
    }

}
