package paixu;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Xuanzepaixu {

	public static void main(String[] args) {
		int[] a = new int[100000];
		for (int i = 0; i < a.length; i++) {
			a[i] = (int) (Math.random() * 100000);
		}
		Date date = new Date();
		long time=date.getSeconds();
		SimpleDateFormat s = new SimpleDateFormat("HH:mm.ss-S");
		System.out.println("选择排序");
		System.out.println("开始时间" + s.format(date));
		array(a);
		Date date2 = new Date();
		long time2=date2.getSeconds();
		SimpleDateFormat s2 = new SimpleDateFormat("HH:mm.ss-S");
		System.out.println("结束时间" + s2.format(date2));
		long t;
		if (time2>=time) {
			 t=time2-time;
		}else {
			 t=60+(time2-time);
		}
		System.out.println("相差了"+t+"秒"); 
	}

	public static void array(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			int minindex = i; 				// 记录最小值下标
			int min = a[i]; 					// 记录最小值 ，先假设最小值为a[i];
			for (int j = i + 1; j < a.length; j++) {
				if (min > a[j]) { 			// 说明开一始假设的不是最小值
					min = a[j];			 // 重置最小值
					minindex = j; 		// 重置最小值下标
				}
			}
			if (minindex != i) {		// 说明最小值重置了
				a[minindex] = a[i]; 		// 进行位置交换
				a[i] = min;
			}

		}
	}
}
