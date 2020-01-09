program prime
implicit none
! given a, prime p, ab===1 mod p, b?
! given prime p, a^(p-1)  ===1 mod p fermat small theorm
! so a^(p-2)===b mod p (used in crypto)

! print a ** b mod c
integer a, b, c, res,i
print *,"give a, b, c"
read *,a
read *,b
read *,c
!i=0
res=1
!do i=1,b
!res=res*a
!res=mod(res,c)
!end do

do while(b/=0)
if(mod(b,2)==1) then
res= res *a
end if
a=a**2

b=b/2
end do


print *, mod(res,c)

end program prime
