package erchashu.hefumanbianma;


public class Node implements Comparable<Node> {
	Byte data;
	int value;
	Node left;
	Node right;

	public Node(Byte data, int value) {
		super();
		this.data = data;
		this.value = value;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", value=" + value + "]";
	}

	public void list(Node root) {
		if (root != null) {
			root.before();
		} else {
			System.out.println("树为空，不能遍历！");
		}
	}

	public void before() {
		System.out.println(this);
		if (this.left != null) {
			this.left.before();
		}
		if (this.right != null) {
			this.right.before();
		}
	}

	@Override
	public int compareTo(Node o) {

		return this.value - o.value;
	}
}
