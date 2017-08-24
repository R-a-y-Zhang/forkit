package dbc

import com.mongodb.MongoClient
import com.mongodb.client.model.Filters.eq
import datas.VenueMetadata
import org.bson.Document
/*
val USER_COLLECTION_NAME = "users"
val VENUES_COLLECTION_NAME = "venues"
val client = MongoClient()

val database = client.getDatabase("forkit")

val userColl = database.getCollection(USER_COLLECTION_NAME)
val venueColl = database.getCollection(VENUES_COLLECTION_NAME)

fun insertVenueToCollection(venue: Venue) {
    venueColl.insertOne(VenueMetadata(venue.id, venue.id).convertToDocument())
}

fun getVenueWithId(id: String): List<Document> {
    return venueColl.find(eq("id", id)).toList()
}*/
