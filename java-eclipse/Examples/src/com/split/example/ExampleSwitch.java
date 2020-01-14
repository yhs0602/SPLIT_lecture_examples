package com.split.example;

import java.util.Scanner;

public class ExampleSwitch {
	public void Do()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("뭐 할까요? 1번을 누르면 고객센터로 연결됩니다.");
		System.out.println("뭐 할까요? 2번을 누르면 기부가 됩니다.");
		System.out.println("뭐 할까요? 3번을 누르면 프로그램이 끝납니다.");
		
		int choice;
		
		choice = sc.nextInt();
		
		switch(choice)
		{
		case 1:
			System.out.println("고객센터입니다.");
			break;
		case 2:
			System.out.println("기부했습니다.");
			break;
		case 3:
			System.out.println("프로그램 끝납니다.");
			break;
		default: 	//1,2,3도 아닐 때
			System.out.println("그런 거 없습니다.");
			break;

		}
		
		System.out.println("뭐 할까요? 1번 또는 3번을 누르면 고객센터로 연결됩니다.");
		System.out.println("뭐 할까요? 2번 또는 100번을 누르면 기부가 됩니다.");
		System.out.println("뭐 할까요? 4번을 누르면 프로그램이 끝납니다.");
		
		choice = sc.nextInt();
		
		switch(choice)
		{
		case 1:
		case 3:
			System.out.println("고객센터입니다.");
			break;
		case 2:
		case 100:
			System.out.println("기부했습니다.");
			break;
		case 4:
			System.out.println("프로그램 끝납니다.");
			break;
		default: 	//1,2,3,4,100도 아닐 때
			System.out.println("그런 거 없습니다.");
			break;

		}	
	}
}
