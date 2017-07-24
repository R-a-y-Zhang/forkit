package sources

/**
 * Created by rz187 on 7/24/17.
 */

import datas.Venue

val FOURSQUARE_KEY = "IKYQTRR11WRM4BPYIIGLCBVRPV0QVHTFBSPJIG2K5P1NCU53"
val FOURSQUARE_SECRET = "FY4WM5FN5E33PVH0VEAKC30X0BQNIGAHNIFHC4QX0U4HYIUB"

val FOURSQUARE_VENUE_SEARCH_URL = "https://api.foursquare.com/v2/venues/search"
val FOURSQUARE_VENUE_DETAILS_URL = "https://api.foursquare.com/v2/venues/"

fun appendSecret(url: String): String {
    return "${url}&client_id=${FOURSQUARE_KEY}&client_secret=${FOURSQUARE_SECRET}"
}

fun searchForVenuesAtLatLng(lat: Double, lng: Double): Array<Venue> {

}