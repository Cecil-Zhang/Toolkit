import java.util.Arrays;

/**
 * Sorting algorithm
 */
public class Sort {

	public static void main(String[] args) {
		Sort sort = new Sort();
		int[] array = {6,5,3,1,7,4,2,8};
		sort.quickSort(array, 0, array.length - 1);
		System.out.println(Arrays.toString(array));
	}
	
	private void swap(int[] arr, int i, int j) {
	    int temp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = temp;
	}
	
	private int partition(int[] array, int low, int high) {
		int pivot = array[high];
		int i = low;
		for(int j = low; j < high; j++) {
			if (array[j] < pivot) {
				swap(array, i++, j);
			}
		}
		swap(array, i, high);
		return i;
	}
	
	private void quickSort(int[] array, int low, int high) {
		if(low < high) {
			int pi = partition(array, low, high);
			quickSort(array, low, pi - 1);
			quickSort(array, pi + 1, high);
		}
	}
	
	private void shellSort(int[] array) {
		int n = array.length;
		for(int gap = n / 2; gap > 0; gap /= 2) {
			for(int i = gap; i < n; i++) {
				int cur = array[i];
				int j = i;
				for(; j >= gap; j -= gap) {
					if(array[j - gap] < cur) {
						break;
					} else {
						array[j] = array[j - gap];
					}
				}
				array[j] = cur;
			}
		}
	}
	
	private void insertionSort(int[] array) {
		for(int i = 1; i < array.length; i++) {
			int cur = array[i];
			int j = i - 1;
			for(; j >= 0; j--) {
				if (array[j] > cur) {
					array[j + 1] = array[j];
				} else {
					break;
				}
			}
			array[j + 1] = cur;
		}
	}
	
	private void selectionSort(int[] array) {
		for(int i = 0; i < array.length - 1; i++) {
			int idx = i;
			for(int j = i; j < array.length; j++) {
				if (array[j] < array[idx]) {
					idx = j;
				}
			}
			int temp = array[idx];
			array[idx] = array[i];
			array[i] = temp;
		}
	}

	private void bubbleSort(int[] array) {
		for(int i = 0; i < array.length - 1; i++) {
			boolean swap = false;
			for(int j = 0; j < array.length - 1 - i; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j + 1];
					array[j + 1] = array[j];
					array[j] = temp;
					swap = true;
				}
			}
			//optimize, if no two elements were swapped by inner loop, then break
			if (!swap) {
				break;
			}
		}
	}
}
