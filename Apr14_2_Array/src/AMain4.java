
public class AMain4 {
	public static void main(String[] args) {
		int option = 13;
		String[] op = { "24시간", "흡연실", "주차장", "와이파이" };

		for (int i = (op.length - 1); i >= 0; i--) {
			if (option >= (1 << i)) {
				System.out.println(op[i]);
				option -= (1 << i);
			}
		}
	}
}
