def max1(lst):
    ret = lst[0]
    for x in lst[1:]:
        if x > ret:
            ret = x
    return ret