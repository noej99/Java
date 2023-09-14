import java.util.Iterator;

public class RSMain2 {
	public static void main(String[] args) {

		// 2단~9단
		for (int dan = 2; dan < 10; dan++) {
			for (int i = 1; i < 10; i++) {
				System.out.printf("%d x %d = %d\n",dan, i, dan * i);
			}

		}
		
		System.out.println("----------------------");
		for (int i = 1; i < 10; i++) {
			for (int dan = 2; dan < 10; dan++) {
				System.out.printf("%d x %d = %d\t",dan,i,  dan*i  );
			}
		}
		//	
		for (int i = 0; i <= 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print("ㅋ");
			}
			System.out.println();
		}
		System.out.println("----------------");
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("ㅋ");
			}
			System.out.println();
		}
		System.out.println("---------------");
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < (5-i); j++) {
				System.out.print("ㅋ");
			}
			System.out.println();
		}
		System.out.println("---------------");
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <= i; j++) {
				if (i == j) {
					System.out.print("ㅋ");
				} else {
					System.out.print("  ");
				}
			}	
			System.out.println();
		}
		System.out.println("---------------");
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("  ");	
			}
			System.out.println("ㅋ");
	}
		System.out.println("---------------");
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <= i; j++) {
				if (i == 1 || i == 3) {
					System.out.print("ㅎ");
				} else {
					System.out.print("ㅋ");
				}
			}
			System.out.println();
		}	
}
}	