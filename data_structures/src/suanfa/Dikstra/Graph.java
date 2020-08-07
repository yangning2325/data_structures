package suanfa.Dikstra;

import java.util.Arrays;

public class Graph {
	char[] vertex; // 顶点数组
	int[][] matrix; // 邻接矩阵
	VisitedVertex v;
	public Graph(char[] vertex, int[][] matrix) {
		super();
		this.vertex = vertex;
		this.matrix = matrix;
	}

//显示图
	public void show() {
		for (int[] is : matrix) {
			System.out.println(Arrays.toString(is));
		}
	}
	//迪杰斯特拉算法
	public void dsj(int index) {
		v=new VisitedVertex(vertex.length, index);
		update(index);
		for (int i = 1; i < vertex.length; i++) {
			index=v.updateAre();//选择并返回新的访问顶点
			update(index);
		}
		System.out.println("访问过的顶点表");
		System.out.println(Arrays.toString(v.already_arr));
		System.out.println("距离表");
		System.out.println(Arrays.toString(v.dis));
		System.out.println("前驱表");
		System.out.println(Arrays.toString(v.pre_visited));
		System.out.println("每一个顶点到指定顶点的距离");
		showresult();
	}
	public void update(int index) {
		int len=0;
		//遍历邻接矩阵第index行
		for (int i = 0; i < matrix[index].length; i++) {
			//出发顶点到index顶点的距离+从index出发到 i 顶点的距离和
			len=v.getDis(index)+matrix[index][i];
			if (!v.in(i)&&len<v.getDis(i)) {
				v.updatePre(i, index); //更新顶点的前驱顶点
				v.updataDis(i, len);//跟新出发点到i 点的距离
			}
		}
	}
	public void showresult() {
		for (int i= 0; i < v.dis.length; i++) {			
			if (v.dis[i]!=1000) {
				System.out.print(vertex[i]+"("+v.dis[i]+")");
			}else {
				System.out.println("n");
			}
		}
	}
}
