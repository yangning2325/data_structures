package tu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Grap {
	ArrayList<String> list;
	int[][] arr;
	private int num;
	boolean[] isvisited;
	public Grap(int n) {
		arr = new int[n][n];
		list = new ArrayList<String>(n);
		num = 0;
		isvisited=new boolean[n];
	}

	// 返回顶点的个数
	public int nodes() {
		return list.size();
	}

	// 返回边的条数
	public int getNumofVertex() {
		return num;
	}

	// 返回顶点i（下标）对应的数据
	public String getvalue(int i) {
		return list.get(i);
	}

	// 返回两个顶点对应的权值
	public int getweight(int v1, int v2) {
		return arr[v1][v2];
	}

	public void list() {
		for (int[] a : arr) {
			System.out.println(Arrays.toString(a));
		}
	}

	// 插入节点
	public void insert(String s) {
		list.add(s);
	}

	/**
	 * @param v1     表示第一个点的下标
	 * @param v2     表示第二个点的下标
	 * @param weight 表示这两个顶点的关联关系表示
	 */
	public void insertEage(int v1, int v2, int weight) {
		arr[v1][v2] = weight;
		arr[v2][v1] = weight;
		num++;
	}
	//得到第一个邻接结点下标
	/**
	 * @param index
	 * @return 如果存在返回对应下标
	 */
	public int getfirstNeighbor(int index) {
		for (int i = 0; i < list.size(); i++) {
			if (arr[index][i]>0) {
				return i;
			}
		}
		return -1;
		
	}
	//根据前一个邻接结点下标获取下一个邻接结点
	public int getNextNeighbor(int v1,int v2) {
		for (int i = v2+1; i < list.size(); i++) {
			if (arr[v1][i]>0) {
				return i;
			}
		}
		return -1;
	}
	//深度优先遍历
	//i 第一次就是0
	public void dfs(boolean[] isVisted,int i) {
		//首先访问该结点
		System.out.print(getvalue(i)+"->");
		//将结点设置为已经访问
		isVisted[i]=true;
		//查找结点i的第一个邻接结点
		int w=getfirstNeighbor(i);
		while (w!=-1) { //说明有
			if (!isVisted[w]) {//判定是否已经访问过
				dfs(isVisted, w);
			}
			//如果w结点已经被访问，找下一个邻接点
			w=getNextNeighbor(i, w);
		}
	}
	//对dfs重载，遍历所有结点，并进行dfs
	public void dfs() {
		//遍历所有的结点，进行dfs（回溯）
		for (int i = 0; i < nodes(); i++) {
			if (!isvisited[i]) {
				dfs(isvisited, i);
			}
		}
	}
	//广度优先遍历
	public void bfs(boolean[] isvisited,int i) {
		int u; //表示队列的头结点
		int w; //表示邻接结点
		//队列，结点访问的顺序
		LinkedList<Integer> queue = new LinkedList<Integer>();
		//访问这个结点
		System.out.print(getvalue(i)+"->");
		isvisited[i]=true;
		//将结点加入队列
		queue.addLast(i);
		while (!queue.isEmpty()) {
			u=(Integer)queue.removeFirst();
			//得到第一个邻接结点的下标
			w=getfirstNeighbor(u);
			while (w!=-1) {//找到
				if (!isvisited[w]) {
					System.out.print(getvalue(w)+"->");
					isvisited[w]=true;
					//入队
					queue.addLast(w);
				}
				//寻找u的下一个邻接点
				w=getNextNeighbor(u, w);	//体现出广度优先		
			}
		}
	}
	//遍历所有结点进行广度优先遍历
	public void bfs() {
		for (int i = 0; i < nodes(); i++) {
			if (!isvisited[i]) {
				bfs(isvisited,i);
			}
		}
	}
}
