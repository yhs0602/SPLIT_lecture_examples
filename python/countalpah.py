
inputfile = open("banbok.py")

mymap = {}
for line in inputfile:
    for c in line:
        if c.isupper() or c.islower():
            mymap[c] = mymap.get(c,0) + 1

print(mymap)

for key  in sorted(mymap.keys(), key = lambda i: mymap[i],reverse = True):
    print(key,mymap[key])

#mylist = [i for i in sorted(mymap.)]
#print(mylist)