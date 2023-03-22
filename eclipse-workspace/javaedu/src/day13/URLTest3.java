package day13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;

public class URLTest3 {
	public static void main(String[] args) {
		InputStream is = null;
		BufferedReader reader = null;
		BufferedWriter fw = null;
		try {
			URL req = new URL("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1171062000");
			is = req.openStream();
			reader = new BufferedReader(new InputStreamReader(is));
			fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("c:/iotest/weather.xml")));
			String lineStr = "";
			while (true) {
				lineStr = reader.readLine();
				if (lineStr == null)
					break;
				fw.write(lineStr + "\n");
			}
			System.out.println("weather.xml이 성공적으로 생성되었습니다.");
		} catch (MalformedURLException e) {
			System.out.println("URL문자열 오류 : " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO 오류 : " + e.getMessage());
		} finally {
			try {
				if (fw != null)
					fw.close();
				if (reader != null)
					reader.close();
				if (is != null)
					is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
