import numpy
import copy

def printmatrix(m):
    for l in m:
        print(l)

def backward(U,b,x):
    print("Back")
    print(b)
    for i in range(2,-1,-1):
        print ("i=",i)
        x[i]=b[i]
        for j in range(2,i,-1):
            x[i]-=U[i][j]*x[j]
        x[i]/=U[i][i]
        print("U")
        printmatrix(U)
        print ('x', x)
    print("Back done")
    return x

"""
def backward(U, b):
    x = [0,0,0]
    for i in range(2,-1,-1):
        tmp = 0
        for j in range(2,i,-1):
            tmp += U[i][j] * x[j]
        x[i] = (b[i] - tmp)/U[i][i]
    return x
"""
A = [[2,3,1], [1,-1,1], [0,4,2]]
B = copy.deepcopy(A)
b = [2,1,3]
bb = [2,1,3]
#x = [0,0,0]
#L = [[0,0,0]]*3
#U = [[0,0,0]]*3

printmatrix(A)
for i in range(3):
    for j in range(1+i,3):
        #print (i,j)
        print(A[i][i])
        print(A[j][i])
        r = A[j][i]/A[i][i]
        print('r =', r)
        for k in range(3):
            A[j][k] -= A[i][k]*r
        b[j] -= b[i] * r
        printmatrix(A)
print(b)
U = A
x = [0,0,0]
x =  backward(U,b, x)
print(x)
printmatrix(B)
tmp2 = numpy.matmul(B,x)
print(tmp2)