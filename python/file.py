input1 = open("banbok.py")
count = 0
for line in input1:
    i = line.index('line')
    i = i+4
    if 'line' in line:
        count = count + 1 # count +=1 #count++
print(count)

