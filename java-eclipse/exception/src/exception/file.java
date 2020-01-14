package exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class file {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			File file = new File("my.txt");
			System.out.println(file.getCanonicalPath());
			FileInputStream fis = new FileInputStream("my.txt");
			
			fis.read();
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
