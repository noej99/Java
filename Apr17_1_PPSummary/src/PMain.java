public class PMain {

	// 정렬하는 함수

	public static void bubbleSort(int[] ar) {

//// bubble sort : 숫자 두개씩 크기비교해가며 정렬하는 것 
		int t;
		for (int turn = 0; turn < ar.length - 1; turn++) {
			for (int i = 0; i < ar.length -1 - turn; i++) {
				if (ar[i] > ar[i++]) {
					t = ar[i];
					ar[i] = ar[i++];
					ar[i++] = t;
				}
			}
		}
	}

// selection sort	
	public static void selectionSort(int[] ar) {

		int min = ar[0];
		int minIndex = 0;
		int t;
		for (int turn = 0; turn < ar.length-1; turn++) {
			min = ar[turn];
			minIndex = turn;
			for (int i = turn + 1; i < ar.length; i++) {
				if (min > ar[i]) {
					min = ar[i];
					minIndex = i;
				}
			}
			t = ar[turn];
			ar[turn] = ar[minIndex];
			ar[minIndex] = t;
		}
	}

	
	public static void main(String[] args) {

		int[] ar = { 45, 78, 2, 6, 56, 123, 12 };
		// 그 함수 호출
//		bubbleSort(ar);
//		selectionSort(ar);
		for (int i : ar) {
			System.out.println(i);
		}
	}
}
