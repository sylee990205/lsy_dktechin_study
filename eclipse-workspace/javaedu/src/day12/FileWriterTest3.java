package day12;

import java.io.IOException;
import java.io.PrintWriter;

public class FileWriterTest3 {
	public static void main(String args[]) {
		try (PrintWriter writer = new PrintWriter("c:/iotest/output3.txt");) {
			char arr[] = { '객', '체', '지', '향', '언', '어', ' ',  'J', 'a', 'v', 'a' };
			for (int cnt = 0; cnt < arr.length; cnt++)
				writer.print(arr[cnt]);
			writer.println();
			writer.println(arr);
			writer.println("OCJP 시험 대비!!");
			writer.println(100);
			writer.println(3.14);
			writer.println(true);
			writer.printf("%,d원\n", 1000000);
			writer.printf("%.2f\n", 123.5678);
			System.out.println("파일에 출력 완료!!");
		} catch (IOException ioe) {
			System.out.println("파일로 출력할 수 없습니다.");
		}
	}
}
