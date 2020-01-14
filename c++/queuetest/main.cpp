#include <iostream>
#include <queue>
using namespace std;
/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char** argv) {
	queue<int> intqueue;
	intqueue.push(20);
	intqueue.push(110);
	intqueue.push(10);
	intqueue.push(4550);
	intqueue.push(33);
	intqueue.push(22);
	intqueue.push(11);
	intqueue.push(25);
	intqueue.push(18);
	intqueue.push(29);
	intqueue.push(130);
	intqueue.push(17);
	
	while(!intqueue.empty())
	{
		cout<<intqueue.front()<<endl;
		intqueue.pop();	
	}
	cout<<intqueue.size()<<endl;
	return 0;
}
