package findways;

import java.util.ArrayList;
import java.util.List;

public class Erfenfindway2 {

	public static void main(String[] args) {
		int[] arr = { 9, 15, 15, 15, 15, 56, 89 };
		List<Integer> index = find(arr, 0, arr.length - 1, 15);

		System.out.println("元素下标为" + index);

	}

	/**
	 * @param arr 传递的数组
	 * @param left 数组的最左索引
	 * @param right数组的最右索引
	 * @param num 要查找的数
	 */
	private static List<Integer> find(int[] arr, int left, int right, int num) {
		//表明未查到数据，直接返回一个空集合
		if (left > right) {
			return new ArrayList<Integer>();
		}
		//数组的中间索引
		int mid = (left + right) / 2;
		int midnum = arr[mid];
		//说明要查找的数在中间索引的右边，向右递归查找
		if (num > midnum) {
			return find(arr, mid + 1, right, num);
			//说明要查找的数在中间索引的左边，向左递归查找
		} else if (num < midnum) {
			return find(arr, left, mid - 1, num);
		} else {
			//考虑到有相同值的情况下，取出相同值的下标，返回一个集合
			List<Integer> list = new ArrayList<Integer>();
			int temp = mid - 1;
			while (temp >= 0 && arr[temp] == num) {
				list.add(temp);
				temp--;
			}
			list.add(mid);
			temp = mid + 1;
			while (temp < arr.length && arr[temp] == num) {
				list.add(temp);
				temp++;
			}
			return list;
		}
	}
}
