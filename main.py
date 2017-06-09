from flask import Flask, request
import pymysql
from models.user import User
from models.venue import Venue, Review
from db import dbutils as db
from apis import foursquare

app = Flask(__name__)

@app.route('/', methods=['GET'])
def main():
    return 200

@app.route('/register_user', methods=['POST'])
def register_user():
    data = request.get_json()
    user = User()
    user.first_name = data['first_name']
    user.last_name = data['last_name']
    user.dob_year = data['dob_year']
    user.dob_month = data['dob_month']
    user.dob_day = data['dob_day']
    user.email = data['email']
    user.phone = data['phone']
    db.insert_to_collection("user", user)

@app.route('/update_user', methods=['POST'])
def update_user():
    class Update:
        def __init__(self, email, fields):
            self.email = email
            self.fields = fields
    data = request.get_json()
    update = Update(data['email'], data['fields'])
    

@app.route('/set_utp', methods=['POST'])
def set_utp():
    pass

@app.route('/get_utp', methods=['GET'])
def get_utp():
    pass

@app.route('/browse', methods=['GET'])
def browse_restaurants():
    pass

@app.route('/new_gs', methods=['POST'])
def new_group():
    pass

@app.route('/update_gs', methods=['POST'])
def update_group():
    pass

@app.route('/get_gs', methods=['GET'])
def get_group():
    pass

app.run(debug=True, port=3000)