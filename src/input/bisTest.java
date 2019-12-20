package input;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

import org.junit.Test;

public class bisTest {
	/*
	 * buf = 4096 --> 8.0s
	 * buf = 1024 --> 7.5s
	 * buf = 512 -->8.5s
	 * buf = 256 -->8.5s
	 */
	@Test
	public void main() {
		try(FileInputStream fRead = new FileInputStream("book1");
				BufferedInputStream bufRead = new BufferedInputStream(fRead);){
			StringBuilder sb = new StringBuilder(1024);
			byte[] buf = new byte[4096];
			int length = 0;
			while((length = bufRead.read(buf)) != -1) {
				String str = new String(buf,0,length);
				sb.append(str);
			}
			
			System.out.println(sb.toString());
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Fail");
		}
	}
}
