// static : 하나뿐인 것을 공유
public class Referee {
	static String[] ruleBook = { null, "가위", "바위", "보" };

	public static Com callCom() {
		return new Com();
	}

	public static User callUser() {
		return new User();
	}

	public static void explainRule() {
		System.out.println("1. 가위");
		System.out.println("2. 바위");
		System.out.println("3. 보");
		System.out.println("-----------");
	}

	public static int comHand(Com c) {
		int cp = c.comHand();
		return cp;
	}

	public static int userHand(User u) {
		System.out.print("뭐 : ");
		int up = u.userHand();
		return (up > 3 || up < 1) ? userHand(u) : up;
	}

	public static void presentation(int cp, int up) {
		System.out.printf("컴 : %s\n", ruleBook[cp]);
		System.out.printf("유저 : %s\n", ruleBook[up]);
	}

	public static int judge(int cp, int up) {
		int t = up - cp;
		if (t == 0) {
			System.out.println("무");
			return 0;
		} else if (t == -1 || t == 2) {
			System.out.println("패");
			return 12345;
		} else {
			System.out.println("승");
			return 1;
		}
	}
	
	public static void result(User u) {
		System.out.printf("%d연승\n", u.win);
	}

	public static void start() {
		Com c = new Com();
		User u = new User();
		explainRule();
		int compaper;
		int userpaper;
		int t = 0;
		while (true) {
			compaper = comHand(c);
			userpaper = userHand(u);
			presentation(compaper, userpaper);
			t = judge(compaper, userpaper);
			if (t == 12345) {
				break;
			}else if (t == 1) {
				u.win +=1;
			} else {
			}
		}
		result(u);
	}
}
