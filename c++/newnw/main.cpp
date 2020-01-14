#include <iostream>
using namespace std;

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char** argv) {
	int count;
	cin>>count;
	cout<<count<<endl;
	int * array = new int[count];
	for(int i=0;i<count;i++)
	{
		cin>>array[i];
	}
	int sum =0;
	for(int i=0;i<count;i++)
	{
		sum += array[i];	
	}
	cout<<sum<<endl;
	return 0;
}
