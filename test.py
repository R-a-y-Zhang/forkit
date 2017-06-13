from algos import haversine

MEASURED_DIST = 51.54
latlng1 = (39.872011, -74.935225)
latlng2 = (40.523343, -74.458807)
print(haversine.haversine(latlng1, latlng2))