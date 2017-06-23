package mobile.forkit.forkit_client.utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by rz187 on 6/23/17.
 */

public class AdapterUtils {
    public static View getViewHolderForAdapter(ViewGroup parent, int layout) {
        return LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
    }
}
