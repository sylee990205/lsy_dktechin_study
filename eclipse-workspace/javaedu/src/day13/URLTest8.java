package day13;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class URLTest8 {

	public static void main(String[] args) {
		try {
			URL req = new URL(
					"http://openapi.seoul.go.kr:8088/796143536a756e69313134667752417a/json/LampScpgmtb/1/100/");

			InputStream is = req.openStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			StringBuffer bf = new StringBuffer();
			String line;
			while (true) {
				line = br.readLine();
				if (line == null)
					break;
				bf.append(line);
			}
			
			JSONObject obj = null;
			
			try {
				obj = new JSONObject(bf.toString());
			} catch (Exception e) {
				System.out.println("파싱 오류");
				e.printStackTrace();
			}

			System.out.println(obj.toString());
			System.out.println(obj.keySet());
			JSONObject lamp = obj.getJSONObject("LampScpgmtb");
			JSONArray row = lamp.getJSONArray("row");
			
			for(Object e : row) {
				System.out.println(((JSONObject)e).getString("CLS_NM"));	
			}	
		} catch (Exception e) {
			System.out.println("오류 : " + e.getMessage());
		}
	}
}
