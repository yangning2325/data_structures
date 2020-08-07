package paixu;


import java.util.Arrays;

public class Maopao2 {

	public static void main(String[] args) {

			int[] arr = {3,2,1,4,5,8 };
			array(arr);
			// System.out.println(Arrays.toString(arr));
		}

		public static void array(int[] arr) {
			//记录最后一次交换的位置
			int lastindex=0;
			//无需数列的边界，每次比较到此为止
			int border=arr.length-1;
			// 只需进行arr.length - 1次循环即可，因为最后一次循环已是有序
			for (int i = 0; i < arr.length - 1; i++) {
				// 设置一个标记初始化为true
				boolean flag = true;
				// 每交换一轮结束后固定最后较大的元素，不再参内层加循环
				for (int j = 0; j < border; j++) {
					if (arr[j] > arr[j + 1]) { // 相邻元素进行比较
						// 当有元素交换时标记为false
						flag = false;
						int temp = arr[j]; // 定义临时指针
						arr[j] = arr[j + 1]; // 对相邻元素进行位置交换
						arr[j + 1] = temp;
						//把无序数列边界更新为最后一次交换元素的位置
						lastindex=j;
					}
				}
				border=lastindex;
				// 此时标记为true时表明已经没有进行元素交换，直接终止外层循环
				if (flag) {
					break;
				}
				System.out.println(Arrays.toString(arr));
			}
		}
	}
