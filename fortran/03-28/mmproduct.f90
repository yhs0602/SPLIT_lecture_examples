program mmproduct
  implicit none

  integer, parameter :: n= 1024
  integer :: i,j,k, count1, count2,cr,cmax 
  real,dimension(n,n)::A,B,C
  real :: time

  A=0.0;B=0.0
  do i=2,n-1
     A(i,i-1)=1.0;A(i,i)=2.0;A(i,i+1)=1.0;
     B(i,i-1)=2.0;B(i,i)=-4.0;B(i,i+1)=2.0;
  enddo
  A(1,1)=2.0;A(1,2)=1.0;A(n,n-1)=1.0;A(n,n)=2.0
  B(1,1)=-4.0;B(1,2)=2.0;B(n,n-1)=2.0;B(n,n)=-4.0

  !method 1
  C = 0.0
  call system_clock(count1,cr,cmax)
  do i=1,n
     do j=1,n
        do k=1,n
           C(i,j)=C(i,j)+A(i,k)*B(k,j)
        end do
     end do
  end do
  call system_clock(count2,cr,cmax)
  time = dble(count2-count1)/dble(cr)
  print *, 'naive time=', time,' seconds'

  !method 2
  call system_clock(count1,cr,cmax)
  C=matmul(A,B)
  call system_clock(count2,cr,cmax)
  time = dble(count2-count1)/dble(cr)
  print *, 'internal matmul=', time,' seconds'

  !method 3
  call system_clock(count1,cr,cmax)  
  C(1,1)=A(1,1)*B(1,1)+A(1,2)*B(2,1)
  C(1,2)=A(1,1)*B(1,2)+A(1,2)*B(2,2)
  C(1,3)=A(1,2)*B(2,3)
  C(2,1)=A(2,1)*B(1,1)+A(2,2)*B(2,1)
  C(2,2)=A(2,1)*B(1,2)+A(2,2)*B(2,2)+A(2,3)*B(3,2)
  C(2,3)=A(2,2)*B(2,3)+A(2,3)*B(3,3)
  C(2,4)=A(2,3)*B(3,4)
  do i=2,n-2
     C(i,i-2)=A(i,i-1)*B(i-1,i-2)
     C(i,i-1)=A(i,i-1)*B(i-1,i-1)+A(i,i)*B(i,i-1)
     C(i,i)=A(i,i-1)*B(i-1,i)+A(i,i)*B(i,i)+A(i,i+1)*B(i+1,i)
     C(i,i+1)=A(i,i)*B(i,i+1)+A(i,i+1)*B(i+1,i+1)
     C(i,i+2)=A(i,i+1)*B(i+1,i+2)
  end do
  C(n-1,n-3)=A(n-1,n-2)*B(n-2,n-3)
  C(n-1,n-2)=A(n-1,n-2)*B(n-2,n-2)+A(n-1,n-1)*B(n-1,n-2)
  C(n-1,n-1)=A(n-1,n-2)*B(n-2,n-1)+A(n-1,n-1)*B(n-1,n-1)+A(n-1,n)*B(n,n-1)
  C(n-1,n)=A(n-1,n-1)*B(n-1,n)+A(n-1,n)*B(n,n)
  C(n,n-2)=A(n,n-1)*B(n-1,n-2)
  C(n,n-1)=A(n,n-1)*B(n-1,n-1)+A(n,n)*B(n,n-1)
  C(n,n)=A(n,n-1)*B(n-1,n)+A(n,n)*B(n,n)
  call system_clock(count2,cr,cmax)
  time = dble(count2-count1)/dble(cr)
  print *, 'time=', time,' seconds'
  
end program mmproduct
