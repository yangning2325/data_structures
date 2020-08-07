package erchashu.hefumantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Text {

	public static void main(String[] args) {
		int[] arr = { 13, 7, 8, 3, 29, 6, 1 };
		Node root = huffmanTree(arr);
		System.out.println("最终结点为"+root);
		list(root);
	}

	public static void list(Node root) {
		if (root != null) {
			root.preOrder();
		} else {
			System.out.println("树为空，不能遍历！");
		}
	}

	public static Node huffmanTree(int[] arr) {

		List<Node> list = new ArrayList<Node>();
		// 遍历数组，将arr中的每一个元素构成一个Node
		// 将Node放入到链表里
		for (int value : arr) {
			list.add(new Node(value));
		}
		while (list.size() > 1) {
			// 进行排序
			Collections.sort(list);
			// 取出权值最小的结点
			Node lefeNode = list.get(0);
			Node rightNode = list.get(1);
			Node parent = new Node(lefeNode.value + rightNode.value);
			// 构建成树
			parent.left = lefeNode;
			parent.right = rightNode;
			// 删除子结点
			list.remove(lefeNode);
			list.remove(rightNode);
			// 加入父结点
			list.add(parent);
		}
		//返回最终结点
		return list.get(0);
	}
}
