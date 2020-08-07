package suanfa.kelusikaer;

import java.util.Arrays;

public class Graph {
	EData eData;
	int edgeNum; //边的个数
	char[] vertexs; //顶点数组
	int[][] matrix; //邻接矩阵
	static final  int INF=Integer.MAX_VALUE; //表示两个顶点不能连通
	//统计边
	public Graph(char[] vertexs, int[][] matrix) {
		int vlen=vertexs.length;
		this.vertexs = vertexs;
		this.matrix = matrix;
		for (int i = 0; i < vlen; i++) {
			for (int j = i+1; j <vlen; j++) {
				if (this.matrix[i][j]!=INF) {
					edgeNum++;
				}
			}
		}
	}
	public void show() {
		System.out.println("邻接矩阵为：");
		for (int i = 0; i < vertexs.length; i++) {
			for (int j = 0; j < vertexs.length; j++) {
				System.out.printf("%15d\t",matrix[i][j]);
			}
			System.out.println();
		}
	}
	//排序
	public void sort(EData[] eDatas) {
		for (int i = 0; i < eDatas.length-1; i++) {
			for (int j = 0; j < eDatas.length-i-1; j++) {
				if (eDatas[j].weight>eDatas[j+1].weight) {
					EData t=eDatas[j];
					eDatas[j]=eDatas[j+1];
					eDatas[j+1]=t;
				}
			}
		}
	}

	/**
	 * @param ch 顶点的值
	 * @return 返回顶点对应的下标
	 */
	public int getPostition(char ch) {
		for (int i = 0; i < vertexs.length; i++) {
			if (vertexs[i]==ch) {
				return i;
			}
		}
		return -1;
	}
	//获取图中边，放到EData[]数组中
	/**
	 * @return EData[] 形式为['A','B',12]
	 */
	public EData[] getEdges() {
		int index=0;
		EData[] edges=new EData[edgeNum];
		for (int i = 0; i < vertexs.length; i++) {
			for (int j =i+1; j < vertexs.length; j++) {
				if (matrix[i][j]!=INF) {
					edges[index++]=new EData(vertexs[i], vertexs[j], matrix[i][j]);
					
				}
			}
		}
		return edges;
	}
	/**
	 * @param ends 数组就是记录各个顶点的终点是哪个，ends数组是在遍历过程中逐步形成
	 * @param i 表示传入的顶点对应的下标
	 * @return 返回的就是下标为i 的这个顶点对应的终点的下标
	 */
	//获取下标为i的顶点的终点，用于后面判断两个顶点是否相同
	public int getend(int[] ends,int i) {
		while (ends[i]!=0) {
			i=ends[i];
		}
		return i;
	}
	public void Kruskal() {
		int index=0; //表示最后数组结果的索引
		int[] ends=new int[edgeNum];//用于保存已有最小生成树的每个顶点在最小生成树的终点
		//创建结果数组，保存最后的最小生成树
		EData[] rets=new EData[edgeNum];
		//获取图中所有边的集合，共12条
		EData[] edges=getEdges();
		//按照边的权值大小进行排序
		sort(edges);
		//遍历edges数组，将边添加到最小生成树中时，判断是准备加入的边是否形成了回路
		//如果没有就加入rets数组，否则不能加入
		for (int i = 0; i < edgeNum; i++) {
			//获取到第i条边的第一个顶点(起点)
			int p1=getPostition(edges[i].start);
			//获取到第i条边的第2个顶点
			int p2=getPostition(edges[i].end);
			//获取p1这个顶点在已有最小生成树中的终点
			int m=getend(ends, p1);
			//获取p2这个顶点在已有最小生成树中的终点
			int n=getend(ends, p2);
			//是否构成回路
			if (m!=n) {//没有构成回路
				ends[m]=n;//设置m在已有最小生成树的终点
				rets[index++]=edges[i];//有一条边到rets
			}
		}
		System.out.println("最小生成树");
		for (int i = 0; i < index; i++) {
			//输出rets
			System.out.println(rets[i]);
		}
	
	}
}
