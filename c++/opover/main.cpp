#include <iostream>
using namespace std;
//#include <numeric>
int gcd(int a, int b);
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
class Quotient
{
	public:
		int over;
		int under;
		Quotient operator+(const Quotient & other)
		{
			int gcd1 = gcd(under, other.under);
			int t1 = gcd1/under;
			int t2 = gcd1/other.under;
			
			return  Quotient();
		}	
};
int gcd(int a, int b) { 
   if (b == 0) 
      return a; 
   return gcd(b, a % b);  
} 

int g;

int main(int argc, char** argv) {
	Quotient a;
	Quotient b;
	Quotient c = a+b;
	for(int i=0;i<10;i++)
	{
		int c=10;
		if(c==10)
		{
			int d =110;
		}
	}
	return 0;
}
