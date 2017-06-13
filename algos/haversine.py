import math
from utils.reductions import reduce

EARTH_RADIUS = 6360.0
def haversine(latlng1, latlng2): # ((double,double), (double,double)) -> double
    phi1 = latlng1[0]
    phi2 = latlng2[0]
    lambda1 = latlng1[1]
    lambda2 = latlng2[1]
    subeqns = [math.sin((phi2 - phi1) / 2) ** 2), [math.cos(phi1), math.cos(phi2), math.sin((lambda2 - lambda1) / 2) ** 2]]
    return 2 * EARTH_RADIUS * math.sqrt(subeqns[0] + reduce(subeqns[1], lambda acc, n: acc + n))