package suanfa.prim;

public class Graph {
	int verxs;
	char[] nodes;
	int[][] weight;
	public Graph(int verxs) {
		this.verxs = verxs;
		nodes=new char[verxs];
		weight=new int[verxs][verxs];
	}
	
}
