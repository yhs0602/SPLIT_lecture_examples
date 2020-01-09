program dowhiletest
implicit none
integer i, n, res
res=0
print *, "GIve me n"
read *, n
i=1
do while(i.le.n)
res=res+i
i=i+1
end do
print *,res
end program dowhiletest

!in the just do loop you cannot modify iterator ( compilation error)
