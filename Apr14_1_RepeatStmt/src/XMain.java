
public class XMain {
	public static void main(String[] args) {

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print((j % 2 == 1) ? "ㅎ" : "ㅋ");
//				if (j == 1 || j == 3) {
//					System.out.print("ㅎ");
//				}else {
//					System.out.print("ㅋ");
//				}
			}
			System.out.println();
		}
		System.out.println("--------------------------");
		
		String s;
		for (int i = 0; i < 5; i++) {
			s =(i % 2 == 1) ? "ㅎ" : "ㅋ";
			for (int j = 0; j <= i; j++) {
				System.out.print(s);
			}
			System.out.println();
		}
		
	}
}
