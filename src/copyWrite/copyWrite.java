package copyWrite;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.junit.Test;

public class copyWrite {
	@Test
	// No buffered output stream
	public void copyWriteTest1() {
		try(FileInputStream input = new FileInputStream("book1");
				BufferedInputStream bufIn = new BufferedInputStream(input);
				FileOutputStream output = new FileOutputStream("output2");)
		{
			byte[] buf = new byte[1024];
			int length = 0;
			// In 'while', read bytes data into buffer
			while((length = bufIn.read(buf)) != -1) {
				output.write(buf,0,length);
			}
			output.flush();
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Fail...");
		}
	}
	
	@Test
	// With BufferedOutputStream
	public void copyWriteTest2() {
		try(FileInputStream fileInput = new FileInputStream("book1");
				BufferedInputStream bufInput = new BufferedInputStream(fileInput);
				FileOutputStream fileOutput = new FileOutputStream("output3");
				BufferedOutputStream bufOutput = new BufferedOutputStream(fileOutput);
				){
			byte[] buf = new byte[1024];
			int length = 0;
			while((length = bufInput.read(buf)) != -1) {
				bufOutput.write(buf, 0, length);
			}
			bufOutput.flush();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Fail...");
		}
	}
}
