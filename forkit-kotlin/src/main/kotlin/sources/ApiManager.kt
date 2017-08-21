package sources

import datas.LatLng
import datas.MultipleVenues
import io.reactivex.Flowable

fun queryDatabaseForVenuesAtLocation(ll: LatLng): Flowable<MultipleVenues> {
    return Flowable.just(null)
}

fun queryExternalSources(ll: LatLng): Flowable<MultipleVenues> {
    return Flowable.just(null)
}

fun pullOrFetchForVenuesAtLocation(addr: String, radius: Int = 5000, store: Boolean = true,
                                   forceExternalQuery: Boolean = false,
                                   updateOnForce: Boolean = true): Flowable<MultipleVenues> {
    return googleApi.getLatLngForAddress(addr)
            .flatMap { res ->
                        println(res.results[0].geometry.ll)
                        pullOrFetchForVenuesAtLatLng(res.results[0].geometry.ll,
                            radius, store, forceExternalQuery, updateOnForce)
            }
}

fun pullOrFetchForVenuesAtLatLng(latlng: LatLng, radius: Int = 5000, store: Boolean = true,
                                 forceExternalQuery: Boolean = false,
                                 updateOnForce: Boolean = true): Flowable<MultipleVenues> {
    if (forceExternalQuery) {
        if (updateOnForce) {

        }
    }

    if (store) {

    }

    return foursquareApi.searchVenuesAtLocation("${latlng.lat},${latlng.lng}", radius = radius)
}
