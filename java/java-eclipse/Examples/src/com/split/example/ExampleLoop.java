package com.split.example;

import java.util.Arrays;

public class ExampleLoop {
	public static void Do(){
		int [] scores = new int[10];
		scores[0] = 10;
		scores[1] = 45;
		scores[2] = 40;
		scores[3] = 23;
		scores[4] = 89;
		scores[5] = 100;
		scores[6] = 74;
		scores[7] = 26;
		scores[8] = 49;
		scores[9] = 98;
		
		//System.out.println(scores);
		//System.out.println(Arrays.toString(scores));
		
		//합을 구해 봅시다.
		//1. while문을 써서 해본다
		int sum1 = 0;
		int index = 0;
		while(index <10)
		{
			sum1 = sum1 + scores[index];
		}
		System.out.println("합은 "+ sum1);
		
		int sum2 = 0;
		//2. 전통적인 for문을 써서 해본다
		for(int i = 0; i<10; i++)
		{
			sum2 = sum2 + scores[i];
			// sum2+=scores[i]로도 쓸 수 있다.
		}
		System.out.println("합은 "+ sum2);
		
		int sum3 = 0;
		//3. 최신 for문을 써서 해본다.
		for(int score : scores)
		{
			sum3 += score;
		}
		System.out.println("합은 "+ sum3);
		
		//for문 의 전개
		// for(A;B;C)
		// {
		// 		D;
		// }
		// 이것은
		//
		// A;
		// duck:
		// if(B)
		// {
		// 		D;
		//		C;
		//		goto duck;
		// }
		//
		// 여기서 goto는 java가 지원하는 것은 아니지만 이해를 돕기 위해 사용했습니다.
		// goto duck; 하면 실행 흐름이 duck: 위치로 이동합니다.
		
			
		
	}
}
