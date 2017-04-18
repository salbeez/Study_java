package com.kosta.j0414;

public class QuicksortTEST {
	static int i = 0;

	public static void main(String[] args) {
		int[] arr = { 69, 10, 30, 2, 16, 8, 31, 22 };
		printArr(arr);
		quickSort(arr, 0, arr.length - 1);
	}

	public static void quickSort(int[] arr, int begin, int end) {
		if (begin < end) {
			int p = partition(arr, begin, end);
			quickSort(arr, begin, p - 1);
			quickSort(arr, p + 1, end);
		}
	}

	public static int partition(int arr[], int begin, int end) {
		int left = begin;
		int right = end;

		int pivot = (left + right) / 2;

		System.out.println("[퀵 정렬 " + ++i + "단계: pivot: " + arr[pivot]);

		while (left < right) {
			while ((arr[left] < arr[pivot]) && (left < right))
				// L 움직이는 부분
				left++;
			while ((arr[right] >= arr[pivot]) && (left < right))
				// R 움직이는 부분
				right--;

			if (left < right) {
				swap(arr, left, right);
			}
		}
		printArr(arr);
		swap(arr, pivot, left);

		printArr(arr);
		System.out.println("--"+left+"--");
		return left;
	}

	private static void printArr(int[] arr) {
		for(int i : arr){
			System.out.print(i+" ");
		}
		System.out.println();
	}

	private static void swap(int[] arr, int pivot, int right) {
		int temp = arr[pivot];
		arr[pivot] = arr[right];
		arr[right] = temp;
	}

}
