// 다 만들었으면 -> 최종 배포(export - Runnable JAR File)
//					압축파일의 일종 -> 알집이 열려버림
// 실행 명령어(java -jar 파일명)을 써서
// .bat로 만들기
public class NameCardMain {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("*************************");
		System.out.println("* 정윤호\t\t*");
		System.out.println("*************************");
		System.out.println("* 사는곳 : 서울\t\t*");
		System.out.println("* 연락처 : 010-4815-1331*");
		System.out.println("*************************");
		
		Thread.sleep(5000); // 단위 1/1000 초
	}

}
