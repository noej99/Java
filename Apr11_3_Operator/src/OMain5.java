// 문법 : 찾아서 하면 됨
// 수학적 사고력 : 그 문법을 적재적소에 활용

import java.util.Scanner;

public class OMain5 {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);

		System.out.print("가격 : ");
		int price = k.nextInt();

		System.out.print("낸 돈 : ");
		int money = k.nextInt();

		System.out.println("-------------------------");

		int change = money - price;

		int a = change / 50000;
		int b = (change % 50000) / 10000;
		int c = (change % 50000 % 10000) / 5000;
		int d = (change % 50000 % 10000 % 5000) / 1000;
		int e = (change % 50000 % 10000 % 5000 % 1000) / 500;
		int f = (change % 50000 % 10000 % 5000 % 1000 % 500) / 100;
		int g = (change % 50000 % 10000 % 5000 % 1000 % 500 % 100) / 50;
		int h = (change % 50000 % 10000 % 5000 % 1000 % 500 % 100 % 50) / 10;

		System.out.printf("거스름돈 : %d\n", change);
		System.out.printf("5만원짜리 %d개\n", a);
		// change = change - (50000 - a);
		// change = change % 50000;
		// change %= 50000;
		System.out.printf("1만원짜리 %d개\n", b);
		System.out.printf("5천원짜리 %d개\n", c);
		System.out.printf("1천원짜리 %d개\n", d);
		System.out.printf("5백원짜리 %d개\n", e);
		System.out.printf("1백원짜리 %d개\n", f);
		System.out.printf("5십원짜리 %d개\n", g);
		System.out.printf("1십원짜리 %d개\n", h);

	}

}
