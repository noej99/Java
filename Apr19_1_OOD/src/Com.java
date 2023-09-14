import java.util.Random;


// 공통속성 : static
// 기본값 : constructor
public class Com {
	Random brain;
	
	public Com() {
		brain = new Random();
	}
	
	
	public int comHand() {
		return brain.nextInt(3)+1;
	}
}
