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
data class User(
        val firstName: String = "",
        val lastName: String = "",
        val dob: DOB = DOB(),
        val email: String = "",
        val phone: String = ""
)

// VENUE DATA CLASSES
// ********************** PHOTO OBJECTS *************************
@Entity
data class PhotoItem(
        val id: String,
        val prefix: String,
        val suffix: String
)

@Entity
data class Photo(
        val items: List<PhotoItem>
)

@Entity
data class Photos(
        val groups: List<Photo> = ArrayList<Photo>()
)
////////////////////////////////////////////////////////////////
// ********************* REVIEW OBJECTS ************************
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
        val canonicalUrl: String = "",
        val createdAt: Long = 0,
        val text: String = "",
        val type: String = ""
)

@Entity
data class Tip(
        val items: List<Review> = ArrayList<Review>()
)

@Entity
data class Tips(
        val groups: List<Tip> = ArrayList<Tip>()
)
/////////////////////////////////////////////////////////////////
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
data class Category(
        val name: String,
        val shortName: String
)

@Entity
data class Stats(
        val usersCount: Int = -1,
        val visitsCount: Int = -1
)

@Entity
data class Price(
        val tier: Int = -1,
        val currency: String = ""
)

@Entity
data class Likes(
        val count: Int = -1
)
@Entity
data class Meta(
        val code: Int,
        val requestId: String
)

@Entity
data class VenueBasic(
        val id: String = "", // ID of venue as it appears in the database
        @SerializedName("id")
        val foursquareId: String = "", // Foursquare ID, duh
        val name: String = "",
        val utc: Int = -99,
        val location: Location = Location(),
        val rating: Float = -1f,
        val contact: Contact = Contact(""),
        val hours: Map<String, Pair<Int, Int>> = HashMap<String, Pair<Int, Int>>()
)


@Entity
data class VenueDetail(
        @SerializedName("categories")
        val tags: List<Category> = ArrayList<Category>(),
        val verified: Boolean = false,
        val stat: Stats = Stats(),
        val likes: Likes = Likes(),
        val price: Price = Price(),
        val photos: Photos = Photos(),
        val tips: Tips = Tips()
)
// Merging basicVenue and VenueDetail

@Entity
data class Venues(
        val venues: List<VenueBasic>
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
data class VenueDetailResponse(
        val venue: VenueDetail
)

@Entity
data class SingleResponse(
        val meta: Meta,
        val response: VenueDetailResponse
)

@Entity
data class GeocodeResponse(
        val results: List<AddressResult>
)

/********************** HELPER FUNCTIONS **********************/