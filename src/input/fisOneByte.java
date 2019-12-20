package input;

import java.io.FileInputStream;

public class fisOneByte {
	public static void main(String[] args) {
		FileInputStream readIn = null;
		try {
			readIn = new FileInputStream("sd");
			int data = readIn.read();
			char letter = (char)data;
			System.out.println(letter);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Failed!");
		}finally {
			// FibleInputStream should be shut down after use.
			try {
				if(readIn != null) {
					readIn.close();
				}
			}catch(Exception e) {
				System.err.println("Close failure!");
			}finally {
				readIn = null;
			}
		}
	}
}
