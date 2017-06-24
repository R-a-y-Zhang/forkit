import math
from utils.reductions import reduce

EARTH_RADIUS = 6372.8
KM_OFFSET = 0.0075
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
    kms = edge / (1000 * 2)
    lloffset = math.sqrt(2*kms**2) * KM_OFFSET
    nw = (latlng[0] + lloffset, latlng[1] - lloffset)
    se = (latlng[0] - lloffset, latlng[1] + lloffset)
    return (nw, se)
