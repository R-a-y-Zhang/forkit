package app

import datas.LatLng
import datas.VenueBasic
import datas.VenueDetail
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration
import org.springframework.web.bind.annotation.*
import sources.FoursquareAPI
import sources.foursquareApi
import sources.pullOrFetchForVenuesAtLatLng
import sources.pullOrFetchForVenuesAtLocation
import java.util.*

@RestController
class PrimaryController {
    @GetMapping("/ping")
    fun pong() = "pong"

    @GetMapping("/search")
    fun getVenuesAroundLocation(@RequestParam("ll") ll: Optional<String>, @RequestParam("address") address: Optional<String>): List<VenueBasic> {
        if (!ll.isPresent && !address.isPresent) {
            return emptyList()
        }

        if (ll.isPresent) {
            val latlng = ll.get().split(',')
            return pullOrFetchForVenuesAtLatLng(LatLng(latlng[0].toDouble(), latlng[1].toDouble()))
                    .map { response -> response.response.venues }
                    .blockingFirst()
        } else if (address.isPresent) {
            return pullOrFetchForVenuesAtLocation(address.get())
                    .map { venues -> venues.response.venues }
                    .blockingFirst()
        }
        return emptyList()
    }

    @GetMapping("/venueId")
    fun getVenueWithId(@RequestParam id: String): VenueDetail {
        if (id.isNullOrEmpty()) { return VenueDetail() }
        return foursquareApi.getVenueDetails(id).map { venue -> println(venue); venue.response.venue }.blockingFirst()
    }

    @PostMapping("/saveVenues")
    fun saveVenue(@RequestParam userId: String, @RequestBody payload: List<Map<String, Object>>): Object? {
        println(userId)
        for (venue in payload) {

        }
        return null
    }
}

@SpringBootApplication
@EnableAutoConfiguration(exclude=arrayOf(DataSourceAutoConfiguration::class, HibernateJpaAutoConfiguration::class))
class App

fun main(args: Array<String>) {
    SpringApplication.run(App::class.java, *args)
}