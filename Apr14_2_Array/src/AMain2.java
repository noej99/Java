// Runnable JAR file
// 그거 있는 폴더로 가서 cmd
//		java -jar 파일명 aaa bbb ccc
public class AMain2 {
	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
		Thread.sleep(5000);
	}
}
