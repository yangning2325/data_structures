package erchashu.xIansuohua;

public class Text {
	public static void main(String[] args) {
		
		Hero root = new Hero(1, "宋江");
		Hero hero2 = new Hero(3, "吴用");
		Hero hero3 = new Hero(6, "卢俊义");
		Hero hero4 = new Hero(8, "林冲");
		Hero hero5 = new Hero(10, "关胜");
		Hero hero6 = new Hero(14, "武松");
		root.setLeft(hero2);
		root.setRight(hero3);
		hero2.setLeft(hero4);
		hero2.setRight(hero5);
		hero3.setLeft(hero6);
		Tree binaryTree = new Tree();
		binaryTree.setRoot(root);	
	//	binaryTree.infixOrder();
	binaryTree.threadedNodes();
	Hero leftHero=hero5.getLeft();
	Hero leftHero2=hero5.getRight();
	System.out.println("当前结点的前驱结点是"+leftHero);
	System.out.println("当前结点的后继结点是"+leftHero2);
	binaryTree.threadList();
	}

}
