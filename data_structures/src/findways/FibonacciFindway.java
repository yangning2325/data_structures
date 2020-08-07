package findways;

import java.util.Arrays;

public class FibonacciFindway {
	public static int maxsize = 20;

	public static void main(String[] args) {

		int[] arr = { 25, 32, 42, 52, 63, 75 };
System.out.println(fibSearch(arr, 42));
	}

	public static int[] fib() {
		int[] f = new int[maxsize];
		f[0] = 1;
		f[1] = 1;
		for (int i = 2; i < maxsize; i++) {
			f[i] = f[i - 1] + f[i - 2];
		}
		return f;

	}

	/**
	 * @param a   数组
	 * @param key 要查找的关键值
	 * @return 返回对应的下标，没有返回-1
	 */
	public static int fibSearch(int[] a, int key) {
		int low = 0;
		int hight = a.length - 1;
		int k = 0; // 表示斐波那契数值的下标
		int mid = 0; // 存放mid值
		int f[] = fib(); // 获取返回的斐波那契数列
		while (hight > f[k] - 1) {
			k++;
		}
		// 因为f[k]值可能大于a的长度，因此我们需要使用Arrays类，构造一个新的数组
		int[] temp = Arrays.copyOf(a, f[k]);
		// 用a数组的最后一个数填充新数组而不是0；
		for (int i = hight + 1; i < temp.length; i++) {
			temp[i] = a[hight];
		}
		// 使用循环处理，找到key
		while (low <= hight) {
			mid = low + f[k - 1] - 1;
			if (key < temp[mid]) {
				hight = mid - 1;
				// 因为可以继续拆分f[k-1]=f[k-2]+f[k-3]
				// 即下次循环mid=f[k-1-1]-1
				k--;
			} else if (key > temp[mid]) { // 向右查找
				low = mid + 1;
				// 全部元素=前面元素+后面元素
				// f[k]=f[k-1]+f[k-2]
				// 后面f[k-2],可拆分为f[k-1]=f[k-3]+f[k-4]
				// 即在f[k-2] 的前面进行查找k-=2
				// 即下次循环mid=f[k-1-2]-1
				k -= 2;
			} else {
				// 确定返回的使哪个下标
				if (mid <= hight) {
					return mid;
				} else {
					return hight;
				}
			}
		}
		return -1;
	}
}
