package mobile.forkit.forkit_client.apis.services;

import java.util.List;

import io.reactivex.Observable;
import mobile.forkit.forkit_client.models.Venue;
import mobile.forkit.forkit_client.models.VenueMetadata;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by horimori on 6/23/17.
 */

public interface ForkitBaseService {
    @GET("browse.json")
    Observable<List<VenueMetadata>> getVenuesForLocation(@Query("lat") double lat,
                                                         @Query("lng") double lng,
                                                         @Query("radius") double radius);

    @GET("venue.json")
    Observable<Venue> getVenueById(@Query("id") String id);
}
