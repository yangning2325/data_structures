package erchashu;

public class Tree {
	private Hero root;
	public void setRoot(Hero root) {
		this.root = root;
	}
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












