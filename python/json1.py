import json
#
#read1 =json.load("my.json")
##read1["firstname"]
#read1["phonenumbers"][0]

newjsondic = {"name":"Payel", "phone":["123","123",123]}

print(json.dumps(newjsondic,indent = 4))