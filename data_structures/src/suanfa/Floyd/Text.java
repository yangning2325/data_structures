package suanfa.Floyd;

public class Text {

	public static void main(String[] args) {
		char[] vertex= {'A','B','C','D','E','F','G'};
		final int n=1000;
		int[][] dis= {{0,5,7,n,n,n,2},
							{5,0,n,9,n,n,3},
							{7,n,0,n,8,n,n},
							{n,9,n,0,n,4,n},
							{n,n,8,n,0,5,4},
							{n,n,n,4,5,0,6},
							{2,3,n,n,4,6,0}};
		Graph graph = new Graph(dis, vertex);
		graph.floyd();
		graph.show();
	}
}
