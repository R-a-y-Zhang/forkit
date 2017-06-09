from flask import Flask, request
import pymysql
from models.user import User
from models.venue import Venue, Review

app = Flask(__name__)

@app.route('/', method='GET')
def main():
    return 200

@app.route('/register_user', method='POST')
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

@app.route('/update_user', method='POST')
def update_user():
    class Update:
        def __init__(self, email, fields):
            self.email = email
            self.fields = fields
    data = request.get_json()
    update = Update(data['email'], data['fields'])
    

@app.route('/set_utp', method='POST')
def set_utp():
    pass

@app.route('/get_utp', method='GET')
def get_utp():
    pass

@app.route('/browse', method='GET')
def browse_restaurants():
    pass

@app.route('/new_gs', method='POST')
def new_group():
    pass

@app.route('/update_gs', method='POST')
def update_group():
    pass

@app.route('/get_gs', method='GET')
def get_group():
    pass

app.run(debug=True, port=3000)