package suanfa.prim;

import java.util.Arrays;

public class MinTree {
	public void creatGraph(Graph graph, int verxs, int[][] weight, char[] nodes) {
		int i, j;
		for (i = 0; i < verxs; i++) {
			graph.nodes[i] = nodes[i];
			for (j = 0; j < verxs; j++) {
				graph.weight[i][j] = weight[i][j];
			}
		}
	}
	public void show(Graph graph) {
		for (int[] link:graph.weight) {
			System.out.println(Arrays.toString(link));
			
		}
	}
}
