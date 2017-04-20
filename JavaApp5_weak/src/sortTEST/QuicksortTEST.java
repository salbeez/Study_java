package sortTEST;

public class QuicksortTEST {
	
	public QuicksortTEST() {
		int array[] = {3,5,10,2,6,11};
		printArr(array);
		quick(array,0,array.length-1);
	}	
	
	private void quick(int[] array, int begin, int end) {
		if(begin <end){
		int p= patten(array,begin,end);
		quick(array, begin, p);
		quick(array,p+1,end);
		}
	}

	private int patten(int[] array, int i, int j) {
		int pivot = (i+j)/2;
		while(i<j){
			while(array[pivot] > array[i] && i<j){
				i++;
			}
			while(array[pivot] <= array[j] && i<j){
				j--;
			}
			if (i < j) {
				swap(array, i, j);				
			}
		}
		swap(array, pivot, i);
		printArr(array);
		return i;
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
	public static void main(String[] args) {
		new QuicksortTEST();
	}
}
