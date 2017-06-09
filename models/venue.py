import json
from utils import jsonutils as ju

class Review:
    def __init__(self):
        self.author = ''
        self.author_url = ''
        self.lang = ''
        self.time = -1
        self.text = ''

    def toJSON(self): # () -> string
        return json.dumps({
            'author': self.author,
            'author_url': self.author_url,
            'lang': self.lang,
            'time': self.time,
            'text': self.text
        })

class Venue:
    def __init__(self):
        self.id = ''
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
        self.hours = {}
        self.reviews = []

    def toJSON(self): # () -> string
        return json.dumps({
            'id': self.id,
            'venue_name': self.venue_name,
            'categories': self.categories,
            'lat': self.lat,
            'lng': self.lng,
            'utc': self.utc,
            'address': self.address,
            'city': self.city,
            'state': self.state,
            'cc': self.cc,
            'rating': self.rating,
            'price': self.price,
            'contacts': self.contacts,
            'image_urls': self.image_urls,
            'hours': self.hours,
            'reviews': map(lambda n: n.toJSON(), self.reviews) # Review[] -> string[]
        })