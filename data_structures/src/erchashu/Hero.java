package erchashu;


public class Hero{
	private int no;
	private String name;
	private Hero left;
	private Hero right;
	public Hero(int no, String name) {
		super();
		this.no = no;
		this.name = name;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Hero getLeft() {
		return left;
	}
	public void setLeft(Hero left) {
		this.left = left;
	}
	public Hero getRight() {
		return right;
	}
	public void setRight(Hero right) {
		this.right = right;
	}
	@Override
	public String toString() {
		return "Hero [no=" + no + ", name=" + name + "]";
	}
	public void delno(int num) {
		//如果当前节点的左子节点就是要删除的节点，则将左子节点置空
		if (this.left!=null&&num==this.left.no) {
			System.out.println("删除"+this.left.no+"号结点成功！");
			this.left=null;
			
			return;
		}
		//如果当前节点的右子节点就是要删除的节点，则将右子节点置空
		if (this.right!=null&&num==this.right.no) {
			System.out.println("删除"+this.right.no+"号结点成功！");
			this.right=null;
			
			return;
		}
		//向左递归删除
	if (this.left!=null) {
		this.left.delno(num);
	}
	//向右递归删除
	if (this.right!=null) {
		this.right.delno(num);
	}
//	System.err.println("没有找到要删除的"+no+"号结点");
//	return;
	}
	//前序遍历
	public void before() {
		System.out.println(this);
		if (this.left!=null) {
			this.left.before();
		}
		if (this.right!=null) {
			this.right.before();
		}			
	}
	//中序遍历
	public void midle() {
		
		if (this.left!=null) {
			this.left.midle();
		}
		System.out.println(this);
		if (this.right!=null) {
			this.right.midle();
		}			
	}
	//后序遍历
	public void after() {
		
		if (this.left!=null) {
			this.left.after();
		}
		if (this.right!=null) {
			this.right.after();
		}	
		System.out.println(this);
	}
	//前序查找
	public Hero beforeHero(int no) {
		System.out.println("进入后序遍历");
		if (this.no==no) {
			return this;
		}
		Hero node=null;
		if (this.left!=null) {
			node=this.left.beforeHero(no);
		}
		if (node!=null) {
			return node;
		}
		if (this.right!=null) {
			node=this.right.beforeHero(no);
		}
		return node;
	}
	//中序查找
	public Hero midleHero(int no) {
		Hero node=null;
		if (this.left!=null) {
			node=this.left.midleHero(no);
		}
		if (node!=null) {
			return node;
		}
		System.out.println("进入中序遍历");
		if (this.no==no) {
			return this;
		}
		if (this.right!=null) {
			node=this.right.midleHero(no);
		}
		return node;
	}
	//后序查找
	public Hero afterHero(int no) {

		Hero node=null;
		if (this.left!=null) {
			node=this.left.afterHero(no);
		}
		if (node!=null) {
			return node;
		}
		if (this.right!=null) {
			node=this.right.afterHero(no);
		}
		if (node!=null) {
			return node;
		}
		System.out.println("进入后序遍历");
		if (this.no==no) {
			return this;
		}
		return node;
	}
}
