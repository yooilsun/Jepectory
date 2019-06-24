package Stoke;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class scream {

	public static void main(String[] args) {
		
		String English = "How can do it";
		
		byte store[] = English.getBytes();//바이트로 변환
		
		//저장기능
		try {
			OutputStream stream = new FileOutputStream("c:\\javaFile\\tet.txt");
		
			
			for(int i = 0; i < store.length; i++) {
				stream.write(store[i]); 
			}
			stream.close();
			
			//가져오기
			InputStream skoe = new FileInputStream("c:\\javaFile\\tet.txt");
			//available은 폴더사이즈를 나타내는 클래스
			
			byte ski[] = skoe.readAllBytes();//readAllBytes는 저장되있는 텍스트파일 내용을 전부 읽어드리기 
			
			for(int i = 0; i < ski.length; i++) {
				System.out.print((char)ski[i]);
			}
			skoe.close();
		}catch(IOException e) {//경로관련한 오류가 발생시 다 넘겨버림
			e.printStackTrace();
		}

	}

	

}
