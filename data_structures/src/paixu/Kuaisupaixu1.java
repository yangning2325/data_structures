
package paixu;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Kuaisupaixu1 {

	public static void main(String[] args) {
//		int[] arr= {6,7,5,9,8,4,2};
//		quickSort( arr,0,arr.length-1);
		//System.out.println(Arrays.toString(arr));
		int[] arr = new int[10000000];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 100000);
		}
		Date date = new Date();
		long time=date.getSeconds();
		SimpleDateFormat s = new SimpleDateFormat("HH-mm:ss:S");
		System.out.println("快速排序（一千万个数据）");
		System.out.println("开始时间" + s.format(date));
		quickSort( arr,0,arr.length-1);
		Date date2 = new Date();
		long time2=date2.getSeconds();
		SimpleDateFormat s2 = new SimpleDateFormat("HH-mm:ss:S");
		System.out.println("结束时间" + s2.format(date2));
		long t;
		if (time2>=time) {
			 t=time2-time;
		}else {
			 t=60+(time2-time);
		}
		System.out.println("相差了"+t+"秒"); 
	}
	

	private static void quickSort(int[] arr, int startIndex, int endIndex) {
		//递归结束条件startIndex>=endIndex的时候
		if (startIndex>=endIndex) {
			return;
		}
		//根据基准元素，进行分治策略，分成两部分递归排序；
		int pivotIndex=partition(arr,startIndex,endIndex);
		//向左递归
		quickSort(arr, startIndex, pivotIndex-1);
		//向右递归
		quickSort(arr, pivotIndex+1, endIndex);
	}

	private static int partition(int[] arr, int startIndex, int endIndex) {
		//取第一个位置的元素作为基准元素；
		int pivot =arr[startIndex];
		int left=startIndex; //左指针
		int right =endIndex;//右指针
		//判断两个指针是否重合
		while (left!=right) {
			//控制right指针比较并左移；
			while (left<right&&arr[right]>pivot) {
				right--;
			}
			//控制left指针并比较右移
			while (left<right&&arr[left]<=pivot) {
				left++;
			}
			//交换left和right指向的元素；
			if (left<right) {
				int p=arr[left];
				arr[left]=arr[right];
				arr[right]=p;
			}
		}
		//pivot和指针重合点交换
		int p=arr[left];
		arr[left]=arr[startIndex];
		arr[startIndex]=p;
		//System.out.println(Arrays.toString(arr));
		return left;
	}
}
