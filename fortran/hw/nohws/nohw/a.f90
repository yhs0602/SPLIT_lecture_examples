program test
implicit none  ! disable implicit d.
real a,b,c
real x1, x2
real xre,xim
real d
print *,"Please input a ,b ,c"
read *,a,b,c
d=b**2-4.0*a*c
if(d<0) then
xim=SQRT(-d)/(2*a)
xre=-b/(2*a)
print *,"The eqn. has two complex roots:",xre,"+/-",xim,"i"
else if (d==0)then
x1=-b/(2*a)
print *,"The eqn. has two equal roots:",x1
else
x1=(-b+SQRT(d))/(2*a)
x2=(-b-SQRT(d))/(2*a)
print *,"The eqn. has two real roots:",x1,",", x2
end if
end program test
