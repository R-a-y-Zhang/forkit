package mobile.forkit.forkit_client.browse;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mobile.forkit.forkit_client.R;
public class EateriesSearchFragment extends Fragment {
    public EateriesSearchFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_eateries_search, container, false);
    }

}
