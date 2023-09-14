import java.util.Scanner;

// 바퀴둘레 : 
// 앞 기어 톱니 수 : 
// 뒷 기어 톱니 수 : 
// 발 몇번 굴렀나 : 
// -------------------------
// 이동거리 : 
public class OMain6 {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);

		System.out.print("바퀴둘레 : ");
		double cir = k.nextDouble();

		System.out.print("앞 기어 톱니 수 : ");
		int frontGear = k.nextInt();

		System.out.print("뒷 기어 톱니 수 : ");
		int rearGear = k.nextInt();

		System.out.print("페달 밟은 횟수 : ");
		double pedal = k.nextInt();

		System.out.println("--------------------------");

		double gear = frontGear / (double) rearGear;
		double distance = gear * pedal * cir;

		System.out.printf("이동거리 : %.2f\n", distance);
	}

}
