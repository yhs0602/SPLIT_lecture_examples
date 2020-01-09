#include <iostream>
#include <cstring>
#include <cstdlib>
using namespace std;

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

class Dog;

class Dog
{
public:
	Dog(char * name)
	{
		cout<<"생성자"<<endl;
		myname = strdup(name);
	}
	~Dog()
	{
		cout<<"소멸자"<<endl;
		free(myname);
	}
	void printName()
	{
		cout<<myname<<endl;
	}
	char * myname;
};


int main(int argc, char** argv) {
	cout<<"메인"<<endl;
    if(3<4)
    {
    	cout<<"객체 생성"<<endl;
    	char name[] = "dog";
    	Dog dog(name);
    	dog.printName();
    	name[1] = 'e';
    	if(10/2==5)
    	{
    		return 0;
		}
    	dog.printName();
    	
    	cout<<"할일"<<endl;

	}
	cout<<"메인의 끝"<<endl;
	return 0;
}


