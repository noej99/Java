
public class OMain2 {
	public static void main(String[] args) {
		Human h = new Human("김길동", "수원");
		h.info();
		System.out.println("----------------");

		Human h2 = new Human("김판서", "안양", h);
		h2.info();
		System.out.println("----------------");

		Company c = new Company("삼성", 100, h2);
		c.info();
		System.out.println("----------------");

		Phone p = new Phone("갤s", 300000, c);

		p.info();
		System.out.println("----------------");

		System.out.println(p.name); // 폰모델명
		System.out.println("----------------");

		p.info(); // 폰 전체정보
		System.out.println("----------------");

		System.out.println(p.maker.employeeCount); // 폰 만든회사 직원수
		System.out.println("----------------");

		p.maker.info(); // 폰 만든회사 전체정보
		System.out.println("----------------");

		System.out.println(p.maker.ceo.address); // 폰 만든회사 사장 주소
		System.out.println("----------------");

		System.out.println(p.maker.ceo.son.name); // 폰 만든회사 사장 자식 이름
		System.out.println("----------------");

		p.maker.ceo.son.info(); // 폰 만든회사 사장 자식 전체정보
		System.out.println("----------------");
	}
}
