program quad
implicit none
real a,b,c
complex d,x1,x2,sd
print *,"enter a, b, c:"
read *,a,b,c
d=b**2-4.0*a*c
sd=SQRT(d)
x1=(-b+sd)/(2*a)
x2=(-b-sd)/(2*a)
print *, "", x1, ",",x2
end program quad
