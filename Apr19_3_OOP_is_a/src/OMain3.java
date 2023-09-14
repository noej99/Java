// 식당

public class OMain3 {
	public static void main(String[] args) {

		rice b = new rice("제육덮밥", 4000, 1);
		b.printInfo();

		System.out.println("---------");

		LikeFirst l = new LikeFirst("처음처럼", 4000, 12);
		l.printInfo();

		System.out.println("---------");

		Water w = new Water("삼다수", 0);
		w.printInfo();

	}
}
