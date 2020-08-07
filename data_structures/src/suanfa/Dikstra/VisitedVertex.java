package suanfa.Dikstra;

import java.util.Arrays;

public class VisitedVertex {
	//表示每个顶点是否访问过，1表示访问过，0表示未访问
	int [] already_arr;
	//每个下标对应的值为前一个顶点的下标，会动态更新
	int[] pre_visited;
	//记录出发顶点到其他所有顶点的距离，最后记录的是最短距离
	int[] dis;
	public VisitedVertex(int length,int index) {
		this.already_arr = new int[length];
		this.pre_visited = new int[length];
		this.dis = new int[length];
		this.already_arr[index]=1;//设置出发顶点被访问过
		//初始化dis数组
		Arrays.fill(dis, 1000);
		//设置出发点的距离为0
		this.dis[index]=0;
	}
	/**判断 index顶点是否被访问过
	 * @param index
	 * @return 如果访问，就返回true
	 */
	public boolean in(int index) {
		return already_arr[index]==1;
		
	}
	/**更新出发顶点到index顶点的距离
	 * @param index
	 * @param len 距离
	 */
	public void updataDis(int index,int len) {
		dis[index]=len;
	}
	/**更新顶点的前驱为index结点
	 * @param pre
	 * @param index
	 */
	public void updatePre(int pre,int index) {
		pre_visited[pre]=index;
	}
	/**返回出发顶点到index顶点的距离
	 * @param index
	 * @return
	 */
	public int getDis(int index) {
		return dis[index];
	}
	//继续选择并访问新的访问结点，如G结束后，A作为新的访问顶点
	public int updateAre() {
		int min=1000;
		int index=0;
		for (int i = 0; i < already_arr.length; i++) {
			if (already_arr[i]==0&&dis[i]<min) {
				min=dis[i];
				index=i;
			}
		}
		already_arr[index]=1;
		return index;
	}
}
