package Stoke;

import java.util.Hashtable;
import java.util.Scanner;

public class Stoke {
	
	Scanner sc = new Scanner(System.in);
	private Hashtable<Define.phoneModel, Integer> phone_stoke = new Hashtable<Define.phoneModel, Integer>();
	//해쉬테이블 생성 
	public void RegistPhoneStoke(Define.phoneModel phone) {//폰 등록
		System.out.println(phone + "의 재고를 몇개로 하실건가요?");
		int stoke = sc.nextInt();
		
		if (stoke < 0) {
			System.out.println("재고를 마이너스 입력해주셨습니다.");
			return ;
		}
		
		phone_stoke.put(phone, stoke);//폰 재고를 입력한 값을 해시테이블에 넣기
	}
	
	
	
	public void CalcPhoneStoke(Define.phoneModel phone, Define.stokeType type, int number) {
		if (phone_stoke.containsKey(phone) == false) {//폰 재고
			System.out.println("해당 모델은 등록되어있지않습니다.");
			return ;
		}
		
		if (type == Define.stokeType._ADD) {//폰을 구입했을 경우
			phone_stoke.replace(phone, phone_stoke.get(phone) + number);
			
		}
		
		else if (type == Define.stokeType._SELLING) {//폰을 팔았을 경우
			if (phone_stoke.get(phone) <= 0) {
				System.out.println(phone + " 모델은 재고가없어서 판매할 수 없습니다.");
				return;
			}
			
			phone_stoke.replace(phone, phone_stoke.get(phone) - number);
		}//폰을 팔아서 재고에서 그 숫자만큼 뺌
	}
	
	public int GetPhoneStoke(String phone) {
		if (phone_stoke.containsKey(phone) == false) {
			System.out.println("해당 모델은 등록되어있지않습니다.");
			return -1;
		}
		
		return phone_stoke.get(phone);
	}
}
