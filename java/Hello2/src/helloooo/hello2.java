package helloooo;

import java.io.IOException;
import java.util.Scanner;

public class hello2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int input;
		int[] inputs = new int[10];
		int i=0;
		while((input = scanner.nextInt()) != -1)
		{
			inputs[i] =input;
			i = i +1;
		}

		int sum = 0;
		for(int number : inputs)
		{
			sum = sum + number;
		}
		System.out.println(sum);
	}	
}
