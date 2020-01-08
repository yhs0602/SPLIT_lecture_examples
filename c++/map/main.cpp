#include <iostream>
#include <map>
#include <string>
using namespace std;
/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char** argv) {
	map<string, int> name2number;
	name2number.insert(make_pair("one",1));
	name2number.insert(make_pair("two",2));
	name2number.insert(make_pair("three",3));
	name2number.insert(make_pair("four",4));
	name2number.insert(make_pair("five",5));
	name2number.insert(make_pair("six",6));
	name2number.insert(make_pair("seven",7));
	name2number.insert(make_pair("eight",8));
	name2number.insert(make_pair("nine",9));
	
	string input;
	cout<<"영어 숫자를 입력하세요"<<endl;
	cin>>input;
	cout<<name2number[input]<<endl;
	
	return 0;
}
