package datas

import org.bson.Document

class VenueMetadata(val id: String, val fsqrId: String) {
    fun convertToDocument(): Document {
        val doc = Document()
        doc
                .append("id", id)
                .append("fsqrId", fsqrId)
        return doc
    }
}
