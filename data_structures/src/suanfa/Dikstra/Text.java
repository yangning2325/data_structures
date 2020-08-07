package suanfa.Dikstra;

public class Text {

	public static void main(String[] args) {
		char[] vertex= {'A','B','C','D','E','F','G'};
		int n=1000;
//		int[][] matrix= {{n,5,7,n,n,n,2},
//								{5,n,n,9,n,n,3},
//								{7,n,n,n,8,n,n},
//								{n,9,n,n,n,4,n},
//								{n,n,8,n,n,5,4},
//								{n,n,n,4,5,n,6},
//								{2,3,n,n,4,6,n}};
		int[][] matrix= {{n,5,2,n,n,n,n},
								{5,n,n,1,6,n,n},
								{2,n,n,6,n,8,n},
								{n,1,6,n,1,2,n},
								{n,6,n,1,n,n,7},
								{n,n,8,2,n,n,3},
								{n,n,n,n,7,3,n}};
		Graph graph = new Graph(vertex, matrix);
		graph.dsj(0);
	}

}
