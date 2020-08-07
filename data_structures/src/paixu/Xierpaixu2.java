package paixu;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Xierpaixu2 {

	public static void main(String[] args) {

//		int[] a = new int[100000];
//		for (int i = 0; i < a.length; i++) {
//			a[i] = (int) (Math.random() * 100000);
//		}
//		Date date = new Date();
//		long time = date.getSeconds();
//		SimpleDateFormat s = new SimpleDateFormat("HH-mm:ss:S");
//		System.out.println("希尔排序");
//		System.out.println("开始时间" + s.format(date));
//		array(a);
//		Date date2 = new Date();
//		long time2 = date2.getSeconds();
//		SimpleDateFormat s2 = new SimpleDateFormat("HH-mm:ss:S");
//		System.out.println("结束时间" + s2.format(date2));
//		long t;
//		if (time2 >= time) {
//			t = time2 - time;
//		} else {
//			t = 60 + (time2 - time);
//		}
//		System.out.println("相差了" + t + "秒");

	int[] a = { 5, 4, 6, 7,1,8,2,3 };
	array(a);
//		System.out.println(Arrays.toString(a));
	}

	public static void array(int[] a) {
		// 每一次分组的增量进行折半
		for (int k = a.length / 2; k > 0; k = k / 2) {
			// 从下标为k的元素开始然后与下标-k的元素进行比较
			// 可以变相的认为分成k组，每组是length/k个元素
			// 然后对每一组进行插入排序
			for (int i = k; i < a.length; i++) {
				// 定义临时变量
				int insertvalue = a[i];
				int index = i - k;
				// 判断是否成立若不成立，进行下一次循环
				while (index >= 0 && insertvalue < a[index]) {
					a[index + k] = a[index]; // 后移
					index = index - k;// 继续寻找以相同增量的前一个元素
				}
				// 退出循环时表明找到了要插入的位置
				a[index + k] = insertvalue;
			}
			 System.out.println(Arrays.toString(a));
		}
	}
}
