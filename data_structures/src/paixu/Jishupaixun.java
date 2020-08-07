package paixu;

import java.util.Arrays;

//定义十个桶每个桶用来存放数组中数，
//每个桶存放数的个数不确定但总数不会超过arr.lengh
//观察每个数的个位数字找对应的桶，把整个数放入该桶
//然后按顺序取出桶内的数放回原数组
//然后再依次取十位，百位………同上（位数不足补0，即放在为0的桶内）
//(此代码未进行考虑负数和浮点数，若考虑另行参考)
public class Jishupaixun {

	public static void main(String[] args) {
		int[] arr = { 53, 3, 542, 748, 14, 214 };
		array(arr);
		//System.out.println(Arrays.toString(arr));
	}
	private static void array(int[] arr) {
		// 定义的十个桶
		int[][] a = new int[10][arr.length];
		// 表示每个桶的元素个数
		int[] bucket = new int[10];
		// 假设第一个数为最大的数
		int max = arr[0];
		// 找出最大的数
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		// 算出最大数的位数
		int maxlength = (max + "").length();
		// 有多少位就循环多少次
		for (int m = 0, n = 1; m < maxlength; m++, n *= 10) {
			for (int i = 0; i < arr.length; i++) {
				// 取每个元素的个位，十位，百位………
				int num = arr[i] / n % 10;
				// 把元素放入桶内
				a[num][bucket[num]] = arr[i];
				// 有重复则+1；
				bucket[num]++;
			}
			// 定义索引记录原数组的下标
			int index = 0;
			// 遍历每个桶
			for (int j = 0; j < bucket.length; j++) {
				if (bucket[j] != 0) {
					// 如果桶里有数据，循环取出该桶里的数据
					for (int l = 0; l < bucket[j]; l++) {
						// 取出桶里的数据放入原数组中
						arr[index] = a[j][l];
						index++;
						
					}
					
				}
				// 每排序一次清空桶内的数据
				bucket[j] = 0;
				
			}
			System.out.println(Arrays.toString(arr));
		}
	}

}
