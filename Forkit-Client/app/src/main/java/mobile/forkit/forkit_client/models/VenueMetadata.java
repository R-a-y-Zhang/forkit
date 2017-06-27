package mobile.forkit.forkit_client.models;

/**
 * Created by horimori on 6/25/17.
 */

public class VenueMetadata {
    public String id;
    public VenueMetadata(String id) { this.id = id; }
    public String toString() {
        return String.format("{%s:%s}", "id", id);
    }
}
