package erchashu.ercahpaixushu;

public class Node {
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
//添加结点的方法
public void add(Node node) {
	if (node==null) {
		return;
	}
	if (node.value<this.value) {
		if (this.left==null) {
			this.left=node;
		}else {
			this.left.add(node);
		}
	}
	if (node.value>this.value) {
		if (this.right==null) {
			this.right=node;
		}else {
			this.right.add(node);
		}
	}
}
//中序遍历
public void infixOrder() {
	if (this.left!=null) {
		this.left.infixOrder();
	}
	System.out.println(this);
	if (this.right!=null) {
		this.right.infixOrder();
	}
}
//查找删除结点
public Node finddeleteNode(int value) {
	if (this.value==value) {
		return this;
	}else if (value<this.value) {
		if (this.left==null) {
			return null;
		}
		return this.left.finddeleteNode(value);
	}else{
		if (this.right==null) {
			return null;
		}
		return this.right.finddeleteNode(value);
	}

}
//查找要删除的结点的父结点
public Node deleteparent( int value) {
	if ((this.left!=null&&this.left.value==value)
			||(this.right!=null&&this.right.value==value)) {
		return this;
		
	}else {
		if (value<this.value&&this.left!=null) {
			return this.left.deleteparent(value);//向左子树递归查找		
		}else if (value>=this.value&&this.right!=null) {
			return this.right.deleteparent(value);//向右子树递归查找
		}else {
			return null;//没有找到父结点
		}
	}
}
}
