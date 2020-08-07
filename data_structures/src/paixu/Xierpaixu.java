package paixu;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
//采用交换法进行希尔排序
public class Xierpaixu {

	public static void main(String[] args) {
		int[] a = new int[100000];
		for (int i = 0; i < a.length; i++) {
			a[i] = (int) (Math.random() * 10000);
		}
		Date date = new Date();
		long time=date.getSeconds();
		SimpleDateFormat s = new SimpleDateFormat("HH-mm:ss:S");
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
		System.out.println("相差了"+t+"秒");  //相差了14秒
		//System.out.println(Arrays.toString(a));

	}
public static void array(int[] a) {
	int temt=0;
	for (int k=a.length/2;k>0;k=k/2) {
		//分成k组，每组是length/k个元素
		for (int i = k; i < a.length; i++) {
			for (int j = i-k; j >=0; j-=k) { //步长是k
				//对每一组的数据进行排序
				if (a[j]>a[j+k]) {
					temt=a[j];
					a[j]=a[j+k];
					a[j+k]=temt;
				}
			}
		}
	}
}
}
