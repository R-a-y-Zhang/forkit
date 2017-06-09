from pymongo import MongoClient
from .models.model import JSONAble

client = MongoClient()

forkitdb = client.forkit
user_collection = forkitdb.users
group_collection = forkitdb.groups
venue_collection = forkitdb.venues

USER_COLLECTION = "user"
GROUP_COLLECTION = "group"
VENUE_COLLECTION = "venue"

def insert_to_collection(collection, document): # (string, JSONAble) -> ObjectId
    if collection == VENUE_COLLECTION:
        return venue_collection.insert_one(document.toDict()).inserted_id
    if collection == GROUP_COLLECTION:
        return group_collection.insert_one(document.toDict()).inserted_id
    if collection == USER_COLLECTION:
        return user_collection.insert_one(document.toDict()).inserted_id

def query(collection, query, find_one = True): # (string, query: {key:string : value:any}, boolean) -> Document[]
    single_query = lambda coll: coll.find_one(query)
    multi_query = lambda coll: coll.find(query)
    coll = None
    if collection == VENUE_COLLECTION:
        coll = user_collection
    elif collection == GROUP_COLLECTION:
        coll = group_collection
    elif collection == USER_COLLECTION:
        coll = user_collection
    if find_one:
        return single_query(coll)
    return multi_query(coll)