program format1
  implicit none
  real(8) :: r1,r2,r3,a1,a2,a3
  integer :: j1,j2,j3,b1,b2,b3
  character (len=4) :: c
  character (len=10) :: c1,c2
  ! input 은 까다롭다
  go to 99999  !999999 는?
  read "(a, 3(f2.1, i1))" , c,r1,j1,r2,j2,r3,j3
! 1234567890123 을 입력할 것
  print *, c,r1,j1,r2,j2,r3,j3
  print *, "아래는 인풋용"
  print "(a, 3(f3.1, i1))" , c,r1,j1,r2,j2,r3,j3
  print *, "비교"
  print "(a, 3(f2.1, i1))" , c,r1,j1,r2,j2,r3,j3
  print *, ""
  print "(a,2x , 3(f3.1,/ ,i1 ,/))" , c,r1,j1,r2,j2,r3,j3
  print * , "아래는 아웃풋용"

 99999 continue
  a1=123.789
  a2=591.1
  b1=-1000
  b2=-999
  b3=9999

  print "(f8.2)" , a1
  print "(f7.2)" , a1
  print "(f6.2)" , a1
  print "(f5.2)" , a1
  print "(f8.3)" , a1
  print "(f7.1)" , a1
  print "(f4.1)" , a1
  print "(f0.1)" , a1
  print "(es8.1)" , a2
  print "(es7.1)" , a2
  print "(es6.1)" , a2
  print "(es5.1)" , a2
  print "(es8.2)" , a2
  print "(es9.3)" , a2
  print "(es10.4)" , a2

  print "(i4)" , b1
  print "(i5)" , b1
  print "(i3,/)" , b1
  print "(i4)" , b2
  print "(i3,/)" , b2
  print "(i4)" , b3
  print "(i3)" , b3
  print "(i0)" , b3
  print "(i8.7)" ,b3
 ! print "(i4 i4)" ,b3
  print "(i4 i5)" ,b3 ,b1 ,b2


  read "(A8,A4)" ,c1,c2
  ! michigantech
  print * , c1 , c2
  read "(A12,A12)" ,c1,c2
    print * , c1 , c2
end program format1
