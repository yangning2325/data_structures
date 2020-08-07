package erchashu.ercahpaixushu;

public class Text {

	public static void main(String[] args) {
		int[] arr= {7,3,10,12,5,1,9,2};
		BinaryTree binaryTree = new BinaryTree();
		for (int i = 0; i < arr.length; i++) {
			binaryTree.addNodes(new Node(arr[i]));
		}
		binaryTree.infixOrder();
		System.out.println("删除后的情况");
		binaryTree.delete(2);
		binaryTree.delete(5);
		binaryTree.delete(9);
//		binaryTree.delete(12);
//		binaryTree.delete(3);
		binaryTree.delete(7);
//		binaryTree.delete(1);
		binaryTree.delete(10);
		System.out.println("根节点"+binaryTree.getRoot());
		binaryTree.infixOrder();
	}

}
