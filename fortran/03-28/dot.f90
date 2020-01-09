program dot
implicit none
integer, parameter:: n = 1024
integer:: i, j, k, count1, count2, cr, cmax
real, dimension(n,n):: A, B, C
real time
A=0.0
B=0.0
do i=2, n-1
   A(i,i-1)=1.0; A(i,i)=2.0; A(i,i+1)=1.0;
   B(i,i-1)=2.0; B(i,i)=-4.0; B(i,i+1)=2.0;
enddo
A(1,1)=2.0; A(1,2)=1.0; A(n,n-1)=1.0; A(n,n)=2.0
B(1,1)=-4.0; B(1,2) = 2.0; B(n,n-1) = 2.0; B(n,n)=-4.0

! C = A dot B
! method 1
c = 0.0
call system_clock(count1, cr, cmax)
do i=1,n
   do j=1,n
      do k=1,n
         c(i,j)=c(i,j)+A(i,k)*B(k,j)
      enddo
   enddo
enddo
call system_clock(count2,cr,cmax)
time = dble(count2-count1)/dble(cr)
print *, 'naive time=',time,'seconds'
!method 2
call system_clock(count1, cr, cmax)
C = matmul(A,B)
call system_clock(count2, cr, cmax)
time = dble(count2-count1)/dble(cmax)
print *, 'internal matmul = ' ,time, 'seconds'
!method 4
call system_clock(count1, cr, cmax)
do j = 1, n
   do k = 1, n
      do i=1,n
         c(i,j)=c(i,j)+a(i,k)*b(k,j)
      enddo
   enddo
enddo
call system_clock(count2, cr, cmax)
time = dble(count2-count1)/dble(cmax)
print *, 'method 4= ', time , 'seconds'
end program dot
