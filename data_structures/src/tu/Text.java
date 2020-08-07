package tu;

public class Text {

	public static void main(String[] args) {
		int n=8;
		Grap grap = new Grap(n);
		String[] str= {"1","2","3","4","5","6","7","8"};
		for (String string : str) {
			grap.insert(string);
	}
		//添加边
		//a-b a-c b-c b-d b-e
		grap.insertEage(0, 1, 1);
		grap.insertEage(0, 2, 1);
		grap.insertEage(1, 3, 1);
		grap.insertEage(1, 4, 1);
		grap.insertEage(3, 7, 1);
		grap.insertEage(4, 7, 1);
		grap.insertEage(2, 5, 1);
		grap.insertEage(2, 6, 1);
		grap.insertEage(5, 6, 1);
		grap.list();
		
//		System.out.println("深度遍历");//1->2->4->8->5->3->6->7->
//		grap.dfs();
		System.out.println("广度优先");//1->2->3->4->5->6->7->8->
		grap.bfs();
	}
}
