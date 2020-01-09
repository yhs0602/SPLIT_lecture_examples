program subroutine_test
  implicit none
  real,allocatable ::A(:,:),L(:,:),U(:,:),b(:),x(:), testA(:,:), y(:)
  integer :: i,j, n
  n = 5
 ! dx = 1/(n+1)
  allocate (A(n,n),L(n,n),U(n,n),b(n),x(n),y(n))
  do i=1,n
     do j = 1,n
        A(i,j) =0;L(i,i)=0;U(i,i)=0;
     enddo
     b(i)=2; x(i) = 0; y(i)=0;
  enddo
  do i=1,n
     A(i,i)=2.0
  enddo
  
  do i = 2,n
     A(i,i-1)=1.0
     A(i-1,i)=1.0
  enddo
  call LU(A,L,U,n)
  call forward(L,b,x,n) ! Ly=b
  call backward(U,b,x,n) ! Ux =y therefore we have solved Ax = b
  ! We should check! whetehr AX=b

  call mat_vec_mul(A,x,y,n) ! y=A x
  print "(*(f7.3))",y
  print *,b
  print *,x
  ! solution is b
  call showmat(A,n)
  call mat_mul(L,U,testA,n)
  !call showmat(testA,n)
end program subroutine_test

subroutine solve_A(A,b,x,n)
  real:: A(n,n),b(n),x(n),tmp
  integer:: i,j,k,n
  do i =1,n
     do j=1,n
        tmp = A(i,j)/A(i,i)
        A(j,:)=A(j,:) - tmp*A(i,:)
        b(j)=b(j)-tmp*b(i)
     enddo
  enddo
  call backward(A,b,x,n)
end subroutine solve_A

subroutine mat_vec_mul(A,x,y,n)
  real :: A(n,n),x(n),y(n)
  integer :: i,j,n
  do i=1,n
     y(i)=0
     do j=1,n
        A(i,j)=y(i) + A(i,j) * x(j)
     enddo
  enddo
end subroutine mat_vec_mul

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

subroutine showmat(A,n)
  implicit none
  integer :: i, n
  real ::A(n,n)
  do i = 1,n
     print "( *(f7.3) )", A(i,:)
  enddo
!  n = n +1
  print *, ""
end subroutine showmat

subroutine mat_mul(A,B,C,n)
  real :: A(n,n), B(n,n), C(n,n)
  integer :: i,j,k
  do i1=1,n
     do j=1,n
        C(i,j)=0
        do k=1,n
           C(i,j)=C(i,j) + A(i,k) * B(k,j)
        enddo
     enddo
  enddo
end subroutine mat_mul

subroutine LU(A,L,U,n)
  implicit none
  real ::A(n,n),L(n,n),U(n,n)
  integer :: i,j,k,n
  U = A
  do i =1,n
     do j=i+1,n
        L(j,i) = (U(j,i)/U(i,i))
        U(j,:) = U(j,:)-L(j,i)*U(i,:) 
        ! U(j,i) = U(j,i) - U(j,i)/U(i,i)*U(i,i)=0
     enddo
     L(i,i) = 1
  enddo
! U =upper triangle

end subroutine LU
