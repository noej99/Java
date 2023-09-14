// CPU - 연산장치 -> 계산, 컴 속도
// RAM - 저장장치 -> 용량
//		변수상태로 임시저장
// SSD/HDD - 저장장치 -> 용량
//		파일형태로 영구저장
// GPU - 그래픽 처리용(CPU+RAM+HDD)
//----------------------------------------------------
// 변수(variable) : 데이터 담는 그릇 
// 		프로그램 쓰다 데이터를 저장할 때
//		임시저장할 때 - 변수
//		영구저장할 때 - 파일로 저장 -> DB

//		문법
//			자료형변수명; <= 변수 선언(만들기)
//			변수명 = 값; <= 변수에 값 대입

//		= : 대입연산자
//			우항에 있는 것을 좌항에 넣어라

//	RAM을 OS(Windows/Linux)가
//		?
//		stack : 아래쪽에서부터 차곡차곡 공간을 배정
//		heap  : 적당한 곳 골라서 배정

//		데이터 특징 파악해서
//		적절한 사이즈의 자료형을 고르는 능력 필요

// 		알고리즘의 시대 : 컴 사양이 낮으니 아끼려고 변수 덜사용

//		유지보수의 시대 : 컴 좋아져서 프로그램 유지보수하기 좋게 만들자
//			=> spring

//		자료형 : 그릇 종류(데이터랑 안맞으면 에러)
//				=> 데이터에 맞는 자료형을 찾는 능력

//		기본형 : stack영역에 데이터를 저장
//			정수(소수점 없는 숫자) : byte(1byte), short(2), int(4), long(8)
//				기본으로 int(-21억 ~ 21억)  그 이상의 데이터 long
//			실수(소수점 있는 숫자) : float(4), double(8)
//			한글자 : char
//			논리형 : boolean
//			자리만 차지 :void

//		참조형 : heap에 데이터, stack에 있는 변수에는 heap 번지를
//			여러글자 : String(되게 큼)

//		기본 자료형 : 아무 처리도 안하고 값만 있을때 인식	
//			10 	 -> int
//			12.1 -> double(대부분의 다른 언어는 float)

//		변수명
//			마음대로
//			규칙
//				숫자로 시작x
//				_ $ 정도만 사용가능
//				문법(예약어)x
//			문화
//				뜻 통하게 => 낙타체(humanAge)/뱀체(human_age)
//				소문자로 시작
//				한글x

// 나이 많은 개발자 변수명 _로 시작
// 변수명 바꿀 때 refactor -> rename

// byte : RAM 1byte(-130 ~ 130)
// long : RAM 8byte
public class VariableMain {
	public static void main(String[] args) {
		// 사람 나이가 30 => 잠깐 저장했다 버리자
		//int age; // 변수 만들기
		//age = 30; // 값 넣기
		int age = 30; // 변수 만들기 + 값 넣기
		System.out.println(age);
		
		// 사람 시력이 1.0
		double eye = 1.0;
		// float eye = (float) 1.0;
		System.out.println(eye);
			
		// 글자 똥
		char ddong = '똥';
		System.out.println(ddong);
		
		// 여러글자 ㅋㅋ
		String laugh = "ㅋㅋ";
		System.out.println(laugh);
		
		// 비가 오나
		boolean isRaining = true; // false
		System.out.println(isRaining);
	
	}
}
