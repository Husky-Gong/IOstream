package input;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import org.junit.Test;

public class fileReader {
	/*
	 * 1 char = 2 bytes
	 * This file is to use FileReader and FileWriter to copy a file.
	 */
	
	@Test
	public void Test1() {
		try(FileReader fReader = new FileReader("book1");
				FileWriter fWriter = new FileWriter("output4");){
			char[] buf = new char[2014];
			int length = 0;
			while((length = fReader.read(buf)) != -1) {
				fWriter.write(buf, 0, length);
			}
			fWriter.flush();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Fail....");
		}
	}
	
	@Test
	/*
	 * Test BufferedReader() and BufferedWriter()
	 */
	public void Test2() {
		try(FileReader fReader = new FileReader("book1");
				BufferedReader bufReader = new BufferedReader(fReader);
				FileWriter fWriter = new FileWriter("output5");
				BufferedWriter bufWriter = new BufferedWriter(fWriter);){
			char[] buf = new char[1024];
			int length = 0;
			
			while((length = fReader.read(buf)) != -1) bufWriter.write(buf, 0, length);
			bufWriter.flush();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("FAIL....");
		}
	}
}
