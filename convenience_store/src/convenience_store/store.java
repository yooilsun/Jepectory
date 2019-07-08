package convenience_store;
import java.util.Scanner;

import convenience_store.Define.kindsType;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.Hashtable;


public class store {
	Scanner sc = new Scanner(System.in);int stoke;//간식재고
	
	int num = 10;//자동진열수 채워주는 변수
	
	
	Hashtable<Define.kindsType , Integer> convenince = new Hashtable<Define.kindsType, Integer>();//해쉬테이블 생성
	
	public store() {
		
	}
	
	public void convenince_rem(Define.kindsType Define) {//편의점 간식재고 등록(간식은 초콜릿 과자 아이스크림)
		
		System.out.println(Define + "의 진열갯수를 몇개로 설정하시겠습니까?");
		int va = sc.nextInt();//초기진열설정값
		if(va < 1) {//만약 진열갯수를 0개 이하로 설정했을 경우
			System.out.println("진열갯수를 다시 설정해주세요");
			
		}
		else{
			convenince.put(Define, va);//간식거리와 재고갯수를 해시테이블에 입력
		}

		
	}
	
	
	public void calc() {//편의점에서에서의 계산과정
		
		
			System.out.println("어떤 물건을 구매하시겠어요?");
			System.out.println("chocolate snake icecream중에 선택을 해주세요");
			
			String click = sc.next();
			
			switch(Define.kindsType.valueOf(click)) {
			
			case chocolate:
				if(convenince.containsKey(Define.kindsType.chocolate)) {//만약 해시테이블에 chocolate가 있다면
					System.out.println("몇개를 구매하시겠어요?");
					int va = sc.nextInt();//구매수량
					if(convenince.get(Define.kindsType.chocolate) <= 0) {//구매할 물건의 매장내에서 진열수가 없다면
						System.out.println("현재 매장내에서 구매가능한 수량이 없습니다");
						System.out.println("---------재고 충전--------");
						convenince.put(Define.kindsType.chocolate, num);//초콜렛 10개 진열
						System.out.println("초콜렛 10개를 다시 진열해놓았습니다");
						break;
		
					}
					else {
						System.out.println("당신은 " + va + "개만큼의 수량을 구매했습니다");
						int kt = convenince.get(Define.kindsType.chocolate);//초콜릿의 현재 재고를 가져옴
						int yu = kt - va;
						System.out.println(Define.kindsType.chocolate + "을" + va + "만큼 손님이 구매하셨기에 " + yu + "만큼 진열수가 남았다");
						
						convenince.put(Define.kindsType.chocolate , yu);//현재 재고를 해시테이블에 입력
						return;
					}
						
					
				}
				
			case snake:
				
				if(convenince.containsKey(Define.kindsType.snake)) {//만약 해시테이블에 snake가 있다면
					System.out.println("몇개를 구매하시겠어요?");
					int va = sc.nextInt();//구매수량
					if(convenince.get(Define.kindsType.snake) <= 0) {//구매할 물건의 매장내에서 진열수가 없다면
						System.out.println("현재 매장내에서 구매가능한 수량이 없습니다");
						System.out.println("---------재고 충전--------");
						convenince.put(Define.kindsType.snake, num);//과자 10개 진열
						System.out.println("과자 10개를 다시 진열해놓았습니다");
						break;
					}
					else {
						System.out.println("당신은 " + va + "개만큼의 수량을 구매했습니다");
						int kt = convenince.get(Define.kindsType.snake);//현재 진열수를 가져옴
						int yu = kt - va;
						System.out.println(Define.kindsType.snake + "을" + va + "만큼 손님이 구매하셨기에 " + yu + "만큼 진열수가 남았다");
						
						convenince.put(Define.kindsType.snake, yu);//현재 재고를 해시테이블에 입력
						return;
					}
						
					
				}
			case icecream:
				if(convenince.containsKey(Define.kindsType.icecream)) {//만약 해시테이블에 icecream이 있다면
					System.out.println("몇개를 구매하시겠어요?");
					int va = sc.nextInt();//구매수량
					if(convenince.get(Define.kindsType.icecream) <= 0) {//구매할 물건의 진열수가 없다면
						System.out.println("현재 매장내에서 구매가능한 수량이 없습니다");
						System.out.println("---------재고 충전--------");
						convenince.put(Define.kindsType.icecream, num);//아이스크림 10개 진열
						System.out.println("아이스크림 10개를 다시 진열해놓았습니다");
						break;
					}
					else {
						System.out.println("당신은 " + va + "개만큼의 수량을 구매했습니다");
						int kt = convenince.get(Define.kindsType.icecream);//현재 진열수를 가져옴
						int yu = kt - va;
						System.out.println(Define.kindsType.icecream + "을" + va + "만큼 손님이 구매하셨기에 " + yu + "만큼 진열수가 남았다");
						
						convenince.put(Define.kindsType.icecream, yu);//현재 icecream진열수를 해시테이블에 입력
						return;
					}
						
					
				}
				
				
			}
			
			
			
			
	}
	
	
	public void Save(int i){//텍스트파일에 저장하는 기능(변수 i는 몇회차인지 나타냄)
		
		try {
		
		BufferedWriter Save = new BufferedWriter(new FileWriter("c:\\javafile\\convenience_stoke" , true));
		PrintWriter pw = new PrintWriter(Save , true);//텍스트 이어쓰기
		
	    

				
				String sn = convenince.get(Define.kindsType.chocolate).toString();
				//enum클래스 chocolate을 문자열로 변환후 키값을 통해 해시테이블에서 값을 가져옴 
				
				String vn = convenince.get(Define.kindsType.snake).toString();
				//enum클래스 snake을 문자열로 변환후 키값을 통해 해시테이블에서 값을 가져옴 
				String qn = convenince.get(Define.kindsType.icecream).toString();
				//enum클래스 icecream을 문자열로 변환후 키값을 통해 해시테이블에서 값을 가져옴 
				
				
				
				
				pw.write(i + "회차" + "\n");
				pw.write("chocolate의 진열수:" + sn + "\t");//초콜릿의 진열수를 텍스트에 쓰기
				pw.write("snake의 진열수:" + vn + "\t" );//과자의 진열수를 텍스트에 쓰기
				pw.write("icecream의 진열수:" + qn + "\n");//아이스크림의 진열수를 텍스트에 쓰기
				pw.flush();
				
				
			pw.close();//printwriter 종료
		}catch(Exception e) {//예외처리
		e.printStackTrace();
	}
	
	
	
	


}
}
