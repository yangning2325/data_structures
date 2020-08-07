package paixu;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Charupaixu {

	public static void main(String[] args) {
		int[] a = new int[100000];
		for (int i = 0; i < a.length; i++) {
			a[i] = (int) (Math.random() * 100000);
		}
		Date date = new Date();
		long time=date.getSeconds();
		SimpleDateFormat s = new SimpleDateFormat("HH-mm:ss:S");
		System.out.println("插入排序");
		System.out.println("开始时间" + s.format(date));
		array(a);
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

	private static void array(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int insertValu = array[i]; // 要插入的元素
			int inserIndex = i - 1; // 要插入元素的前一个元素下标
			// inserIndex>=0保证给insertValu找插入位置不越界
			// insertValu<array[inserIndex]待插入的数还没有找到插入位置
			while (inserIndex >= 0 && insertValu < array[inserIndex]) {
				array[inserIndex + 1] = array[inserIndex]; // 后移，此时array[inserIndex+1]和array[inserIndex]值相同
				inserIndex--; // 继续找前一个元素
			}
			// 退出while循环时表示找到了插入的位置也就说明insertValu>array[inserIndex]
			// 或者是找到头了也没找到比它小的此时inserIndex=-1；
			array[inserIndex + 1] = insertValu;
			// insertValu放在array[inserIndex]后面即array[inserIndex+1]=insertValu
			// 此时insertValu覆盖了两个相同值下标小的那个值
		}

	}

}
