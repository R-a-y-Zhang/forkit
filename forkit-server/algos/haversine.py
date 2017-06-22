import math
from utils.reductions import reduce

EARTH_RADIUS = 6372.8
def haversine(latlng1, latlng2): # ((double,double), (double,double)) -> double
    phi1 = latlng1[0]
    phi2 = latlng2[0]
    lambda1 = latlng1[1]
    lambda2 = latlng2[1]
    delta_phi = math.radians(phi2 - phi1)
    delta_lambda = math.radians(lambda2 - lambda1)
    phi1 = math.radians(phi1)
    phi2 = math.radians(phi2)
    subeqns = [math.sin(delta_phi / 2) ** 2, math.cos(phi1) * math.cos(phi2) * math.sin(delta_lambda / 2) ** 2]
    inner_sum = subeqns[0] + subeqns[1]
    return EARTH_RADIUS * 2 * math.atan2(math.sqrt(inner_sum), math.sqrt(1-inner_sum))

def get_bounding_box(latlng, edge): # ((double, double), double) -> ((double, double), (double, double))
    pass

testLats = ((29.425856, -98.561619), (40.489427, -74.451804), (37.770383, -122.466525), (48.907846, -95.317017)) # Texas, NJ, California, Minnesotta
d = 0.0075 # 1 km offset
for testLat in testLats:
    print(haversine(testLat, (testLat[0]+d, testLat[1]+d)))
