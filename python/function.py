def addAll(ar):
    sum1 = 0
    for i in ar:
        sum1 = sum1 + i
    return sum1

def getArray():
    array = []
    while True:    
        number = float(input("Number"))
        if number == -1:
            break
        array.append(number)
    return array

array = getArray()
summ =addAll(array)
print(summ/len(array))