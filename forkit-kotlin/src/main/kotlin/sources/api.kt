package sources

/**
 * Created by rz187 on 7/24/17.
 */

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import datas.*
import io.reactivex.Flowable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

val FOURSQUARE_KEY = "IKYQTRR11WRM4BPYIIGLCBVRPV0QVHTFBSPJIG2K5P1NCU53"
val FOURSQUARE_SECRET = "FY4WM5FN5E33PVH0VEAKC30X0BQNIGAHNIFHC4QX0U4HYIUB"

val FOURSQUARE_BASE_URL = "https://api.foursquare.com/v2/venues/"
val FOURSQUARE_VENUE_VERSION = "20160101"

val GOOGLE_GEOCODE_API = "https://maps.googleapis.com/"

val logging: HttpLoggingInterceptor = HttpLoggingInterceptor()

enum class LOGGING {
    NONE,
    HEADER,
    BODY
}
fun setLoggingLevel(loglevel: LOGGING) {
    if (loglevel == LOGGING.NONE) {
        logging.level = HttpLoggingInterceptor.Level.NONE
    } else if (loglevel == LOGGING.HEADER) {
        logging.level = HttpLoggingInterceptor.Level.HEADERS
    } else if (loglevel == LOGGING.BODY) {
        logging.level = HttpLoggingInterceptor.Level.BODY
    }
}
fun retrofitFactory(baseUrl: String): Retrofit {
    logging.level = HttpLoggingInterceptor.Level.BODY
    val httpClient: OkHttpClient.Builder = OkHttpClient.Builder()
    httpClient.addInterceptor(logging)
    val retrofit: Retrofit =  Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(httpClient.build())
            .build()
    return retrofit
}

val foursquareRetrofit: Retrofit = retrofitFactory(FOURSQUARE_BASE_URL)
val googleRetrofit: Retrofit = retrofitFactory(GOOGLE_GEOCODE_API)

interface FoursquareAPI {
    @GET("search")
    fun searchVenuesAtLocation(@Query("ll") ll: String,
                               @Query("query") query: String = "restaurant",
                               @Query("radius") radius: Int = 5000,
                               @Query("client_id") client_id: String = FOURSQUARE_KEY,
                               @Query("client_secret") client_secret: String = FOURSQUARE_SECRET,
                               @Query("v") version: String = FOURSQUARE_VENUE_VERSION): Flowable<MultipleVenues>

    @GET("")
    fun getVenueDetails(@Query("id") id: String): Flowable<SingleResponse>
}

interface GoogleAPI {
    @GET("maps/api/geocode/json")
    fun getLatLngForAddress(@Query("address") address: String, @Query("key") key: String = "AIzaSyALdpww3nZtLmU6x1-ROvfjGXKwSm11si4"): Flowable<GeocodeResponse>
}

val foursquareApi: FoursquareAPI = foursquareRetrofit.create(FoursquareAPI::class.java)
val googleApi: GoogleAPI = googleRetrofit.create(GoogleAPI::class.java)

