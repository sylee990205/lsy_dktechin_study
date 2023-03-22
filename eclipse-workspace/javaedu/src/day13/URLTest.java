package day13;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class URLTest {
	public static void main(String[] args) throws Exception {
		// URL url = new URL("http://unico2013.dothome.co.kr/test_utf8.html");
		URL url = new URL("http://unico2013.dothome.co.kr/test_euckr.html");
		InputStream is = url.openStream();
		// BufferedReader br = new BufferedReader(new InputStreamReader(is));
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "EUC-KR"));
		String line = null;
		while (true) {
			line = br.readLine();
			if (line == null)
				break;
			System.out.println(line);
		}
	}
}
