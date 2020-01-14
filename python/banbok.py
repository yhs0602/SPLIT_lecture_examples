
array = []
while True:    
    number = float(input("Number"))
    if number == -1:
        break
    array.append(number)
    print(array)


sum1 = 0
length = len(array)

for i in array:
    sum1 = sum1 + i
print(sum1)
print(sum1/length)

