#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main()
{srand(time(NULL));
    printf("hello world!\n");
    system("ps");
    int i=0;
    int j=0;
    for(;;i++)
      {
	for(;;j++)
	  {
	    printf("%d * %d = %d\n",i,j,i*j);
	    if(rand()%4==0)
	      {
		int c=3;
		int d=0;
		c/=d;
	      }
	  }
      }
    return 0;
}

