program won2dollar
implicit none
integer n, i
real(8):: won, dollar
open(unit = 10, file = 'won.data', action = 'read')
open(unit = 11, file = 'dollar.data', action = 'write')
read (10, *) n
write(11,*) , n
do i = 1,n
   read(10,*) won
   dollar = won / 1200
   write(11,*) dollar
end do
end program won2dollar
