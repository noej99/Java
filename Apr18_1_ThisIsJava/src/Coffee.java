// .java(소스) -compile-> .class(기계어) -압축-> .jar
// 사용하는 사람이 이 클래스를 어떻게 써야하는지 모를테니
// => 설명서를 만들어줘야
// build path -> configure build path -> libraries -> add externals jar

// project -> generate javadoc

/**
 * I am hungry
 * 
 * @author noej
 *
 */

public class Coffee {
	String name;
	int price;

	/**
	 * How are you?
	 */
	public void show() {
		System.out.println(name);
		System.out.println(price);
	}
	/**
	 * I'M fine thank you
	 * @param sec and
	 * @return you
	 */
	public static int toMilliSec(int sec) {
		return sec * 1000;
	}
}
