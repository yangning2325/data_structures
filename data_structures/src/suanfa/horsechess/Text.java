package suanfa.horsechess;

public class Text {

	public static void main(String[] args) {
		int X=8; //列数
		int Y=8;//行数
		boolean[][] chessboard=new boolean[X][Y];
		for (int i = 0; i < chessboard.length; i++) {
			for (int j = 0; j < chessboard.length; j++) {
				System.out.print(chessboard[i][j]+" ");
			}
			System.out.println();
		}
		}
	}


