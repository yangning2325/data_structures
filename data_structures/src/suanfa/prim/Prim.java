package suanfa.prim;

public class Prim {
	/**
	 * @param v 表示第几个顶点开始
	 * @param graph 图
	 */
	public void prim(int v ,Graph graph) {
		//标记是否被访问
		int[] visted=new int[graph.verxs];
		//把当前这个顶点标记为已访问
		visted[v]=1;
		int min=1000;//用一个很大的数初始化为最小值
		//用来标记顶点下标
		int h1=-1;
		int h2=-1;
		//因为有graph.verxs个顶点算法结束后会有graph.verxs-1条边
		for (int k = 1; k < graph.verxs; k++) {
			for (int i = 0; i < visted.length; i++) {
				for (int j = 0; j < visted.length; j++) {
					//visted[i]==1表示已访问的visted[j]==0未访问的
					if (visted[i]==1&&visted[j]==0&&graph.weight[i][j]<min) {
						//替换最小权值
						min=graph.weight[i][j];
						//记录最小值下标
						h1=i;
						h2=j;
					}
				}
			}
			System.out.println("<"+graph.nodes[h1]+","+graph.nodes[h2]+">的权值为"+min);
			//每循环一次把最小值再置换成一个大数
			min=1000;
			//把权值最小的那个值标记为已访问
			visted[h2]=1;
		}
	}
}
