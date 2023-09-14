// 객체간의 관계
//		A has a B : 가지는 관계
//			ex)	String name;


public class OMain {
	public static void main(String[] args) {

		Dog d = new Dog();

		d.name = "후추";
		d.age = 3;

		d.info();
		System.out.println("----------");

		Human h = new Human("홍길동", "수원",null);
		h.pet = d;
		h.info();
		System.out.println("----------");
		
		System.out.println(h.name); // 사람 이름
		System.out.println(h.address); // 사람 집
		System.out.println(h.pet); // 사람의 반려동물
		System.out.println(h.pet.name); // 사람의 반려동물의 이름
		
	}
}
