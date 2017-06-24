package mobile.forkit.forkit_client.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Venue {
    @SerializedName("venue_name")
    public String venueName;
    public List<String> categories;
    public class Location {
        public double lat, lng;
        public int utc;
        public String address, city, state, cc;
    }
    public Location location;
    public int rating, price;
    public class Contact {
        public String phone, email;
    }
    public Contact contacts;
    public class Image {
        public String author;
        @SerializedName("photo_prefix")
        public String photoPrefix;
        @SerializedName("photo_suffix")
        public String photoSuffix;
        public int width, height;
    }
    @SerializedName("image_urls")
    public List<Image> imageUrls;
    public class Hour {
        public String day, startTime, endTime;
    }
    public List<Hour> hours;
    public class Review {
        public String author, lang, text;
        @SerializedName("author_url")
        public String authorUrl;
        public long time;
    }
    public List<Review> reviews;
}
