package datas
/* Contains data classes representing the schema within the collection */
// COLLECTION: VENUES

data class DBVenue(
        var id: String = "",
        var foursquareId: String = "",
        var name: String = "",
        var utc: Int = -99,
        var location: Location = Location(),
        var rating: Float = -1f,
        var contact: Contact = Contact(""),
        var hours: Map<String, Pair<Int, Int>> = HashMap<String, Pair<Int, Int>>(),

        var tags: List<Category> = ArrayList<Category>(),
        var verified: Boolean = false,
        var stat: Stats = Stats(),
        var likes: Likes = Likes(),
        var price: Price = Price(),
        var photos: Photos = Photos(),
        var tips: Tips = Tips()
)
/* helper */
fun mergeVenueData(venueBase: VenueBasic, venueDetail: VenueDetail): DBVenue {
    val venue: DBVenue = DBVenue()
    venue.id = venueBase.id
    venue.foursquareId = venueBase.foursquareId
    venue.name = venueBase.name
    venue.utc = venueBase.utc
    venue.location = venueBase.location
    venue.rating = venueBase.rating
    venue.contact = venueBase.contact
    venue.hours = venueBase.hours

    venue.tags = venueDetail.tags
    venue.verified = venueDetail.verified
    venue.stat = venueDetail.stat
    venue.likes = venueDetail.likes
    venue.price = venueDetail.price
    venue.photos = venueDetail.photos
    venue.tips = venueDetail.tips
    return venue
}