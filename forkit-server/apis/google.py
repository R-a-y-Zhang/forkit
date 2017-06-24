import requests, json

GOOGLE_API_KEY = 'AIzaSyALdpww3nZtLmU6x1-ROvfjGXKwSm11si4'
GOOGLE_GEOCODE_API = 'https://maps.googleapis.com/maps/api/geocode/json'

def get_latlng_for_address(address): # (string) -> {lat: <lat>, lng: <lng>}
    request_url = '{}?{}={}&{}={}'.format(GOOGLE_GEOCODE_API,
                                            'address', address,
                                            'key', GOOGLE_API_KEY)
    r = requests.post(request_url)
    data = r.json()
    return data['results'][0]['geometry']['location']