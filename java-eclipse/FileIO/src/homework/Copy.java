package homework;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Copy {

	public static void main(String[] args) {
		if(args.length<2)
		{
			System.out.println("xcc");
			return;
		}
		String from = args[0];
		String to  = args[1];
		File file = new File(from);
		try {
			Files.copy(file.toPath(), new File(to).toPath(), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
