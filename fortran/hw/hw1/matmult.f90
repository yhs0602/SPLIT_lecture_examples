program matmult
  implicit none
  integer,parameter::n=1024
  real,dimension(n,n) :: A,B,C
  real time
  integer i, j, k , t ! t is for storing i + #
  integer count1, count2, cr, cmax
  ! Initialize A, B
  A=0.0; B=0.0
  do i=2,n-1
     A(i,i-1) = 1.0; A(i,i) = 2.0; A(i,i+1) = 1.0;
     B(i,i-1) = 2.0; B(i,i) =-4.0; B(i,i+1) = 2.0;
  end do
  A(1,1)= 2.0; A(1,2)=1.0; A(n,n-1)=1.0; A(n,n)= 2.0
  B(1,1)=-4.0; B(1,2)=2.0; B(n,n-1)=2.0; B(n,n)=-4.0
  
  C=0.0
  
  ! Method 1
  call system_clock(count1,cr,cmax)
  do i=1,n
     do j=1,n
        do k=1,n
           c(i,j)=c(i,j)+a(i,k)*b(k,j)
        end do
     end do
  end do
  call system_clock(count2,cr,cmax)
  time=dble(count2-count1)/dble(cr)
  print*,'time=',time,' seconds.'
  
  ! Method 2
  call system_clock(count1,cr,cmax)
  C = matmul(a,b)
  call system_clock(count2,cr,cmax)
  time=dble(count2-count1)/dble(cr)
  print*,'time=',time,' seconds.'
  
  ! Method 3
  
  ! Memory access patterns
  ! ijk
  call system_clock(count1,cr,cmax)
  do i=1,n
     do j=1,n
        do k=1,n
           c(i,j)=c(i,j)+a(i,k)*b(k,j)
        end do
     end do
  end do
  call system_clock(count2,cr,cmax)
  time=dble(count2-count1)/dble(cr)
  print*,'time=',time,' seconds.'
! kji
  call system_clock(count1,cr,cmax)
  do k=1,n
     do j=1,n
        do i=1,n
           c(i,j)=c(i,j)+a(i,k)*b(k,j)
        end do
     end do
  end do
  call system_clock(count2,cr,cmax)
  time=dble(count2-count1)/dble(cr)
  print*,'time=',time,' seconds.'
! kij
  call system_clock(count1,cr,cmax)
  do k=1,n
     do i=1,n
        do j=1,n
           c(i,j)=c(i,j)+a(i,k)*b(k,j)
        end do
     end do
  end do
  call system_clock(count2,cr,cmax)
  time=dble(count2-count1)/dble(cr)
  print*,'time=',time,' seconds.'
! jik
  call system_clock(count1,cr,cmax)
  do j=1,n
     do i=1,n
        do k=1,n
           c(i,j)=c(i,j)+a(i,k)*b(k,j)
        end do
     end do
  end do
  call system_clock(count2,cr,cmax)
  time=dble(count2-count1)/dble(cr)
  print*,'time=',time,' seconds.'
! jki
  call system_clock(count1,cr,cmax)
  do j=1,n
     do k=1,n
        do i=1,n
           c(i,j)=c(i,j)+a(i,k)*b(k,j)
        end do
     end do
  end do
  call system_clock(count2,cr,cmax)
  time=dble(count2-count1)/dble(cr)
  print*,'time=',time,' seconds.'
! ikj
  call system_clock(count1,cr,cmax)
  do i=1,n
     do k=1,n
        do j=1,n
           c(i,j)=c(i,j)+a(i,k)*b(k,j)
        end do
     end do
  end do
  call system_clock(count2,cr,cmax)
  time=dble(count2-count1)/dble(cr)
  print*,'time=',time,' seconds.'

  ! unroll jki cuz fastest among above 6
  ! unroll by j
  call system_clock(count1,cr,cmax)
  do j=1,n-3,4
     do k=1,n
        do i=1,n
           t = j
           c(i,j)=c(i,t)+a(i,k)*b(k,t)
           t = t + 1
           c(i,j+1)=c(i,t)+a(i,k)*b(k,t)
           t = t + 1
           c(i,j+2)=c(i,t)+a(i,k)*b(k,t)
           t = t + 1
           c(i,j+3)=c(i,t)+a(i,k)*b(k,t)
           t = t + 1
        end do
     end do
  end do
  call system_clock(count2,cr,cmax)
  time=dble(count2-count1)/dble(cr)
  print*,'time=',time,' seconds.'
! unroll by k (2)
  call system_clock(count1,cr,cmax)
  do j=1,n
     do k=1,n-1,2
        do i=1,n
           c(i,j)=c(i,j)+a(i,k)*b(k,j) + a(i,k+1)*b(k+1,j) 
        end do
     end do
  end do
  call system_clock(count2,cr,cmax)
  time=dble(count2-count1)/dble(cr)
  print*,'time=',time,' seconds.'
! unroll by i
  call system_clock(count1,cr,cmax)
  do j=1,n
     do k=1,n
        do i=1,n-3,4
           t = i
           c(i,j)=c(t,j)+a(t,k)*b(k,j)
           t = t + 1
           c(i,j)=c(t,j)+a(t,k)*b(k,j)
           t = t + 1
           c(i,j)=c(t,j)+a(t,k)*b(k,j)
           t = t + 1
           c(i,j)=c(t,j)+a(t,k)*b(k,j)
           t = t + 1
        end do
     end do
  end do
  call system_clock(count2,cr,cmax)
  time=dble(count2-count1)/dble(cr)
  print*,'time=',time,' seconds.'


end program
