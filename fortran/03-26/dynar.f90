program dynamic_ar
implicit none
integer n, i, j
integer,allocatable A(:,:), B(:)
read *, n
! make n by n matrix
allocate(A(n,n),B(n))
do i=1,n
   do j=1, n
      A(i,j)=i-j
   end do
   b(i)=i
end do
end program dynamic_ar
