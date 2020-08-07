package paixu;

import java.util.Arrays;

public class Guibingpaixu {

	public static void main(String[] args) {
		int[] arr = { 8, 4, 5, 7, 1, 3, 6, 2 };
		// 中转数组
		int[] temp = new int[arr.length];
		mergesort(arr, 0, arr.length - 1, temp);
		// System.out.println(Arrays.toString(arr));
		
	}

	// 进行分组
	private static void mergesort(int[] arr, int left, int right, int[] temp) {
		if (left < right) {
			// 找到我们的中间索引
			int mid = (left + right) / 2;
			// 向左递归分组
			mergesort(arr, left, mid, temp);
			// 向右递归分组
			mergesort(arr, mid + 1, right, temp);
			// 调用排序方法排序
			merge(arr, left, mid, right, temp);
		}
	}

	/**
	 * @param arr   排序的原始数组
	 * @param left  左边有序序列的初始索引
	 * @param mid   中间索引
	 * @param right 右边索引
	 * @param temp  中转数组
	 */
	private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
		int i = left; // 左边有序序列的初始索引；
		int j = mid + 1; // 右边有序序列的初始索引；
		int t = 0;// 指向temp数组的当前索引；
		//先把左右两边（有序）数组按规则填充到temp数组
		//直到左右两边的有序序列，有一边处理完为止
		while (i <= mid && j <= right) {
			//若左边的有序序列的当前元素小于等于右边有序序列的当前元素
			//将左边的当前元素填充到temp数组中
			//然后t和i后移
			if (arr[i] <= arr[j]) {
				temp[t] = arr[i];
				t++;
				i++;
			} else {//反之将右边有序序列的当前元素，填充到temp数组
				temp[t] = arr[j];
				t++;
				j++;
			}
		}
		// 把剩余的数依次填充到temp
		while (i <= mid) {// 左边剩余数据全部填充到temp中
			temp[t] = arr[i];
			t++;
			i++;
		}
		while (j <= right) {// 右边剩余数据全部填充到temp中
			temp[t] = arr[j];
			t++;
			j++;
		}
		// 把temp数组元素拷贝到arr
		// 并不是每次到拷贝所有
		t = 0;
		int templeft = left;
		while (templeft <= right) {
			arr[templeft] = temp[t];
			t++;
			templeft++;
		}
		System.out.println(Arrays.toString(arr));
	}

}
