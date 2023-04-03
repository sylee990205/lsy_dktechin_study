package day13.exercise;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class ImageIOLab {

	public static void main(String[] args) {
		String path = "C:/iotest/";
		
		try(FileReader file = new FileReader(path + "list.txt");
				BufferedReader bReader = new BufferedReader(file);) {
				String data;
				String[] image = new String[2];
				String name;
				FileOutputStream imageFile = null;
				int input;
				
				File isDir = new File(path + "myimage");
				if(!isDir.exists())
					isDir.mkdirs();
				path += "myimage/";
				
				while(true) {
					data = bReader.readLine();
					if(data == null)
						break;
					
					image = data.split(",");
					
					name = image[0];
					URL imageURL = new URL(image[1]);
					
					InputStream is = imageURL.openStream();
					
					imageFile = new FileOutputStream(path + name + ".jpg ");
					while(true) {
						input = is.read();
						if(input == -1)
							break;
						imageFile.write(input);
					}
					
					System.out.println(name + " 이미지 저장 완료");
				}
				
				imageFile.close();
		} catch(MalformedURLException e) {
			System.out.println("URL 문자열 오류");
		}catch(IOException e) {
			System.out.println("입출력 오류");
		}

	}

}
