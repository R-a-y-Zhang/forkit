package mobile.forkit.forkit_client.apis;

import java.util.List;

import io.reactivex.Observable;
import mobile.forkit.forkit_client.apis.apiHelpers.RetroHelper;
import mobile.forkit.forkit_client.apis.services.ForkitBaseService;
import mobile.forkit.forkit_client.models.Venue;

/**
 * Created by horimori on 6/21/17.
 */

public class ForkitAPI {
    public static ForkitBaseService forkitBase =
            RetroHelper.getRetrofitBuilder().create(ForkitBaseService.class);
    public static Observable<List<Venue>> getVenuesForLocation(double lat, double lng, double radius) {
        return forkitBase.getVenuesForLocation(lat, lng, radius);
    }
}
