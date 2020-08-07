package suanfa.prim;

import java.util.Arrays;

public class Text {

	public static void main(String[] args) {
		char[] nodes= {'A','B','C','D','E','F','G'};
		int verxs=nodes.length;
		int[][] weight= {{1000,5,7,1000,1000,1000,2},
									{5,1000,1000,9,1000,1000,3},
									{7,1000,1000,1000,8,1000,1000},
									{1000,9,1000,1000,1000,4,1000},
									{1000,1000,8,1000,1000,5,4},
									{1000,1000,1000,4,5,1000,6},
									{2,3,1000,1000,4,6,1000}};
		Graph graph = new Graph(verxs);
		MinTree minTree = new MinTree();
		Prim prim = new Prim();
		minTree.creatGraph(graph, verxs, weight, nodes);
		minTree.show(graph);
		prim.prim(0, graph);
	}

}
