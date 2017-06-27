package mobile.forkit.forkit_client.apis;

import java.util.List;

import io.reactivex.Observable;
import mobile.forkit.forkit_client.apis.apiHelpers.RetroHelper;
import mobile.forkit.forkit_client.apis.services.ForkitBaseService;
import mobile.forkit.forkit_client.models.Venue;
import mobile.forkit.forkit_client.models.VenueMetadata;

/**
 * Created by horimori on 6/21/17.
 */

public class ForkitAPI {
    public static boolean DEBUG = false;
    public static void setDebug(boolean debug) {
        ForkitAPI.DEBUG = debug;
    }
    public static final String[] mockids = {
            "785ad567a93dacac4860a3a8a3b50eb6",
            "b8a98553600f42ded7fa1bcf7b9eefa8",
            "a488a4f5bf611772fba48398174cfbec",
            "ce264b53be789c29000e29bce8769515",
            "734f66c3c738767afd4de70f277b2d1b",
            "4a25d0d75818c2a71e53de57ba152dd2",
            "680cc9d1ca2858bf3f4e9a9716a98174",
            "8df603b9aa5e4b7c1c496dabec979e27",
            "46b35c348674acba843f6a4071fd152d",
            "de175a14fed6d40007f691a2d940911b"
    };

    public static ForkitBaseService forkitBase =
            RetroHelper.getRetrofitBuilder().create(ForkitBaseService.class);
    public static Observable<List<VenueMetadata>> getVenuesForLocation(double lat, double lng, double radius) {
        if (ForkitAPI.DEBUG) {
            return Observable.fromArray(mockids)
                    .map(id -> new VenueMetadata(id))
                    .toList().toObservable();
        }
        return forkitBase.getVenuesForLocation(lat, lng, radius);
    }

    public static Observable<Venue> getVenueById(String id) {
        return forkitBase.getVenueById(id);
    }
}
