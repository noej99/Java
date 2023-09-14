// 설계		-번역(coding)->		.java
// .java	-번역(compile)->	.class
// .class 	-압축->				.jar
// .jar 	-실행->
// -------------------------------
// JRE가 JVM을 실행하는 OS에 맞게 만들어 올리고 ->
// 프로그램 소스(기계어 상태)가 stack에 깔리고 ->
// static멤버변수들 static영역에 만들고 ->
// JVM이OMain.main(...)을 호출

//  Java : Perfect한 OOL
// Python : Hybrid한 OOL

public class OMain {
	public static void main(String[] args) {
		// 게장
		// 품명이 가정의 달 특별세트
		// 무게가 5kg
		// 가격이 39900
		// 정보출력
		System.out.println(Gejaang.PRODUCTOR);
		Gejaang.test();
		System.out.println("------------");
		
		Gejaang g1 = new Gejaang();
		g1.name = "가정의 달 특별세트";
		g1.weight = 5;
		g1.price = 39900;
		g1.printInfo();
		System.out.println("------------");

		Gejaang g2 = new Gejaang();
		g2.name = "간장게장세트";
		g2.weight = 10;
		g2.price = 79900;
		g2.printInfo();
		System.out.println("------------");
		System.out.println(g1);
		System.out.println(g2);
		
		g1.name ="ㅋㅋㅋ";
		g1.printInfo();
		g2.printInfo();
				

	}
}
