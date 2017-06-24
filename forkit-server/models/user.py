import json
from .model import Dictable

class User(Dictable):
    def __init__(self):
        self.first_name = ''
        self.last_name = ''
        self.dob_year = 0
        self.dob_month = 0
        self.dob_day = 0
        self.email = ''
        self.phone = ''

    def toDict(self): # () -> string:any
        return {
            "first_name": self.first_name,
            "last_name": self.last_name,
            "dob": ''.join(map(lambda n: str(n),
                            [self.dob_year, self.dob_month, self.dob_day])),
            "email": self.email,
            "phone": self.phone
        }

PREFERENCE_KEYS = [
    'asian',
    'chinese',
    'japanese',
    'korean',
    'indian',
    'thai',
    'sushi',
    'vietnamese',
    'filipino',
    'asian_fusion',
    'italian',
    'french',
    'greek',
    'turkish',
    'peruvian',
    'moroccan',
    'editerranean',
    'seafood',
    'cuban',
    'spanish',
    'cajun',
    'soul',
    'jewish',
    'belgian',
    'mexican',
    'fast',
    'cheap'
]

class Preferences(Dictable):
    def __init__(self, email):
        self.preferences = {k: 0.0 for k in PREFERENCE_KEYS}
        self.user_email = email

    def set_preferences(self, prefs): # (key:double) -> ()
        for pref, v in prefs.items():
            if pref in PREFERENCE_KEYS:
                self.preferences[pref] = v

    def toDict(self): # () -> string:any
        return {
            'email': self.user_email,
            'preferences': self.preferences
        }