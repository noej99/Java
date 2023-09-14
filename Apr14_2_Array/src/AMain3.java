// 배열
//		처음 만들때 사이즈 고정 -> 못 바꿈
//
//			사이즈를 모르면 배열을 못만들
//		자료형 못섞음
//		인덱스 기반 -> 의미를 알기 힘듦
//		=> 간단하게 데이터 여러개 표현할때는 써볼만한데
//		=> 주력으로 써먹기는 ...

// 객체지향 언어에서 2차원 배열 -> 잘못

public class AMain3 {
	public static void main(String[] args) {
		
		int[] age = { 10 , 30 };
//		 age[2] = 50;
		
		// 2차원 배열
		int[][] score = { { 100, 90 }, { 90, 80 } };
		System.out.println(score[0]);
		System.out.println(score[0][1]);
		
		for (int[] is : score) {
			for (int s : is) {
				System.out.println(s);
			}
		}
	}
}
