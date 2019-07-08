package convenience_store;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class main {

	public static void main(String[] args) throws IOException {
		
		/*이 프로그램은 간식거리의 재고는 무한히 있고 손님들이 살때 남은 재고를 파악해서 진열된 수가 없을때 알아서 채워넣는
		 * 프로그램입니다.진열을 알아서 채워놓치만 텍스트에 따로 남는 진열수가 저장되기 때문에 몇개를 사갔는지 파악도 용이하므로
		 * 일일 판매량을 파악할 수 있고 그로 인해 판매전략을 바꿀 수 있다는 생각에서 비롯된 프로그램입니다.
		 */
		

		Define em = new Define();//enum클래스 객체 생성
		store cev = new store();//편의점 판매과정 객체 생성
		Scanner sc = new Scanner(System.in);
		int num = 1;//몇회차 구매인지 알려주는 변수
		System.out.println("이 프로그램은 편의점 알바역할을 하는 프로그램입니다");
		System.out.println("손님이 구매를 하고 구매하고 남은 매장내의 진열수를 텍스트에 저장하고 그 판매하고 남은 진열수를 볼 수 있는 기능을 가지고 있습니다");
		System.out.println("당신은 만약 프로그램을 사용햇었다면 판매내역을 보실건가요?");
		
		String ans = sc.next();
		
	
		
		switch(Define.answer.valueOf(ans.toLowerCase().toUpperCase())) {//대소문자 구분없게
		case YES://판매하고 남은 진열수를 볼 경우
			FileInputStream call = new FileInputStream("c:\\javafile\\convenience_stoke");
			
			byte []temp = new byte[call.available()];//텍스트 파일의 크기를 temp배열에 넣는다
			call.read(temp);//텍스트를 읽는다
			
		

			
			for(byte temp2 : temp) {//for each문
				System.out.printf("%c",(char)temp2);//byte를 문자로 바꿔서 출력
			}
			
			System.out.println("우선 초콜렛 과자 아이스크림 순서대로 처음 재고를 입력해주세요");
			cev.convenince_rem(Define.kindsType.chocolate);//초콜렛의 초기진열수설정
			cev.convenince_rem(Define.kindsType.snake);//과자의 초기진열수설정
			cev.convenince_rem(Define.kindsType.icecream);//아이스크림의 초기진열수설정
			break;
			
			
			
		case NO://판매내역을 안 볼경우
			System.out.println("우선 초콜렛 과자 아이스크림 순서대로 처음 재고를 입력해주세요");
			cev.convenince_rem(Define.kindsType.chocolate);//초콜렛의 초기진열수설정
			cev.convenince_rem(Define.kindsType.snake);//과자의 초기진열수설정
			cev.convenince_rem(Define.kindsType.icecream);//아이스크림의 초기진열수설정
			break;
			
		default:
			System.out.println("yes no로만 입력해주세요");
		}
		
		
		for(;;) {
			cev.calc();//판매
			cev.Save(num);//저장
			++num;//메서드가 한번씩 실행될때마다 회차1씩 증가
			System.out.println("게속 구매하시겠습니까?");
			
			System.out.println("yes no중 선택하세요");
			String EN = sc.next();
			if(EN.equals("yes") || EN.equals("YES")) {
				continue;
			}
			else if(EN.equals("NO") || EN.equals("no")) {
				System.out.println("프로그램이 종료되었습니다");
				break;
			}
		
		}
		
		
	}

}
