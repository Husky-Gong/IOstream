package ByteArrayStream;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;

public class byteArrayStream {
	/*
	 * test ByteArrayOutputStream()
	 */
	private final static String URL_PATH = "https://c-ssl.duitang.com/uploads/item/201809/02/20180902115208_hssyc.thumb.700_0.jpg";
	@Test
	public void hjytrew	`q	@TestB() throws MalformedURLException {
		URL url = new URL(URL_PATH);
		try(InputStream in = url.openStream();
				ByteArrayOutputStream byteOutput = new ByteArrayOutputStream(1024);
				FileOutputStream out = new FileOutputStream("logo.jpg");){
			byte[] buf = new byte[1024];
			int length = 0;
			while((length = in.read(buf)) != -1) {
				byteOutput.write(buf, 0, length);
			}
			byteOutput.flush();
			byte[] data = byteOutput.toByteArray();
			out.write(data);
			out.flush();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("FAIL...");
		}
	}
}
