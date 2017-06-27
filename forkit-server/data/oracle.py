from db import dbutils
from apis import google, foursquare
from models.venue import Venue, VenueMetadata

class SORT_KEY:
    def __init__(self):
        DISTANCE    = 0
        PRICE       = 1
        RATING      = 2
        ALPHA       = 3
        PREFERENCE  = 4

# find nearby venues using the local db (using addr)
def find_nearby_inapi(address, radius): # (string, double) -> Venue[]
    ll = google.get_latlng_for_address(address)
    return dbutils.query(dbutils.VENUE_COLLECTION, {})

# find nearby using foursquare api and store it to db
def find_nearby_foursquare(address, radius):
    ll = google.get_latlng_for_address(address)
    venues = foursquare.search_venues_for_latlng(ll, radius)
    dbutils.insert(dbutils.VENUE_COLLECTION, *venues)
    return list(map(lambda v: VenueMetadata(v._id), venues))

# find nearby venues using local db (using lat lng)
def find_nearby_ll_inapi(ll, radius):
    return dbutils.query(dbutils.VENUE_COLLECTION, {})

# find nearby venues using foursquare api and store to db (using lat lng)
def find_nearby_for_ll_foursquare(ll, radius):
    venues = foursquare.search_venues_for_latlng(ll, radius)
    dbutils.insert(dbutils.VENUE_COLLECTION, *venues)
    return list(map(lambda v: VenueMetadata(v._id), venues))

def get_venue_with_id(id):
    return dbutils.query(dbutils.VENUE_COLLECTION, {'_id': id})

def filter_selections(venues, critera): # (Venue[], key:any) -> Venue[]
    return []

def sort_by(venues, key): # (Venue[], SORT_KEY) -> Venue[]
    return []

def find_nearby(address, radius):
    return find_nearby_foursquare(address, radius)

def find_nearby_ll(ll, radius):
    ll = ll.split(',')
    return find_nearby_for_ll_foursquare({'lat': ll[0], 'lng': ll[1]}, radius)