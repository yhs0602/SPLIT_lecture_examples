program solve3
  implicit none
  real, dimension(:,:), allocatable :: A, L, U
  real, allocatable :: b(:), x(:), y(:)
  integer i, j, k, n

  n=4
  allocate(A(4,4),b(4),x(4),U(4,4),L(4,4),y(4))
  A = transpose(reshape((/ 0.1934, 0.1509, 0.8537, 0.8216,&
       0.6822, 0.6979, 0.5936, 0.6449,&
       0.8756, 0.8488, 1.4473, 1.4665,&
       0.2481, 0.2646, 0.6752, 0.8198 /),shape(A)))
  b= (/2.0196, 2.6186, 4.6382, 2.0077/)
  !call print_matrix(A,4)
  !print *, b

  call LU(A,L,U,n)
  call forward(L,b,y,n) ! Ly=b
  call backward(U,y,x,n) ! Ux =y therefore we have solved Ax = b

  print *, x
end program solve3

subroutine LU(A,L,U,n)
  implicit none
  real A(n,n),L(n,n),U(n,n)
  integer  i,j,k,n
  U = A
  do i =1,n
     do j=i+1,n
        L(j,i) = (U(j,i)/U(i,i))
        U(j,:) = U(j,:)-L(j,i)*U(i,:) 
        ! U(j,i) = U(j,i) - U(j,i)/U(i,i)*U(i,i)=0
     end do
     L(i,i) = 1
  enddo
! U =upper triangle
end subroutine LU

subroutine print_matrix(A,n)
  implicit none
  real, dimension(n,n) :: A
  integer :: i, n
  do i = 1,n
     print "(*(f7.4))", A(i,:)
  enddo
  
end subroutine print_matrix

subroutine forward(L,b,x,n)
  real :: L(n,n),b(n),x(n)
  integer :: n,i,j
  do i = 1,n
     x(i)=b(i)
     do j = 1, i-1
        x(i) = x(i)-L(i,j)*x(j)
     enddo
     x(i) =x(i)/L(i,i)
  enddo
end subroutine forward

subroutine backward(U,b,x,n)
real :: U(n,n),b(n),x(n)
integer :: n,i,j
do i= n,1,-1
   x(i)=b(i)
   do j=n,i+1,-1
      x(i)=x(i)-U(i,j)*x(j)
   enddo
   x(i)=x(i)/U(i,i)
enddo

end subroutine backward

! Result :  0.999998450       1.00000143       1.00000048      0.999999464
! Real : 1 1 1 1
