package com.split.homework;

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int r1, r2, r3;
		int i1, i2, i3;
		Random random = new Random();
		r1 = random.nextInt()%10;
		r2 = random.nextInt()%10;
		r3 = random.nextInt()%10;
		Scanner scanner = new Scanner(System.in);
		for(;;)
		{
			System.out.println("Enter 3 numbers.");
			i1 = scanner.nextInt();
			i2 = scanner.nextInt();
			i3 = scanner.nextInt();
			int correct_count =0;
			if(i1 < 0)
				System.out.println(r1+" "+r2+" "+r3);
			if(i1 == r1)
				correct_count++;
			if(i2 == r2)
				correct_count++;
			if(i3 == r3)
				correct_count++;
			if(correct_count==3)
			{
				System.out.println("You won");
				return;
			} else {
				System.out.println(correct_count+" strike "+(3-correct_count)+"ball. Try again." );
			}
		}
	}

}
