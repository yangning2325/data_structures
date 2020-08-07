package digui;

import java.util.Arrays;

public class Queue8 {

	int max = 8; // 表示多少个皇后；
	// 定义一维数组，保存皇后放置结果，入array={0，4，7，5，2，6，1，3}
	// 其中4表示第二个皇后第二行第五列
	int[] array = new int[max];
	int num = 0;//用来计数有多少种解
	int no = 0; //用来计数判断了多少次

	public static void main(String[] args) {
		// 进行测试
		Queue8 q = new Queue8();
		q.check(0);
		System.out.printf("一共有%d种放法\n", q.num);
		System.out.println("一共判断了" + q.no + "次");
	}

	// 将正确的放法打印出来
	public void printf() {
		num++;
		System.out.println(Arrays.toString(array));
	}

	// 对放置的皇后进行调整
	public void check(int n) {

		if (n == max) { // 表明前面八个皇后已经放好
			printf();

			return;
		}
		for (int i = 0; i < max; i++) {
			// 试探性的把皇后放在此位置，若此位置不可对该行进行遍历（i ++）
			// 直到找到合适位置为止
			array[n] = i;
			if (junge(n)) { // 进行皇后之间判断
				check(n + 1); // 进行递归放下一个皇后
				// 当放下一个皇后时的所有位置都与前面冲突回溯到上一步皇后的位置
				// （相当于此方法执行结束进行了弹栈继续执行上一步的方法）
				// 此时i在上一个方法位置上继续递增进行判断是否满足，
				// 若都不满足，在回溯到上一个方法的上一个，以此类推；
			}
		}
	}

	// 两个皇后之间进行判断判断
	// n表示第几个皇后；
	public boolean junge(int n) {
		no++;
		for (int i = 0; i < n; i++) { // 对于在放第n个皇后之前的皇后位置进行遍历
			// array[i]==array[n] 表示其中某个皇后与此时放的皇后在同一列
			// Math.abs(n-1)==Math.abs(array[n]-array[n])也就是说他俩的绝对值相等，此时表示两个皇后在同一斜线
			// 没有必要判断是否在同一行因为n每次都在递增
			if ((array[i] == array[n]) || (Math.abs(n - i) == Math.abs(array[n] - array[i]))) {
				return false;
			}
		}
		return true; // 表示放置正确
	}
}
