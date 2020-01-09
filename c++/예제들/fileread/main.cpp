#include <iostream>
#include <fstream>
#include <string>
using namespace std;

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char** argv) {
	int a;
	ifstream infile("a.txt");
	if(infile)
	{
		while(!infile.eof())
		{
			string a;
			std::getline(infile,a);
			cout<<a<<endl;
		}
	} else {
		cout<<"파일 읽기 에러"<<endl;
	}
	
	ifstream infile2("b.txt");
	if(infile2)
	{
		while(!infile2.eof())
		{
			unsigned char  byte = infile2.get();
			cout<<byte <<endl;
		}
	} else {
		cout<<"파일 읽기 에러"<<endl;
	}
	
	return 0;
}
