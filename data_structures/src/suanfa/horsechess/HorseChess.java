package suanfa.horsechess;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Comparator;

public class HorseChess {
	static int X ; // 列数
	static int Y ;// 行数
	static boolean[][] visits;
	//static boolean[] visited; // 标记棋盘的各个位置是否被访问
	static boolean finished;// 标记棋盘的所有位置是否被访问
	public static void main(String[] args) {
		 X=8; //列数
		 Y=8;//行数
		int row=1;
		int column=1;
		int[][] chessboard=new int[X][Y];
		visits=new boolean[X][Y];
		//visited=new boolean[X *Y];
		long start = System.currentTimeMillis();
		traversal(chessboard, row-1, column-1, 1);
		long end = System.currentTimeMillis();
		System.out.println("用了"+(end-start)+"毫秒");
		//输出棋盘
		for (int[] rows : chessboard) {
			for (int step : rows) {
				System.out.print(step+"\t");
			}
			System.out.println();
		}
	}
	public static void traversal(int[][] chessboard, int row, int column, int step) {
		chessboard[row][column] = step;
		//visited[row * X + column] = true; // 标记该位置已经访问
		visits[row][column]=true;
		// 获取当前位置可以走的下一个位置的集合
		ArrayList<Point> ps = next(new Point(column, row));
		sort(ps);
		// 遍历集合
		while (!ps.isEmpty()) {
			Point p = ps.remove(0);
			//if (!visited[p.y * X + p.x]) {// 说明没有访问过
				if (!visits[p.y][p.x]) {
					
				
				traversal(chessboard, p.y, p.x, step + 1);
			}
		}
		// 判断是否完成了任务，使用step和应该走的步数进行比较
		// 如果没有达到数量，则表示没有完成任务，将整个棋盘置0
		// step<X*Y&&!finished
		// 1.棋盘到目前位置，仍没有走完
		// 2.棋盘处于一个回溯过程
		if (step < X * Y && !finished) {
			chessboard[row][column] = 0;
			//visited[row * X + column] = false;
			visits[row][column]=false;
		} else {
			finished = true;
		}
	}

	/**
	 * 根据当前位置，计算马儿还能走哪些位置，并放入集合中
	 * 
	 * @param cutPoint
	 * @return
	 */
	public static ArrayList<Point> next(Point cutPoint) {
		ArrayList<Point> ps = new ArrayList<Point>();
		Point p1 = new Point();
		// 1
		if ((p1.x = cutPoint.x - 2) >= 0 && (p1.y = cutPoint.y - 1) >= 0) {
			ps.add(new Point(p1));
		}
		// 2
		if ((p1.x = cutPoint.x - 1) >= 0 && (p1.y = cutPoint.y - 2) >= 0) {
			ps.add(new Point(p1));
		}
		// 3
		if ((p1.x = cutPoint.x + 1) < X && (p1.y = cutPoint.y - 2) >= 0) {
			ps.add(new Point(p1));
		}
		// 4
		if ((p1.x = cutPoint.x + 2) < X && (p1.y = cutPoint.y - 1) >= 0) {
			ps.add(new Point(p1));
		}
		// 5
		if ((p1.x = cutPoint.x + 2) < X && (p1.y = cutPoint.y + 1) < Y) {
			ps.add(new Point(p1));
		}
		// 6
		if ((p1.x = cutPoint.x + 1) <X && (p1.y = cutPoint.y + 2) < Y) {
			ps.add(new Point(p1));
		}
		// 7
		if ((p1.x = cutPoint.x - 1) >= 0 && (p1.y = cutPoint.y + 2) < Y) {
			ps.add(new Point(p1));
		}
		// 8
		if ((p1.x = cutPoint.x - 2) >= 0 && (p1.y = cutPoint.y + 1) < Y) {
			ps.add(new Point(p1));
		}

		return ps;

	}
	public static void sort(ArrayList<Point>ps) {
		ps.sort(new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				int i = next(o1).size();
				int j = next(o2).size();
				return i-j;
			}
		});
	}
}
