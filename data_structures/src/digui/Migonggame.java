package digui;


public class Migonggame {
	public static void main(String[] args) {
		int[][] map = new int[8][7];
		for (int i = 0; i < 7; i++) {
			//上下全部置为1
			map[0][i] = 1;
			map[7][i] = 1;
		}
		//左右全部置为1
		for (int i = 0; i < 8; i++) {
			map[i][0] = 1;
			map[i][6] = 1;
		}
		//1表示墙
		map[2][2]=1;
		map[3][3]=1;
		map[3][4]=1;
		map[2][4]=1;
		map[3][1]=1;
		map[5][5]=1;
		map[3][2]=1;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("小球走过的图");
		way(map, 1, 1);
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		}
	//map表示二维数组地图
	//i，j 表示小球起始位置
	public static boolean way(int[][]map, int i, int j) {
		if (map[6][5]==2) { //表示终点位置
			return true;
		}else {
			if (map[i][j]==0) {
				//按照下--右--上--左，策略走；
				map[i][j]=2; //表示通路
				if (way(map, i+1, j)) { //下走
					return true;
				}else if (way(map, i, j+1)) { //右走
					return true;
				}else if (way(map, i-1, j)) { //上走
					return true;
				}else if (way(map, i, j-1)) { //左走
					return true;
				}else {
					map[i][j]=3;    //表示已经走过但是走不通
					return false;
				}
			}else {
				return false;
			}
		}
		
 	}
}
