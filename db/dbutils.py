from pymongo import MongoClient
from models.model import Dictable

client = MongoClient()

forkitdb = client.forkit
user_collection = forkitdb.users
user_pref_collection = forkitdb.userpref
group_collection = forkitdb.groups
venue_collection = forkitdb.venues

USER_COLLECTION = "user"
GROUP_COLLECTION = "group"
VENUE_COLLECTION = "venue"
USER_PREFERENCE_COLLECTION = "userpref"

collections = {
    USER_COLLECTION: user_collection,
    GROUP_COLLECTION: group_collection,
    VENUE_COLLECTION: venue_collection,
    USER_PREFERENCE_COLLECTION: user_pref_collection
}

def insert(coll, *documents): # (string, JSONAble) -> InsertOneResult/InsertManyResult
    if len(documents) == 1:
        return collections[coll].insert_one(documents[0].toJSON())
    return collections[coll].insert_many(map(documents, lambda d: d.toJSON()))

def query(coll, query, find_one=True): # (string, string:any, boolean?) -> Document/Cursor
    if find_one:
        return collections[coll].find_one(query)
    return collections[coll].find(query)

def update(coll, filter, update, update_one=True): # (string, string:any, string:any, boolean?) -> UpdateResult
    if update_one:
        return collections[coll].update_one(filter, update)
    return collections[coll].update_many(filter, update)

def delete(coll, criteria, delete_one=True): # (string, string:any, boolean?) -> DeleteResult
    if delete_one:
        return collections[coll].delete_one(criteria)
    return collections[coll].delete_many(criteria)
