import java.util.Scanner;

public class User {
	Scanner brain;
	int win;
	
	public User() {
		brain = new Scanner(System.in);
	}
	
	public int userHand() {
		return brain.nextInt();
	}
}
