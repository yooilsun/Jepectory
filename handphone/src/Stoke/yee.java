package Stoke;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
public class yee {

	public static void main(String[] args) {
		String 저장할문자열 = "hello world";
		byte 저장할데이터[] = 저장할문자열.getBytes();
		//byte 저장할데이터[] = {'h','e','l','l','o'};//hello
		try {

		OutputStream 저장자 = new FileOutputStream("c:\\temp\\text.txt");
		
		for(int i = 0; i < 저장할데이터.length; i++) {
			저장자.write(저장할데이터[i]);
		}
		저장자.close();
		
		InputStream 불러오는자 = new FileInputStream("c:\\temp\\text.txt");
		int 파일사이즈 = 불러오는자.available();
		
		for(int i = 0; i < 불러오는자.available();i++) {
			System.out.print((char)불러오는자.read());
		}
		불러오는자.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
}