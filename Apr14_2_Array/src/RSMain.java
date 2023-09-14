// 반복문
//		반복횟수 : for
//		배열탐색용 : foreach <- Python
//		반복조건 : while / do-while

public class RSMain {
	public static void main(String[] args) {
		double[] height = { 177.3, 153.5, 185.6, 172.4, 175.1, 143.5, 158.3, 166.8 };

		for (int i = 0; i < height.length; i++) {
			double f = height[i];
			System.out.println(f);
		}
		System.out.println("---------------");
		// for (자료형 변수명 : 배열명){
		//
		// }

		// 순서조절불가
		// i가 없어서 -> 프로그램적으로 활용도 낮음
		for (double f : height) {
			System.out.println(f); // 위에 코드를 줄인 거
		}

	}
}
