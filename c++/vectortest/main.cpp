#include <iostream>
#include <vector>
using namespace std;

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char** argv) {
	vector<int> list;
	if(list.empty())
	{
		cout<<"비었습니다."<<endl;
	} else {
		cout<<"안 비었습니다."<<endl;
	} 
	list.push_back(4);
	list.push_back(1);
	list.push_back(-3);
	list.push_back(32);
	list.push_back(23);
	list.push_back(1);
	list.push_back(22);
	list.push_back(0);
	list.push_back(23);
	
	vector<int>::iterator i = list.begin();

	for(i=list.begin();i!=list.end();i++)
	{
		cout<<*i<<endl;
	}
	cout<<"========================"<<endl;
	std::vector<int>::reverse_iterator rit = list.rbegin();
	for (; rit!= list.rend(); ++rit){
  		cout<<*rit<<endl;	
	}  
	cout<<"============"<<endl;
	list.erase(list.begin()+2);
	for(i=list.begin();i!=list.end();i++)
	{
		cout<<*i<<endl;
	}
	
	return 0;
}
