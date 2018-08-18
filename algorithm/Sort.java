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
	
	public void quickSort(int[] array, int low, int high) {
		if(low < high) {
			int pi = partition(array, low, high);
			quickSort(array, low, pi - 1);
			quickSort(array, pi + 1, high);
		}
	}
	
	public void shellSort(int[] array) {
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
	
	public void insertionSort(int[] array) {
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
	
	public void selectionSort(int[] array) {
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

	public void bubbleSort(int[] array) {
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

	public void mergeSort(int[] array, int l, int h) {
		if(l < h) {
			int mid = (l + h) / 2;
			mergeSort(array, l, mid);
			mergeSort(arr, mid+1, h);
			merge(arr, l1, h1, l2, h2);
		}
	}

	private void merge(int[] array, int l, int m, int h) {
		int[] temp1 = new int[m - l + 1];
		int[] temp2 = new int[h - m];
		for(int i = l; i <= m; i++) {
			temp1[i - l] = array[i];
		}
		for(int i = m + 1; i <= h; i++) {
			temp2[i - m - 1] = array[i];
		}
		int cur = l;
		int idx1 = 0;
		int idx2 = 0;
		while(idx1 < temp1.length && idx2 < temp2.length) {
			if(temp1[idx1] <= temp2[idx2]) {
				array[cur++] = temp1[idx1++];
			} else {
				array[cur++] = temp2[idx2++];
			}
		}
		while(idx1 < temp1.length) {
			array[cur++] = temp1[idx1++];
		}
		while(idx2 < temp2.length) {
			array[cur++] = temp2[idx2++];
		}
	}

	public void heapSort(int[] array) {
		for(int n = array.length; n > 0; n--) {
			for(int i = (n -1) / 2; i >= 0; i--) {
				heapify(array, n, i);
			}
			swap(array, n - 1, 0);
		}
	}
	
	/** heapify the array to fit the constraint that root greater than children
	 * @param array 
	 * @param n size of heap
	 * @param idx the index to heapify
	 */
	private void heapify(int[] array, int n, int idx) {
		int left = 2 * idx + 1;
		int right = left + 1;
		int largest = idx;
		if(left < n && array[left] > array[idx]) {
			largest = left;
		}
		if (right < n && array[right] > array[largest]) {
			largest = right;
		}
		
		if(largest != idx) {
			swap(array, largest, idx);
			heapify(array, n, largest);
		}
	}
}
