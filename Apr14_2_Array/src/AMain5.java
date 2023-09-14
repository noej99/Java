
public class AMain5 {
	public static void main(String[] args) {
		
//		 CPU 많이 사용
		int change = 164320;
		int won = 50000;
		int result;
		int five = 5;
		while (true) {
			if (won == 5) {
				break;
			}
			result = change / won;
			System.out.printf("%d원짜리 : %d\n", won , result);
			change %= won;
			won /= five;
			five = (five == 5)? 2 : 5;
			
		}
		
		
//		int change = 58980;
//		int won = 50000;
//		int result;
//		for (int i = 0; i > 7; i++) {
//			if (i % 2 == 0) {
//				result = change % won;
//				System.out.printf("%d원짜리 : %d\n",won , result);
//				change = change / 5;
//			} else {
//				result = change % won;
//				System.out.printf("%d원짜리 : %d\n",won , result);
//				change = change / 2;
//			}
//		}

		
		//	배열 -> RAM사용 많이
//		int[] won = {50000,10000,5000,1000,500,100,50,10};
//		int money = 89680;
//		int result = 0;
//		
//		for (int i : won) {
//			result = money / i;
//			System.out.printf("%d원짜리 : %d개\n", i, result);
//			money %= i;
//		}
	}
}
