package suanfa.Floyd;

import java.util.Arrays;

public class Graph {
	int[][] dis; //距离表
	int[][] pre; //前驱表
	char[] vertex; //顶点数组

	public Graph(int[][] dis, char[] vertex) {
		super();
		this.dis = dis;
		this.vertex = vertex;
		this.pre = new int[vertex.length][vertex.length];
		for (int i = 0; i < vertex.length; i++) {
			Arrays.fill(pre[i], i);
		}
	}

	public void show() {
		System.out.println("距离表");
		for (int i = 0; i < dis.length; i++) {
			for (int j = 0; j < dis.length; j++) {
				System.out.printf("%6s->%s[%4d]", vertex[i], vertex[j], dis[i][j]);
			}
			System.out.println();
		}
		System.out.println(
				"----------------------------------------------------------------------------------------------------------------------");
		System.out.println("前驱表");
		for (int i = 0; i < dis.length; i++) {
			for (int j = 0; j < dis.length; j++) {
				System.out.printf("%6s->%s (%s)", vertex[i], vertex[j],vertex[pre[i][j]]);
			}
			System.out.println();
		}
	}
//弗洛伊德算法
	public void floyd() {
		int len;
		for (int k = 0; k < dis.length; k++) { //中间顶点
			for (int i = 0; i < dis.length; i++) { //起始顶点
				for (int j = 0; j < dis.length; j++) { //终点
					len = dis[i][k] + dis[k][j];
					if (len < dis[i][j]) { 
						//更新表
						dis[i][j] = len;
						pre[i][j] = pre[k][j];
					}
				}
			}
		}
	}
}
