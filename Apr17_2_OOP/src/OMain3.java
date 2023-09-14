
public class OMain3 {
	public static void main(String[] args) {
		// 컴퓨터
		// CPU : i7-1234
		// RAM : 16
		// HDD : 500
		// 출력
		Computer x = new Computer();
		x.cpu = "i7-1234";
		x.ram = 16;
		x.hdd = 500;
		x.spec();
		System.out.println("-----------");

		// 컴
		// cpu : i5-5423
		// ram : 8
		// hdd : 250
		// 출력
		Computer x2 = new Computer();
		x2.cpu = "i5-5423";
		x2.ram = 8;
		x2.hdd = 250;
		x2.spec();
		System.out.println("-----------");

		// x랑 똑같은 사양의 컴퓨터가 하나 더 - x
		// x를 x3로도 부를수있게
		Computer x3 = x;
		// 정보출력
		x3.spec();
		System.out.println("-----------");

		// x3의 hdd를 1000으로
		x3.hdd = 1000;
		x3.spec();
		System.out.println("-----------");

		// ?
		x.spec();
		
		x = null; // 참조형변수가 아무것도 안가리키는 상태
		x3 = null;
		
		// RAM : 재부팅하면 다 지워짐
		// 다 쓴 공간은 반환해야
		// OS가 RAM을 3공간으로 나눠서 관리
		// ?
		// stack : 프로그램 종료되면 자동 반환
		//		 프로그램이 종료 안됐으면?
		// heap : 개발자가 수동으로 반환해야

		// Garbage Collection
		//			heap영역 자동정리
		//				그 자동의 발동시점이 언제
		//					그 번지를 가리키는 변수가 더 이상 없으면
		
		
	}
}
