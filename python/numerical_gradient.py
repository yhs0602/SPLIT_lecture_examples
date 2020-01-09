def f(x):
    return x**2

def fprime(f, x):
    h = 1e-14
    return (f(x+h)-f(x))/h

import math
fprime(lambda x: math.exp(x), 0)

print(math.sqrt(-1+0j))