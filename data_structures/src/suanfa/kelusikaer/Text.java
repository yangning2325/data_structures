package suanfa.kelusikaer;

import java.util.Arrays;

public class Text {
	static final  int INF=Integer.MAX_VALUE;
	public static void main(String[] args) {
		char[] vertexs= {'A','B','C','D','E','F','G'};
		int[][] matrix= {{0,12,INF,INF,INF,16,14},
								{12,0,10,INF,INF,7,INF},
								{INF,10,0,3,5,6,INF},
								{INF,INF,3,0,4,INF,INF},
								{INF,INF,5,4,0,2,8},
								{16,7,6,INF,2,0,9},
								{14,INF,INF,INF,8,9,0}};
		Graph graph = new Graph(vertexs, matrix);
		graph.show();
		EData[] edges = graph.getEdges();
		System.out.println(Arrays.toString(edges));
		graph.sort(edges);
		System.out.println("排序后");
		System.out.println(Arrays.toString(edges));
		graph.Kruskal();
	}

}
