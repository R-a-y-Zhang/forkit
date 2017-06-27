import json
from models.model import Dictable

class Photo(Dictable):
    def __init__(self):
        self.author = ''
        self.author_url = ''
        self.photo_prefix = ''
        self.photo_suffix = ''
        self.width = 0
        self.height = 0

    def toDict(self):
        return {
            'author': self.author,
            'photo_prefix': self.photo_prefix,
            'photo_suffix': self.photo_suffix,
            'width': self.width,
            'height': self.height
        }

class Review(Dictable):
    def __init__(self):
        self.author = ''
        self.author_url = ''
        self.lang = ''
        self.time = -1
        self.text = ''

    def toDict(self): # () -> string
        return {
            'author': self.author,
            'author_url': self.author_url,
            'lang': self.lang,
            'time': self.time,
            'text': self.text
        }

class VenueMetadata(Dictable):
    def __init__(self, id = ''):
        self.id = id

    def toDict(self):
        return {
            'id': self.id
        }

class Venue(Dictable):
    def __init__(self):
        self._id = ''
        self.foursquareid = ''
        self.venue_name = ''
        self.categories = []
        self.lat = None
        self.lng = None
        self.utc = None
        self.address = ''
        self.postal_code = ''
        self.city = ''
        self.state = ''
        self.cc = ''
        self.rating = -1
        self.price = -1
        self.contacts = {}
        self.image_urls = []
        self.hours = []
        self.reviews = []

    def toDict(self): # () -> string
        return {
            '_id': self._id,
            'foursquareid': self.foursquareid,
            'venue_name': self.venue_name,
            'categories': self.categories,
            'location': {
                'lat': self.lat,
                'lng': self.lng,
                'utc': self.utc,
                'address': self.address,
                'city': self.city,
                'state': self.state,
                'cc': self.cc
            },
            'rating': self.rating,
            'price': self.price,
            'contacts': self.contacts,
            'image_urls': list(map(lambda n: n.toDict(), self.image_urls)),
            'hours': self.hours,
            'reviews': list(map(lambda n: n.toDict(), self.reviews))
        }