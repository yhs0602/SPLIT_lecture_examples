program wtd2
implicit none
integer won, io
won=0
io=1
open(unit = 10, file='won.data', action = 'read', iostat=io)
open(unit = 11, file = 'dollar2.dat', action = 'write')
do while (io.eq.0)
   read(10, *, iostat = io) won
   if (io==0) then
      write(11,*) won/1200
   end if
end do
end program wtd2
