import java.util.Scanner;

public class CSMain3 {

	public static String name() {
		Scanner k = new Scanner(System.in);
		System.out.print("이름 : ");
		return k.next();
	}
		
	public static double getHeight() {
		Scanner k = new Scanner(System.in);
		System.out.print("키(m) : ");
		double h = k.nextDouble();
//		if (h>3) {
//			return h/100;
//		} else {
//			return h;
//		}
		return (h > 3) ? (h / 100)	: h;
		// return (h > 3) ? getHeight() : h;
	}

	public static double getWeight() {
		Scanner k = new Scanner(System.in);
		System.out.print("몸무게 : ");
		return k.nextDouble();
	}

	public static double bodyMassIndex(double height , double weight) {
		return weight / (height *height);
	}
	
	public static String bmiCheck(double bmi) {
		if (bmi >= 35) {
			return "고도 비만";
		} 
		if (bmi >=30) {
			return "중도 비만";
		}
		if (bmi >= 25) {
			return " 경도 비만";
		}
		if (bmi >= 23) {
			return "과체중";
		}
		if (bmi >= 18.5) {
			return " 정상";
		}
		return " 저체중";
	}
	
	public static void printResult(String name, double bmi, String result) {
		System.out.printf("BMI : %.1f\n", bmi);
		System.out.printf("%s는 %s입니다\n",name, result);
	}
	
	public static void main(String[] args) {
		String n = name();
		double height = getHeight();
		double weight = getWeight();
		double bmi = bodyMassIndex(height, weight);
		String result = bmiCheck(bmi);
		printResult(n, bmi, result);
		
		
	
	}
}
