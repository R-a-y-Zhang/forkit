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
    request_url = append_key_secret(FOURSQUARE_VENUE_SEARCH_URL + "?" + \
                                    "ll={},{}".format(latlng['lat'], latlng['lng']) + '&' + \
                                    "radius={}".format(radius) + '&' + "query=restaurants")
    r = requests(request_url)
    fsvs = r.json()['response']['venues'] # FourSquare VenueS
    venues = []
    contains = lambda j, k, d: (j[k] if j[k] else d)
    for v in fsvs:
        venue = Venue()
        venue.id = v['id']
        venue.venue_name = v['name']
        venue.categories['phone'] = contains(v['contact'], 'phone', '')
        location = v['location']
        venue.address = contains(location, 'address', '')
        venue.city = contains(location, 'city', '')
        venue.postal_code = contains(location, 'postalCode', '')
        venue.state = contains(location, 'state', '')
        venue.cc = contains(location, 'cc', '')
        venue.lat = contains(location, 'lat', '')
        venue.lng = contains(location, 'lng', '')
        get_venue_details(venue)
        venues.push(venue)
    pass

def get_venue_details(venue): # (Venue) -> void
    request_url = FOURSQUARE_VENUE_DETAILS_URL + venue.id
