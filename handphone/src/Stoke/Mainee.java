package Stoke;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
public class Mainee {

	public static void main(String[] args) throws IOException {
		Stoke stokes = new Stoke();
		Scanner sc = new Scanner(System.in);
		int num = 0;
		
		// 1. 파일 읽기...
		FileInputStream rStream = new FileInputStream("C:\\javafile\\phone_stoke.txt");
		// readAllBytes --> 메모장에 있는 모든 내용들을 한번에 읽어들이는 함수.
		byte[] data = rStream.readAllBytes();
		// 아래와같이 사용하면 byte 배열의 값을 String 형으로 자동형변환 해줌.
		String stringData = new String(data);
		
		// String 객체의 split 함수 사용 방법 검색
		/*1.String arr[] = 변수.split(";"); 이럴경우 변수에 담긴 문자열중 ;를 기준삼아 구분한다
		 * 2.split(";" , 2); 이렇게 양수를 넣었을 경우 그 숫자만큼 배열을 생성
		 */
		String[] splitData1 = stringData.split("\n");
		
		// 휴대폰 등록
		// String 배열의 length는 저장되어있는 배열 갯수 의미
		for (int i = 0; i < splitData1.length; ++i) {
			
			String[] tempData = splitData1[i].split("|");
			
			// String에서 enumeration(열거형)으로 형 번환 (enum valueOf 함수 검색)
			//밑에 문장 같은 경우 tempData배열에 제일 첫번째 내용을 enum클래스에서 찾아서 반환한다
			//즉 valueof는 String 타입을 enum에서 찾아서 반환
			Define.phoneModel modelNo = Define.phoneModel.valueOf(tempData[0]);
			
			stokes.RegistPhoneStoke(modelNo);
			// String --> int 변환 (inteager.parseint 함수 검색)
			//문자열을 숫자로 바꿔주는 함수
			stokes.CalcPhoneStoke(modelNo, Define.stokeType._ADD, Integer.parseInt(tempData[1]));
		}
			
		
		for(;;) {
			
			System.out.println("재고를 추가하시겠어요?");
			System.out.println("yes no로 대답해주세요");
			String va = sc.next();
			
			if(Define.answer.valueOf(va) == Define.answer.yes) {
				System.out.println("재고를 추가하실 핸든폰의 이름을 입력해주세요 ");
				System.out.println("Galaxy10s iphone8 G8");
				String name = "Galaxy10s";
				
				switch (Define.phoneModel.valueOf(name)) {
				case Galaxy10s: 
					System.out.println("Galaxy10s을 몇개를 추가하실 건가요?");
					int va2 = sc.nextInt();
					stokes.CalcPhoneStoke(Define.phoneModel.Galaxy10s, Define.stokeType._ADD, va2);
					break;
				
				case iphone8:
					System.out.println("iphone8을 몇개를 추가하실 건가요?");
					va2 = sc.nextInt();
					stokes.CalcPhoneStoke(Define.phoneModel.iphone8, Define.stokeType._ADD, va2);
					break;
					
				case G8:
					System.out.println("G8을 몇개를 추가하실 건가요?");
					va2 = sc.nextInt();
					stokes.CalcPhoneStoke(Define.phoneModel.G8, Define.stokeType._ADD, va2);	
					break;
				}
				

			}
			else if(Define.answer.valueOf(va) == Define.answer.no) {
				System.out.println("재고 추가기능을 끝내겠습니다");
				break;
			}
			System.out.println("재고 추가기능을 끝내겠습니다");
			break;
		}
		
		System.out.println("오늘 하루 핸드폰이 몇개가 팔렸나요?");
		System.out.println("우선 핸드폰의 종류를 알려주세요");
		System.out.println("Galaxy10s iphone8 G8" );
		
		for(;;) {
			
			String name2 = sc.next();
			switch (Define.phoneModel.valueOf(name2)) {
			
			case Galaxy10s: 
				System.out.println("갤럭시의 하루 판매량을 알려주세요");
				int va3 = sc.nextInt();
				stokes.CalcPhoneStoke(Define.phoneModel.Galaxy10s, Define.stokeType._SELLING, va3);
				break;
				
				
			case iphone8:
				System.out.println("아이폰의 하루 파매량을 알려주세요");
				va3 = sc.nextInt();
				stokes.CalcPhoneStoke(Define.phoneModel.iphone8, Define.stokeType._SELLING, va3);
				break;
				
			case G8:
				System.out.println("G8의 하루 판매량을 알려주세요?");
				va3 = sc.nextInt();
				stokes.CalcPhoneStoke(Define.phoneModel.G8, Define.stokeType._SELLING, va3);
				break;
			}
			
			System.out.println("판매시스템을 종료하겠습니다");
			break;
			
		}
			
		
		System.out.println("Galxay10s 현재 재고는  " + stokes.GetPhoneStoke("Galaxy10s") + "개 입니다.");
		System.out.println("iphone8 현재 재고는  " + stokes.GetPhoneStoke("iphone8") + "개 입니다.");
		System.out.println("G8 현재 재고는  " + stokes.GetPhoneStoke("G8") + "개 입니다.");
		
		
	}
	}

