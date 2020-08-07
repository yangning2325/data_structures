package paixu;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.xml.crypto.Data;

public class Maopao {

	public static void main(String[] args) {
		int[] a = new int[100000];
		for (int i = 0; i < a.length; i++) {
			a[i] = (int) (Math.random() * 100000);
		}
		Date date = new Date();
		long time=date.getSeconds();
		SimpleDateFormat s = new SimpleDateFormat("HH:mm.ss-S");
		System.out.println("冒泡排序");
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
		//System.out.println(Arrays.toString(a));
	}

	public static void array(int[] a) {
	
		for (int i = 0; i < a.length - 1; i++) {
			boolean flag = true;
			for (int j = 0; j < a.length - i - 1; j++) {
				if (a[j] > a[j + 1]) {
					flag = false;
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
			if (flag ) {
				break;
			} 
		}
	}

}
