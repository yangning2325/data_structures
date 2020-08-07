package erchashu.pinghengerchatree;


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
//判断树的高度
public int height() {
	return Math.max(left==null? 0:left.height(),right==null? 0:right.height())+1;
}
//返回左子树的高度
public int leftheight() {
	if (left==null) {
		return 0;
	}else {
		return left.height();
	}
}
//返回右子树的高度
public int rightheight() {
	if (right==null) {
		return 0;
	}else {
		return right.height();
	}
}
//左旋转
private void leftRoate() {
	//创建新的结点，以当前根结点的值
	Node newnode = new Node(value);
	//把新结点的左子树设置成当前结点的左子树
	newnode.left=this.left;
	//把新节点的右子树设置成当前结点的右子树的左子树
	newnode.right=this.right.left;
	//把当前结点的值换成右子结点的值
	this.value=this.right.value;
	//把当前结点的右子树设置成当前结点的右子树的右子树
	this.right=this.right.right;
	//把当前结点的左子树设置成新的结点
	this.left=newnode;
}
//右旋转
private void rightRoate() {
	Node newnode = new Node(value);
	newnode.right=this.right;
	newnode.left=this.left.right;
	this.value=left.value;
	this.left=this.left.left;
	this.right=newnode;
			
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
	}//当添加一个结点进行判断是否要旋转
	//左旋转
	if (rightheight()-leftheight()>1) {
		if (right!=null&&right.leftheight()>right.rightheight()) {
			right.rightheight();
			leftRoate();
		}else {
			leftRoate();
		}	
		return;
	}
	//右旋转
	if (leftheight()-rightheight()>1) {
		if (left!=null&&left.rightheight()>left.leftheight()) {
			//先对当前结点的左子结点进行左旋转
			left.leftRoate();
			//然后再对当前结点进行右旋转；
			rightRoate();
		}else {
			//直接进行右旋转
			rightRoate();
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
