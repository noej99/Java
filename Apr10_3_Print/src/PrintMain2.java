

public class PrintMain2 {
	public static void main(String[] args) {
		System.out.println("정윤호");
		
		// 가볍게 중간결과 확인하는 콘솔창
		// 나중에 통신, 파일처리에서는 문제 생김
		// \ - 특수한 용도
		// \n : new line - 줄바꾸기
		// \r : carriage return - 커서를 맨 앞으로
		System.out.println("ㅋㅋㅋ\nㅎㅎㅎ");
		System.out.println("ㅏㅏㅏ\rㅑㅑㅑ");
		// 제대로 줄 바꾸기
		System.out.println("ㅇㅇ\r\nㅎㅇ");
		System.out.println("--------------");
		// \t : tab
		System.out.println("ㅌㅌ\tㄱㄱ");
		System.out.println("ㅌㅌㅌ\tㄱㄱ");
		System.out.println("--------------");
		
		// \b : backspace(1byte 지우기)
		// 글자 한글자 표현하는데 1byte를 쓰는 언어
		// Java : 1글자에 2bytes
		// => Java에서는 써먹기가...
		System.out.println("ㅂㅂ\b");
		System.out.println("--------------");
		
		// \\ : \표현
		System.out.println("\\(^.^)/");

		// \" : "표현
		System.out.println("\"");
	}
}
