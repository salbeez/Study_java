package sortTEST;

public class bubbleTEST {
	public static void main(String[] args) {
		int arr[] = { 3, 5, 10, 13,2, 6, 11 };

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if(arr[i]> arr[j]) {
					swap(arr, i, j);
					printArr(arr);
				}
			}
		}
	}

	private static void printArr(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
