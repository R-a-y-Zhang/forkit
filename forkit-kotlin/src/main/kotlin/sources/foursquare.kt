package sources

/**
 * Created by rz187 on 7/24/17.
 */

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import datas.Location
import datas.MultiResponse
import datas.SingleResponse
import datas.Venue
import io.reactivex.Flowable
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

val FOURSQUARE_KEY = "IKYQTRR11WRM4BPYIIGLCBVRPV0QVHTFBSPJIG2K5P1NCU53"
val FOURSQUARE_SECRET = "FY4WM5FN5E33PVH0VEAKC30X0BQNIGAHNIFHC4QX0U4HYIUB"

val FOURSQUARE_BASE_URL = "https://api.foursquare.com/v2/venues/"
val FOURSQUARE_VENUE_SEARCH_URL = "${FOURSQUARE_BASE_URL}search"
val FOURSQUARE_VENUE_DETAILS_URL = "${FOURSQUARE_BASE_URL}"

fun appendSecret(url: String): String {
    return "${url}&client_id=${FOURSQUARE_KEY}&client_secret=${FOURSQUARE_SECRET}"
}

val retrofit: Retrofit = Retrofit.Builder()
                    .baseUrl(FOURSQUARE_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()

open interface FoursquareAPI {
    @GET("search")
    fun searchVenuesAtLocation(@Query("ll") ll: String,
                               @Query("query") query: String = "restaurants",
                               @Query("radius") radius: Int = 1000): Flowable<MultiResponse>;

    @GET("")
    fun getVenueDetails(@Query("id") id: String): Flowable<SingleResponse>;
}


