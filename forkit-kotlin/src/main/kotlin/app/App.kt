package app

import datas.LatLng
import datas.Venue
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
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
    fun getVenuesAroundLocation(@RequestParam("ll") ll: Optional<String>, @RequestParam("address") address: Optional<String>): List<String> {
        if (!ll.isPresent && !address.isPresent) {
            return emptyList()
        }

        if (ll.isPresent) {
            val latlng = ll.get().split(',')
            return pullOrFetchForVenuesAtLatLng(LatLng(latlng[0].toDouble(), latlng[1].toDouble()))
                .map { venues ->
                        venues.response.venues.map { v -> v.id }
                }.blockingFirst()
        } else if (address.isPresent) {
            return pullOrFetchForVenuesAtLocation(address.get())
                .map { venues ->
                        venues.response.venues.map { v -> v.id }
                }.blockingFirst()
        }
        return emptyList()
    }

    @GetMapping("/venueId")
    fun getVenueWithId(@RequestParam id: String): Venue {
        if (id.isNullOrEmpty()) { return Venue() }
        return foursquareApi.getVenueDetails(id).map { venue -> println(venue); venue.response.venue }.blockingFirst()
    }
}

@SpringBootApplication
@EnableAutoConfiguration(exclude=arrayOf(DataSourceAutoConfiguration::class, HibernateJpaAutoConfiguration::class))
class App

fun main(args: Array<String>) {
    SpringApplication.run(App::class.java, *args)
}