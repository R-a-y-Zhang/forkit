package mobile.forkit.forkit_client;

import mobile.forkit.forkit_client.apis.ForkitAPI;
import mobile.forkit.forkit_client.utils.LocationMonitor;

/**
 * Created by horimori on 6/25/17.
 */

public class Init {
    public static void runDebugInit() {
        LocationMonitor.setDebug(true);
        ForkitAPI.setDebug(true);
    }

    public static void runStdInit() {

    }
}
