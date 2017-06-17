def goe(json, key, default):
    try:
        return json[key]
    except KeyError:
        return default