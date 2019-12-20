package output;

import java.io.FileOutputStream;

import org.junit.Test;

public class fileOutputStreamTest {
	
	/*
	 * FileOutputStream(filename, booleanValue)
	 * true --> add string
	 * false --> overwrite
	 */
	@Test
	public void FileOutputStreamTest1() {
		try(FileOutputStream output = new FileOutputStream("output1");
				){
			String msg = "Hello world!";
			output.write(msg.getBytes());
			output.flush();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("FAIL");
		}
	}
	
	@Test
	public void FileOutputStreamTest2() {
		try(FileOutputStream output = new FileOutputStream("output1",true)){
			String msg = "first comment!";
			output.write(msg.getBytes());
			output.flush();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Invalid file name.");
		}
	}
	
}
