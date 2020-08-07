package findways;

public class Xinxingfindway {

	public static void main(String[] args) {
		int[] arr = { 53, 56, 23, 14, 9, 10 };
		int index = find(arr, 1);
		if (index == -1) {
			System.out.println("没有找到！");
		} else {
			System.out.println("下标为" + index);
		}
	}

	public static int find(int[] arr, int num) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == num) {
				return i;
			}
		}
		return -1;

	}
}
