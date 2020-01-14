package exception;
import java.lang.reflect.*;
import java.util.*;

public class Invoke {

	public static int Add(int a , int b)
	{
		return a+b;
	}
	public static int Sub(int a , int b)
	{
		return a-b;
	}
	public static int Mul(int a , int b)
	{
		return a*b;
	}
	public static String Div(int a , int b)
	{
		return ""+(a/b);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Character, Method> map = new HashMap<>();
		try {
			map.put('+', Invoke.class.getMethod("Add", int.class, int.class));
			map.put('-', Invoke.class.getMethod("Sub", int.class, int.class));
			map.put('*', Invoke.class.getMethod("Mul", int.class, int.class));
			map.put('/', Invoke.class.getMethod("Div", int.class, int.class));
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scanner sc = new Scanner(System.in);
		String command = sc.next();
		//String [] toks = command.split(" ");
		char operator = command.charAt(0);
		command = sc.next();
		int operand1 = Integer.parseInt( command);
		command = sc.next();
		int operand2 = Integer.parseInt( command);
		Method  m = map.get(operator);
		try {
			int result = (int)m.invoke(null, operand1, operand2);
			System.out.println(result);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
