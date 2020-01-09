program dotest
implicit none
integer i, n, res
print *, "Give me n"
read *, n
res=0

do i=n,1,-1
    res=res+i
enddo
print *, res
end program dotest
