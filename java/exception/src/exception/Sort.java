package exception;
import java.util.*;

public class Sort {
	enum Orientation
	{
		NORTH,
		SOUTH, 
		EAST,
		WEST
	};
	Orientation ori;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(6);
		arr.add(8);
		arr.add(2);
		arr.add(3);
		arr.add(1);
		arr.add(4);
		arr.add(5);
		arr.add(7);
		System.out.println(arr.toString());
		//
		Collections.sort(arr);
		arr.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return -o1.compareTo(o2);
				
			}
		});
		System.out.println(arr.toString());
		
	}
	MyComparator comparator = new MyComparator();
	
	class MyComparator implements Comparator<Integer>
	{
		@Override
		public int compare(Integer o1, Integer o2) {
			return -o1.compareTo(o2);
//			if(o1,intValue()>o2.intValue)
	//			return -1;
		//	else if(o1<o2)
		//		return 1;
		//	else
		//		return 0;
		}
		
	}
}
