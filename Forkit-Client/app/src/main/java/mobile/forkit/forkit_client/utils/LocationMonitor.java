package mobile.forkit.forkit_client.utils;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;

public class LocationMonitor {
    public static boolean debug = false;
    public static Location getLastKnownUserLocation (Context activity) {
        if (debug) {
            Location l = new Location("");
            l.setLatitude(40.761471);
            l.setLongitude(-73.977560);
            return l;
        }
        LocationManager locationManager = (LocationManager) activity.getApplicationContext().getSystemService(Context.LOCATION_SERVICE);
        try {
            if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                return locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            } else if (locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
                return locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            }
            return null;
        } catch (SecurityException e) {
            Log.d("LOCATIONMONITOR", "Security Error: " + e.getMessage());
            return null;
        }
    }

    public static void setDebug(boolean debug) {
        LocationMonitor.debug = debug;
    }
}
