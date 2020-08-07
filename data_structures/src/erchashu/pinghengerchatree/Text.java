package erchashu.pinghengerchatree;

public class Text {

	public static void main(String[] args) {
		//int[] arr= {10,12,8,9,7,6};
		int[] arr= {10,11,7,6,8,9};
	AVLtree avLtree = new AVLtree();
	for (int i = 0; i < arr.length; i++) {
		avLtree.addNodes(new Node(arr[i]));
	}
	System.out.println("树的高度"+avLtree.getRoot().height());
	System.out.println("左子树的高度"+avLtree.getRoot().leftheight());
	System.out.println("右子树的高度"+avLtree.getRoot().rightheight());
	System.out.println("当前根节点为："+avLtree.getRoot());
	}

}
