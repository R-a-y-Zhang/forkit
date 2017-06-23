from data import oracle
from algos import haversine
from apis import google

ADDRESS1 = '116 East Partridge Lane, Cherry Hill, NJ 08003'
ADDRESS2 = '350 5th Ave., New York, NY 10118'
ADDRESS3 = '1600 Amphitheatre Parkway, Mountain View, CA 94043'

radius = 5000

addresses = [ADDRESS1, ADDRESS2, ADDRESS3]

for address in addresses:
    print(address)
    ll = google.get_latlng_for_address(address)
    print((ll['lat'], ll['lng']))
    print(haversine.get_bounding_box((ll['lat'], ll['lng']), 2000))
