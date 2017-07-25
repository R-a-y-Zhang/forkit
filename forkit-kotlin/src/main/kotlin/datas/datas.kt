package datas

/**
 * Created by rz187 on 7/24/17.
 */

// USER DATA CLASSES
data class DOB(
        val day: Int = 0,
        val month: Int = 0,
        val year: Int = 0
)

data class Preference(
        val preference: String = "",
        val rating: Float = -1f
)

data class User(
        val firstName: String = "",
        val lastName: String = "",
        val dob: DOB = DOB(),
        val email: String = "",
        val phone: String = "",
        val preferences: Map<String, Preference> = HashMap<String, Preference>()
)

// VENUE DATA CLASSES
data class Photo(
        val id: String = "",
        val createdAt: Long = 0,
        val prefix: String = "",
        val suffix: String = "",
        val width: Int = 0,
        val height: Int = 0,
        val visibility: String = ""
)

data class Photos(
        val groups: List<Photo> = ArrayList<Photo>()
)

data class ReviewUser(
        val id: String = "",
        val firstName: String = "",
        val lastName: String = ""
)

data class Review(
        val id: String = "",
        val user: ReviewUser = ReviewUser(),
        val photo: Photo = Photo(),
        val canonicalUrl: String = "",
        val createdAt: Long = 0,
        val text: String = ""
)

data class Group(
        val item: List<Review> = ArrayList<Review>()
)
data class Tips(
        val groups: List<Group> = ArrayList<Group>()
)

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

data class Contact(
        val phone: String
)
data class Venue(
        val id: String = "",
        val name: String = "",
        val tags: List<String> = ArrayList<String>(),
        val utc: Int = -99,
        val location: Location = Location(),
        val rating: Float = -1f,
        val price: Int = -1,
        val photos: Photos,
        val tips: Tips = Tips(),
        val contact: Contact,
        val hours: Map<String, Pair<Int, Int>> = HashMap<String, Pair<Int, Int>>()
)

// REQUEST CLASSES
data class MultiResponse(
        val response: Array<Venue>
)

data class SingleResponse(
        val reponse: Venue
)
