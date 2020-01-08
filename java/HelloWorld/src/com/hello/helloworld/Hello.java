// 그냥 틀
package com.hello.helloworld;

//몰라도됨
import java.io.IOException;

// 틀
public class Hello {

	//시작 지점
	//Modifier1 Modifier2 ... MethodName ( argumenttype1 argument1, ...)
	
	//void는 비어있다는 건데 뭐가 비어있을까요
	//String은 실인데 뭔 실?
	//[] arg?
	// ??
	public static void main(String[] args) {
		//뭐게요??
		System.out.println("Hi world!");
		
		//int가 뭘까요?? integer 정수
		int iterator = 0 ;
		
		iterator = 0;
		System.out.println(iterator);
		iterator = 5;
		System.out.println(iterator);		
		iterator = iterator + 4;
		
		
		
		
		
		
		
		
		//
		for (iterator = 0 ;							//iterator에 0 대입
			iterator < 100 ;						//iterator가 100보다 작다
			iterator = iterator + 1)				//??
		{
			System.out.println(iterator);
		}
		if(iterator == 100)
			System.out.println("Iterator is 100");
		else
			System.out.println("Iterator is not 100");
			System.out.println("Iterator is :" + iterator);		//문제가 있다.
		// 사용자 입룍을 받아 보자.
		System.out.println("Enter a number :");
		//무시
		try {
			int ch = System.in.read();
			System.out.println("You wrote : "+ch);
			
		} catch (Exception e) {
			//뭔가 문제가 있다.
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
