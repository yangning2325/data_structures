package erchashu.treeforarray;

public class Binarytree {
	private int[] arr;

	public Binarytree(int[] arr) {
		super();
		this.arr = arr;
	}

	// 重载
	public void before() {
		this.before(0);
	}

	public void before(int index) {
		if (arr == null || arr.length == 0) {
			System.out.println("数组为空不能遍历");
		}
		// 输出根节点
		System.out.println(arr[index]);
		// 向左递归遍历
		if (index * 2 + 1 < arr.length) {
			before(index * 2 + 1);
		}
		// 向右递归遍历
		if (index * 2 + 2 < arr.length) {
			before(index * 2 + 2);
		}
	}
}
