package com.split.example;

public class ExampleContinueBreak {
	public void Do()
	{
		int [] data = {10,2,30,40,32,30,123,35,43,432};
		int sum = 0;
		int evenCount = 0;
		
		//짝수 개수를 센다. 그와 동시에 요소들의 합을 구한다.
		for(int da:data)
		{
			sum = sum + da;
			if(da%2!=0)
			{
				// 홀수는 짝수 개수에 포함시키지 않는다.
				continue;
			}
			if(da==35)			//35를 만나면 루프 강제 종료 해본다
				break;
			evenCount = evenCount+1;
			
		}
	}
}
