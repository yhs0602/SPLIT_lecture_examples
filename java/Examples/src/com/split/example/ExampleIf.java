package com.split.example;

import java.util.Scanner;

public class ExampleIf {

	public static void Do()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number:");
		int number = sc.nextInt();
		
		if(number > 10)
		{
			System.out.println("10보다 큰수를 입력했습니다.");			
		} else {
			System.out.println("10보다 작은 수를 입력했습니다.");
		}
		
		System.out.print("한번 더!:");
		number = sc.nextInt();
		if(number != 20)
		{
			System.out.println("20이 아닌 수를 입력했습니다.");
		} else {
			System.out.println("20을 입력했습니다.");
		}
		
	}
}
