package day13;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class URLTest2 {
	public static void main(String[] args) {
		String path = "C:/iotest";
		File isDir = new File(path);
		if (!isDir.exists()) {
			isDir.mkdirs();
		}
		try {
			URL req = new URL("http://img.etnews.com/news_ebuzz/afieldfile/2012/01/04/c_bk010101_87984_3.jpg");
			InputStream is = req.openStream(); // 해당 웹서버에 접속, 요청을하고 기다린 후 성공하면 inputStream을 return
			String fileName = "c:/iotest/duke.jpg";
			FileOutputStream fos = new FileOutputStream(fileName);
			int input = 0;
			while (true) {
				input = is.read();
				if (input == -1)
					break;
				fos.write(input);
			}
			fos.close();
			System.out.println("duke.jpg가 성공적으로 저장되었습니다.");
			Runtime.getRuntime().exec("C:\\Program Files\\Google\\Chrome\\Application"
					+ "\\chrome.exe "+fileName); // 응용 프로그램과 응용 프로그램에게 줄 데이터 사이엔 공백이 무조건 있어야 함
		} catch (MalformedURLException e) {
			System.out.println("URL문자열 오류 : " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO 오류 : " + e.getMessage());
		}
	}
}
