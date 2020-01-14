#include <iostream>
#include <functional>
using namespace std;
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
class Point
{
	public:
		int x, y;
		Point operator+(const Point &other)
		{
			return Point(x+b.x, y+b.y);
		}
}

Point addPoints(Point &a, Point &b)
{
	return Point(a.x+b.x, a.y+b.y);
	
}

int main(int argc, char** argv) {

	Point p, q;
	p.x = 10;
	p.y = 21;
	q.x = -3;
	q.y = 29;
	Point newpoint = addPoints(p,q);
	Point newway = p+q;
	main(10, NULL);
	
	int a = 3<4? 10:-1;
	
	if(3<4)
	{
		a = 10;
	} else {
		a = -1;
	}
	return 0;
}
