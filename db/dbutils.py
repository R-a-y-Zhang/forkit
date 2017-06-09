from pymongo import MongoClient
from models.model import JSONAble

client = MongoClient()

forkitdb = client.forkit
user_collection = forkitdb.users
group_collection = forkitdb.groups
venue_collection = forkitdb.venues

USER_COLLECTION = "user"
GROUP_COLLECTION = "group"
VENUE_COLLECTION = "venue"

collections = {
    USER_COLLECTION: user_collection,
    GROUP_COLLECTION: group_collection,
    VENUE_COLLECTION: venue_collection
}

def insert_to_collection(collection, document): # (string, JSONAble) -> ObjectId
    return collections[collection].insert_one(document.toDict()).inserted_id

def query(collection, query, find_one = True): # (string, query: {key:string : value:any}, boolean) -> Document[]
    single_query = lambda coll: coll.find_one(query)
    multi_query = lambda coll: coll.find(query)
    if find_one:
        return single_query(collections[collection])
    return multi_query(collections[collection])