// part1 : PP(Procedural Programming)
//		절차 지향 프로그래밍
//		순서에 맞게 조건문, 반복문 최적
//		효율적인 프로그램 만들자

//		유지보수에 좋으려면 소스 알아보기 편해야

// part2 : OOP(Object Oriented Programming)
//		객체 지향 프로그래밍
//		알아보기 편하게 소스 쓰자
//		=> 일상언어에 가깝게 
//		=> 객체를 써서 RealWorld를 묘사

public class OMain {
	public static void main(String[] args) {
		// 개 이름이 후추
		// 개 나이가 3살
		String name = "후추";
		int age = 3;
		System.out.println(name);
		System.out.printf("%d살\n",age);
		System.out.println("----------");
		// 객체는 다 참조형
		// class : 객체 만들때 필요한 거
		//			붕어빵 틀, 도장
		// 객체(object / instance) : 실생활에 존재하는 ?  (붕어빵)
		// 객체 만들기
		// 		클래스명 변수명 = new 클래스명();
		Dog d = new Dog();
		d.name = "후추";
		d.age = 3;
		d.bark();
		d.showInfo();
		System.out.println("----------");
		
		// 식당
		Restaurant r = new Restaurant();
		r.name = "김천";
		r.tableCount = 10;
		r.starPoint = 4.5;
		r.reservation = false;
		r.printInfo();
		System.out.println("----------");
		
		Restaurant r2 = new Restaurant();
		r2.name = "굿모닝";
		r2.tableCount = 30;
		r2.starPoint = 3.5;
		r2.reservation = true;
		r2.printInfo();
		
		// 참조형 주소
		System.out.println(r);
		System.out.println(r2);
	}
		
}
	

