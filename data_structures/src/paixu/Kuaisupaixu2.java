package paixu;

import java.util.Arrays;

public class Kuaisupaixu2 {

	public static void main(String[] args) {
		int[] arr = { 4, 7, 6, 5, 3, 2, 9, 1 };
		quickSort(arr, 0, arr.length - 1);

	}

	private static void quickSort(int[] arr, int startIndex, int endIndex) {
		if (startIndex >= endIndex) {
			return;
		}
		int pivot = partition(arr, startIndex, endIndex);
		quickSort(arr, startIndex, pivot - 1);
		quickSort(arr, pivot + 1, endIndex);
	}

	private static int partition(int[] arr, int startIndex, int endIndex) {
		int pivot = arr[startIndex];
		int right = endIndex;
		int left = startIndex;
		int index=startIndex;
		while (right>= left) {
			while (right>= left) {
				if(arr[right]<pivot) {
				arr[left] = arr[right];
				index=right;
				left++;
				break;
				}else {
					right--;
					}
				} 
			while (right>= left) {
				if (arr[left] >pivot) {
					arr[right] = arr[left];
					index=left;
					right--;
					break;
				}else {
					left++;
					}
				}
		}
			arr[index]=pivot;
			System.out.println(Arrays.toString(arr));
			return index;
}

}
