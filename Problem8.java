
import java.util.Scanner;
import java.io.*;
import java.lang.Integer;

public class Problem8 {

    public static void main(String args[]) {
	
		Euler euler = new Euler();
		FileReader reader = null;

		try {
		    File theFile = new File("NumberList.txt");
		    reader = new FileReader(theFile);
		}
		catch(FileNotFoundException e) {
		    System.out.printf("File is not found.");
		    System.exit(0);
		}

		int ch = 0;
		int max = 0;
		int init = 0;
		int buffer[] = new int[5];
		try {
			while(ch != -1) {
			    for(int i = 0; i < 5; i++) {

					ch = reader.read();

					if(ch == -1) {
					    break;
					}

					buffer[i] = ch;
				}
				init = euler.product(buffer);
				if(init > max) {
					max = init;
			    }
			}
		}
		catch(IOException e) {
		    System.out.printf("IO error.");
		    System.exit(0);
		}

		System.out.printf("The max is %d.\n", max);

    }

}