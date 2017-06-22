from db import dbutils
from apis import google, foursquare
from models.venue import Venue

class SORT_KEY:
    def __init__(self):
        DISTANCE    = 0
        PRICE       = 1
        RATING      = 2
        ALPHA       = 3
        PREFERENCE  = 4

def find_nearby_inapi(address, radius): # (string, double) -> Venue[]
    ll = google.get_latlng_for_address(address)
    dbutils.query(dbutils.VENUE_COLLECTION, {})

def find_nearby_exapi(address, radius):
    ll = google.get_latlng_for_address(address)
    venues = foursquare.search_venues_for_latlng(ll, radius)
    dbutils.insert(dbutils.VENUE_COLLECTION, *venues)
    return venues

def filter_selections(venues, critera): # (Venue[], key:any) -> Venue[]
    return []

def sort_by(venues, key): # (Venue[], SORT_KEY) -> Venue[]
    return []

def find_nearby(address, radius):
    return find_nearby_exapi(address, radius)