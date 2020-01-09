program solve2
  implicit none
  real, dimension(:,:), allocatable :: A, L, U
  real, allocatable :: b(:), c(:), x(:), y(:)
  integer i, j, k, n

  n=5
  allocate(A(5,5),b(5),c(5),x(5),U(5,5),L(5,5),y(5))
  A = transpose(reshape((/ 0.9501, 0.7621, 0.6154, 0.4057, 0.0579,&
       0.2311, 0.4565, 0.7919, 0.9355, 0.3529,&
       0.6068, 0.0185, 0.9218, 0.9169, 0.8132,&
       0.4860, 0.8214, 0.7382, 0.4103, 0.0099,&
       0.8913, 0.4447, 0.1763, 0.8936, 0.1389 /),shape(A)))
  b= (/2.7912, 2.7679, 3.2772, 2.4658, 2.5448/)
  c= (/6.2328, 9.0263, 11.1428, 6.0341, 6.5785/)
  call print_matrix(A,5)
  print *, b
  print *, c

  call LU(A,L,U,n)
  call forward(L,c,y,n) ! Ly=c
  call backward(U,y,x,n) ! Ux =y therefore we have solved Ax = b

  print *, x
end program solve2

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
