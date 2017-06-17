from db import dbutils
from apis import google
from models.venue import Venue

class SORT_KEY:
    def __init__(self):
        DISTANCE    = 0
        PRICE       = 1
        RATING      = 2
        ALPHA       = 3
        PREFERENCE  = 4

def find_nearby(address, radius): # (string, double) -> Venue[]
    ll = google.get_latlng_for_address(address)
    dbutils.query(dbutils.VENUE_COLLECTION, {})

def filter_selections(venues, critera): # (Venue[], key:any) -> Venue[]
    return []

def sort_by(venues, key): # (Venue[], SORT_KEY) -> Venue[]
    return []