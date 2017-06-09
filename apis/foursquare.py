import requests, json
from models.venue import Venue, Review

FOURSQUARE_KEY = 'IKYQTRR11WRM4BPYIIGLCBVRPV0QVHTFBSPJIG2K5P1NCU53'
FOURSQUARE_SECRET = 'FY4WM5FN5E33PVH0VEAKC30X0BQNIGAHNIFHC4QX0U4HYIUB'

FOURSQUARE_VENUE_SEARCH_URL = 'https://api.foursquare.com/v2/venues/search'
FOURSQUARE_VENUE_DETAILS_URL = 'https://api.foursquare.com/v2/venues/'

def append_key_secret(url): # (string) -> string
    return '{}&{}={}&{}={}'.format(url,
            'key', FOURSQUARE_KEY,
            'secret', FOURSQUARE_SECRET)

def search_venues_for_latlng(latlng, radius): # (double[], double) -> Venue[]
    pass

def get_venue_details(venue): # (Venue) -> void
    pass