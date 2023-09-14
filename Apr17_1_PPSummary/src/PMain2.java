import java.util.Arrays;
import java.util.Random;




public class PMain2 {

	
	public static int pick(int pos, int[] lotto) {
		Random r = new Random();
		int l = r.nextInt(45)+1;
		for (int i = 0; i < pos; i++) {
			if (l == lotto[i]) {
				return pick(pos, lotto);
			}
		}
		return l;
	}
	
	
	// 1 0
	public static void main(String[] args) {
		// 로또번호 자동
		// 1 ~ 45사이의 중복없는 랜덤한 숫자 6개
		// 정렬
		int[] lotto = new int[6];
		int l;
			for (int i = 0; i < lotto.length; i++) {
				lotto[i] = pick(i,lotto);
				}
			Arrays.sort(lotto);
			for (int i : lotto) {
				System.out.println(i);
			}	
		}
}
// 4  12  21  27  39  43
