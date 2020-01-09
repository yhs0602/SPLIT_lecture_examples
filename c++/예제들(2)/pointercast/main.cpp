#include <iostream>
using namespace std;

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char** argv) {
	int a =11000;
	cout<<a<<endl;
	char * pointer_to_a = (char *)&a;
	*pointer_to_a = 10;
	cout<<a<<endl;
	return 0;
}
