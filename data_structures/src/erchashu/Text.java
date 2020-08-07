package erchashu;

public class Text {
	public static void main(String[] args) {
		Tree binaryTree = new Tree();
		Hero root = new Hero(1, "宋江");
		Hero hero2 = new Hero(2, "吴用");
		Hero hero3 = new Hero(3, "卢俊义");
		Hero hero4 = new Hero(4, "林冲");
		Hero hero5 = new Hero(5, "关胜");
		root.setLeft(hero2);
		root.setRight(hero3);
		hero3.setRight(hero4);
		hero3.setLeft(hero5);
		binaryTree.setRoot(root);
		System.out.println("删除前");
		binaryTree.preOrder();
		binaryTree.delnum(5);
//	System.out.println("前序遍历");
		System.out.println("删除后");
		binaryTree.preOrder();
//	System.out.println("中序遍历");
//	binaryTree.infixOrder();
//	System.out.println("后序遍历");
//	binaryTree.postOrder();
//		System.out.println("前序查找");
//		Hero presearch = binaryTree.presearch(5);
//		if (presearch != null) {
//			System.out.printf("找到了no=%d name=%s \n", presearch.getNo(), presearch.getName());
//		} else {
//			System.out.println("没有找到");
//		}
//		System.out.println("中序查找");
//		Hero infixsearch = binaryTree.infixsearch(5);
//		if (presearch != null) {
//			System.out.printf("找到了no=%d name=%s \n", infixsearch.getNo(), infixsearch.getName());
//		} else {
//			System.out.println("没有找到");
//		}
//		System.out.println("后序查找");
//		Hero postsearch = binaryTree.postsearch(5);
//		if (presearch != null) {
//			System.out.printf("找到了no=%d name=%s \n", postsearch.getNo(), postsearch.getName());
//		} else {
//			System.out.println("没有找到");
//		}
	}

}
