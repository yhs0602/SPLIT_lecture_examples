program hello
implicit none
integer a,b!,temp

print *, "gave a and b"
read *,a
read*, b
a=a+b ! a= A+B
b=a-b ! b= (A+B-B)
a=a-b ! a= (A+B-A)
print *, "swapped a is", a, "b is", b
end program hello
