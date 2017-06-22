import requests, json
from models.venue import Venue, Review, Photo
from apis import google

FOURSQUARE_KEY = 'IKYQTRR11WRM4BPYIIGLCBVRPV0QVHTFBSPJIG2K5P1NCU53'
FOURSQUARE_SECRET = 'FY4WM5FN5E33PVH0VEAKC30X0BQNIGAHNIFHC4QX0U4HYIUB'

FOURSQUARE_VENUE_SEARCH_URL = 'https://api.foursquare.com/v2/venues/search'
FOURSQUARE_VENUE_DETAILS_URL = 'https://api.foursquare.com/v2/venues/'

def append_key_secret(url): # (string) -> string
    return '{}&{}={}&{}={}&v=20170601'.format(url,
            'client_id', FOURSQUARE_KEY,
            'client_secret', FOURSQUARE_SECRET)

contains = lambda j, k, d: (j[k] if k in j else d)

def search_venues_for_latlng(latlng, radius): # (double[], double) -> Venue[]
    request_url = append_key_secret(FOURSQUARE_VENUE_SEARCH_URL + "?" + \
                                    "ll={},{}".format(latlng['lat'], latlng['lng']) + '&' + \
                                    "radius={}".format(radius) + '&' + "query=restaurant")
    print(request_url)
    r = requests.get(request_url)
    fsvs = r.json()['response']['venues'] # FourSquare VenueS
    venues = []
    for v in fsvs:
        venue = Venue()
        venue.id = v['id']
        venue.venue_name = v['name']
        venue.contacts['phone'] = contains(v['contact'], 'phone', '')
        location = v['location']
        venue.address = contains(location, 'address', '')
        venue.city = contains(location, 'city', '')
        venue.postal_code = contains(location, 'postalCode', '')
        venue.state = contains(location, 'state', '')
        venue.cc = contains(location, 'cc', '')
        venue.lat = contains(location, 'lat', '')
        venue.lng = contains(location, 'lng', '')
        get_venue_details(venue)
        venues.append(venue)
    return venues

def get_venue_details(venue): # (Venue) -> void
    request_url = append_key_secret(FOURSQUARE_VENUE_DETAILS_URL + venue.id + '?')
    print(request_url)
    r = requests.get(request_url)
    details = r.json()['response']['venue']
    categories = (details['categories'] if details['categories'] else [])
    venue.categories = list(map(lambda category: category['shortName'], categories))
    if 'price' in details and 'tier' in details['price']:
        venue.price = details['price']['tier']
    venue.rating = contains(details, 'rating', -1)
    if len(details['photos']['groups']) > 0:
        photosList = details['photos']['groups'][0]['items']
        photos = []
        for p in photosList:
            photo = Photo()
            if p['user']:
                photo.author = '{}, {}'.format((p['user']['lastName'] if 'lastName' in p['user'] else ''), p['user']['firstName'])
            photo.photo_prefix = p['prefix']
            photo.photo_suffix = p['suffix']
            photos.append(photo)
        venue.image_urls = photos
    if len(details['tips']['groups']) > 0:
        reviewsList = details['tips']['groups'][0]['items']
        reviews = []
        for r in reviewsList:
            review = Review()
            if r['user']:
                review.author = '{}, {}'.format((r['user']['lastName'] if 'lastName' in r['user'] else ''), r['user']['firstName'])
            review.text = r['text']
            review.time = r['createdAt']
            reviews.append(review)
        venue.reviews = reviews