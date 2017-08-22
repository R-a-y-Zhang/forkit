package datas

import com.google.gson.annotations.SerializedName
import javax.persistence.Entity

/**
 * Created by rz187 on 7/24/17.
 */

// USER DATA CLASSES
@Entity
data class DOB(
        val day: Int = 0,
        val month: Int = 0,
        val year: Int = 0
)

@Entity
data class Preference(
        val preference: String = "",
        val rating: Float = -1f
)

@Entity
data class User(
        val firstName: String = "",
        val lastName: String = "",
        val dob: DOB = DOB(),
        val email: String = "",
        val phone: String = "",
        val preferences: Map<String, Preference> = HashMap<String, Preference>()
)

// VENUE DATA CLASSES
@Entity
data class Photo(
        val id: String = "",
        val createdAt: Long = 0,
        val prefix: String = "",
        val suffix: String = "",
        val width: Int = 0,
        val height: Int = 0,
        val visibility: String = ""
)

@Entity
data class Photos(
        val groups: List<Photo> = ArrayList<Photo>()
)

@Entity
data class ReviewUser(
        val id: String = "",
        val firstName: String = "",
        val lastName: String = ""
)

@Entity
data class Review(
        val id: String = "",
        val user: ReviewUser = ReviewUser(),
        val photo: Photo = Photo(),
        val canonicalUrl: String = "",
        val createdAt: Long = 0,
        val text: String = ""
)

@Entity
data class Group(
        val item: List<Review> = ArrayList<Review>()
)

@Entity
data class Tips(
        val groups: List<Group> = ArrayList<Group>()
)

@Entity
data class Location(
        val address: String = "",
        val city: String = "",
        val state: String = "",
        val cc: String = "",
        val postalCode: String = "",
        val formattedAddress: List<String> = ArrayList<String>(),
        val lat: Float = -1f,
        val lng: Float = -1f
)

@Entity
data class Contact(
        val phone: String
)

@Entity
data class Meta(
        val code: Int,
        val requestId: String
)

@Entity
data class Venue(
        val id: String = "",
        val name: String = "",
        val tags: List<String> = ArrayList<String>(),
        val utc: Int = -99,
        val location: Location = Location(),
        val rating: Float = -1f,
        val price: Int = -1,
        val photos: Photos = Photos(),
        val tips: Tips = Tips(),
        val contact: Contact = Contact(""),
        val hours: Map<String, Pair<Int, Int>> = HashMap<String, Pair<Int, Int>>()
)

@Entity
data class Venues(
        val venues: List<Venue>
)

// LOCATIONS
@Entity
data class AddressComponent(
        @SerializedName("short_name")
        val shortName: String,
        val types: List<String>
)

@Entity
data class LatLng(
        val lat: Double,
        val lng: Double
)

@Entity
data class ViewPort(
        val northeast: LatLng,
        val southwest: LatLng
)

@Entity
data class LocationGeometry(
        @SerializedName("location")
        val ll: LatLng,
        val viewport: ViewPort
)

@Entity
data class AddressResult(
        @SerializedName("address_components")
        val addressComponents: List<AddressComponent>,
        @SerializedName("formatted_address")
        val formattedAddress: String,
        val geometry: LocationGeometry
)

// REQUEST CLASSES
@Entity
data class MultipleVenues(
        val meta: Meta,
        val response: Venues
)

@Entity
data class VenueDetails(
        val venue: Venue
)

@Entity
data class SingleResponse(
        val meta: Meta,
        val response: VenueDetails
)

@Entity
data class GeocodeResponse(
        val results: List<AddressResult>
)
