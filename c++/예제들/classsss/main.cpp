#include <iostream>
#include <cstring>
//#include <string.h>

using namespace std;

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

//동물을 나타내는 클래스를 만들겠습니다. 
//동물 클래스에서 생성된 객체(instance)는 각각 자신의 고유한 생명력과 이름을 가지고 있습니다.
class Animal
{
	protected:
	char  name[16];
	int health;
	public:
		Animal(const char* n, int origHealth = 100)
		{
			cout<<"생성자 실행_부모"<<endl;
			strcpy(name, n);
			health = origHealth;
		}
		int getHealth()
		{
			return health;
		}
		void heal(int amount)
		{
			health +=amount*2;
		}
		void damage(int amount)
		{
			health -= amount;
			if(health <= 0)
				cout<<name<<"가 죽었습니다."<<endl;
		}
		virtual void Say(char * s)
		{
			cout<<s<<endl;
		}
};

class Dog : public Animal
{
	int p;
	public:
		Dog(const char* n, int origHealth = 100):Animal(n,origHealth)
		{
			cout<<"생성자 실행"<<endl;
			strcpy(name, n);
			health = origHealth;
		}
		
		Dog(const Dog & original)
		{
			this->name = original.name;
			this->health = original.health;  
			this->p = original.p;
		}
		void Say(char * s)
		{
			cout<<"멍멍"<<s<<endl;
		}
		void Bite()
		{
			cout<<"물었다"<<endl;
		}

};
class Cat : public Animal
{
	public:
		Cat(const char* n, int origHealth = 100):Animal(n, origHealth)
		{
			cout<<"생성자 실행"<<endl;
			strcpy(name, n);
			health = origHealth;
		}
		
		void Say(char * s)
		{
			cout<<"야옹"<<s<<endl;
		}
};


int main(int argc, char** argv) {
	Animal *dog = new Dog("강아지");
	Animal dog2 = new Dog(dog);
	dog->Say("dfs");
	cout<<dog->getHealth()<<endl;
	delete dog;
	return 0;
}
