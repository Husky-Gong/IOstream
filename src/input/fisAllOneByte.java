package input;

import java.io.FileInputStream;

import org.junit.Test;

public class fisAllOneByte {
	// without a buffer in FileInputStream.read()
	// time consuming is 200s
	@Test
	public void main() {
		try (FileInputStream readIn = new FileInputStream("book1");
				){
			int content;
			while((content = readIn.read()) != -1) {
				// Without print function --> 0.663s
				// continue;
				
				// with print function --> 2.927s
				System.out.println((char)content);
			}
		}
		catch (Exception e){
			e.printStackTrace();
			System.out.println("Reading Failed...");
		}
	}
}
