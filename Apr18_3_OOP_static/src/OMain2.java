// 변수 언제 만드나 : 데이터 임시 저장할때 
// 객체 언제 만드나 : 실생활스럽게

public class OMain2 {
	public static void main(String[] args) {
		Calculator.printSum(30, 10);
		
		System.out.println("-----------");
		
		PC pc1 = new PC();
		pc1.ram = 32;
		pc1.printSpec();
		PC pc2 = new PC();
		pc2.printSpec();
	}
}
