program file
implicit none
integer i
open (unit=10, file='data.txt',action='WRITE')
write (10,123) 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
123 format(i3/i3/i3/i3/i3/i3/i3/i3/i3/i3/)
end program file
