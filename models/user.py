import json
from .model import JSONAble

class User(JSONAble):
    def __init__(self):
        self.first_name = ''
        self.last_name = ''
        self.dob_year = 0
        self.dob_month = 0
        self.dob_day = 0
        self.email = ''
        self.phone = ''

    def toDict(self): # () -> string
        return {
            "first_name": self.first_name,
            "last_name": self.last_name,
            "dob": ''.join(map(lambda n: str(n),
                            [self.dob_year, self.dob_month, self.dob_day])),
            "email": self.email,
            "phone": self.phone
        }