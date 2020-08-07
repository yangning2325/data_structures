package erchashu.xIansuohua;

public class Tree {
	//指向当前结点的前驱结点的一个指针
	//在递归线索化时总是指向前一个结点
	
	private Hero root;
	private Hero pre=null;
	public void setRoot(Hero root) {
		this.root = root;
	}
	public void threadedNodes() {
		this.threadedNodes(root);
	}
	public void threadList() {
		Hero node=root;
		while (node!=null) {
			//循环找到leftType==1的结点，说明找到了遍历中的第一个结点
			while (node.getLeftType()==0) {
				node=node.getLeft();
			}
			//退出循环时表明找到了这个结点
			System.out.println(node);
			//如果当前结点的右指针指向的是后继结点，就一直输出
			while (node.getRightType()==1) {
				node=node.getRight();
				System.out.println(node);
			}
			node=node.getRight();
		}
		
	}
	//node表示当前需要线索化的结点
	public void threadedNodes(Hero node) {
		if (node==null) {
			return;
		}
		//线索化左子树
		threadedNodes(node.getLeft());
		//线索化当前结点
		//处理当前结点的前驱结点
		if (node.getLeft()==null) {
			node.setLeft(pre);
			//修改当前结点的左指针的类型
			node.setLeftType(1);
		}
		if (pre!=null&&pre.getRight()==null) {
			//让前驱结点的右指针指向当前结点
			pre.setRight(node);
			pre.setRightType(1);
			
		}
		//每处理一个结点，让当前结点成为下一个结点的前驱结点
		pre=node;
		//线索化右子树子树
		threadedNodes(node.getRight());
	}
	//删除结点
	public void delnum(int no) {
		if (root!=null) {
			//如果只有一个root结点则立即判断该结点是不是要删除的结点
			if (root.getNo()==no) {
				root=null;
			}else {
				root.delno(no);
			}
		}else {
			System.out.println("该树为空树不能删除");
		}
	}
	//前序遍历
	public void preOrder() {
		if (this.root!=null) {
			this.root.before();
		}else {
			System.out.println("当前二叉数为空");
		}
	}
	//中序遍历
	public void infixOrder() {
		if (this.root!=null) {
			this.root.midle();
		}else {
			System.out.println("当前二叉数为空");
		}
	}
	//后续遍历
	public void postOrder() {
		if (this.root!=null) {
			this.root.after();
		}else {
			System.out.println("当前二叉数为空");
		}
	}
	//前序查找
	public Hero presearch(int no) {
		if (root!=null) {
			return	root.beforeHero(no);
		}else {
			return null;
		}
	}
	//中序查找
	public Hero infixsearch(int no) {
		if (root!=null) {
			return	root.midleHero(no);
		}else {
			return null;
		}
	}
	//后序查找
	public Hero postsearch(int no) {
		if (root!=null) {
			return	root.afterHero(no);
		}else {
			return null;
		}
	}
}












