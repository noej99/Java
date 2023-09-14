import java.util.Scanner;

// 멤버변수 : 객체 속성(자기소개할때 얘기할만한거)
// 지역변수 : 그 액션 하는동안만 쓰고 버리는거
public class Doctor {

	public void start() {
		Guest g = callGuest();
		ask(g);
		calculate(g);
		tellResult(g);
	}

	// 이 액션하는데 필요한 재료
	// 액션 끝나고 남는거
	public Guest callGuest() {
		return new Guest();
	}

	public void ask(Guest g) {
		System.out.print("이름 : ");
		g.name = g.tellName();

		System.out.print("키(m) : ");
		g.height = g.tellHW();
		g.height /= 100;

		System.out.print("몸무게 : ");
		g.weight = g.tellHW();
	}

	public void calculate(Guest g) {
		g.bmi = g.weight / (g.height * g.height);
		g.status = " 저체중";
		if (g.bmi >= 35) {
			g.status = "고도 비만";
		}
		if (g.bmi >= 30) {
			g.status = "중도 비만";
		}
		if (g.bmi >= 25) {
			g.status = " 경도 비만";
		}
		if (g.bmi >= 23) {
			g.status = "과체중";
		}
		if (g.bmi >= 18.5) {
			g.status = " 정상";
		}
	}

	public void tellResult(Guest g) {
		System.out.printf("BMI : %.1f\n", g.bmi);
		System.out.printf("%s씨는 %s\n", g.name, g.status);
	}
}
