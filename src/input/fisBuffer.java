package input;

import java.io.FileInputStream;

import org.junit.Test;


/*
 * In this class, a stringbuilder is used to store the read char and once the string builder is full or the file ends,
 * then print the stringbuilder.
 * This method is to decrease the time of "System.out.println()" in the while loop, 
 * rather than to decrease the time of reading bytes from the file.
 */


public class fisBuffer {
	
	// with a buffer in FileInputStream.read(buffer), 
	// time consuming is 9s
	
	/*
	 * buf = 1024 --> 9s
	 * buf = 512 --> 10s
	 * buf = 256 --> 7.622s
	 */
	@Test
	public void main() {
		try(FileInputStream readIn = new FileInputStream("book1");
				){
			
			byte buf[] = new byte[1024];
			StringBuilder sb = new StringBuilder(256);
			int length;
			
			while((length = readIn.read(buf)) != -1) {
				String str = new String(buf,0,length);
				sb.append(str);
			}
			System.out.println(sb.toString());
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Fail reading...");
		}
	}
}
