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
        val author: String = "",
        val authorUrl: String = "",
        val photoPrefix: String = "",
        val photoSuffix: String = "",
        val width: Int = 0,
        val height: Int = 0
)

data class Review(
        val author: String = "",
        val authorUrl: String = "",
        val lang: String = "",
        val time: Long = 0,
        val text: String = ""
)

data class Location(
        val address: String = "",
        val city: String = "",
        val state: String = "",
        val cc: String = "",
        val zipcode: String = "",
        val lat: Float = -1f,
        val lng: Float = -1f
)
data class Venue(
        val id: String = "",
        val venueName: String = "",
        val categories: List<String> = ArrayList<String>(),
        val utc: Int = -99,
        val location: Location = Location(),
        val rating: Float = -1f,
        val price: Int = -1,
        val images: List<Photo> = ArrayList<Photo>(),
        val reviews: List<Review> = ArrayList<Review>(),
        val contact: Map<String, String> = HashMap<String, String>(),
        val hours: Map<String, Pair<Int, Int>> = HashMap<String, Pair<Int, Int>>()
)
