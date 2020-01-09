program iftest
implicit none
integer i
print*, "give me i"
read *, i
! if i>10 or i< 10 then wrong
! /= .ne. , .or., .and. 
if(i/=10) then
print *, "You are wrong"
else
print *, "YOU are correct"
endif 
end program iftest
