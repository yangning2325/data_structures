package erchashu.hefumantree;

public class Node implements Comparable<Node> {
	int value;
	Node left;
	Node right;

	public Node(int value) {
		super();
		this.value = value;
	}

	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}

	@Override
	public int compareTo(Node o) {
		// 表示从小到大排序
		return this.value - o.value;
	}
public void preOrder() {
	System.out.println(this);
	if (this.left!=null) {
		this.left.preOrder();
	}
	if (this.right!=null) {
		this.right.preOrder();

	}
}
}
