program arrayt
implicit none
integer v(3), w(3), u(3), i
real(8) dollar(2,2)
open(unit=10, file='dollar2.dat', action = 'read')
read(10, *) dollar
v(1)=2
v(2)=-1
v(3)=0
w(1)=0
w(2)=1
w(3)=3
u=v+w
!print *, v
!print *, w
!print *, u
! matrix visualization
do i=1,2
   print *, dollar(i, :)
end do
end program arrayt
