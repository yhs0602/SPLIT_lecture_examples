program hello
implicit none
integer a, b, c, i, res
! a^b mod c
c=1223
b=1222
do i=1, c-1
! everytime i^ b mod C computing for i=1~c-1
   a = i
   res=1
   do while (b>0)
      if(mod(b,2).eq.1) then
         res = res * a
         res = mod(res,c)
      end if
      b = b/2
      a = a**2
      a = mod(a,c)
   end do
   if(res/=1) then
      print *, c, 'may not be prime'
   end if
   print *, res
end do
end program hello
