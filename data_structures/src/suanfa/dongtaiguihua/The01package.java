package suanfa.dongtaiguihua;

public class The01package {

	public static void main(String[] args) {
	int[] w= {1,4,3};
	int[] var= {1500,3000,2000} ;
	int m=9;
	int n=var.length;
	int[][] v=new int[n+1][m+1] ;
	//记录存放情况
	int[][] path=new int[n+1][m+1];
	//初始化第一行和第一列为0；
	for (int i = 1; i < v.length; i++) {
			v[i][0]=0;
	}
	for (int i = 0; i < v[0].length; i++) {
		v[0][i]=0;
	}
	for (int i = 1; i < v.length; i++) {
		for (int j = 1; j < v[0].length; j++) {
			//因为i是从1开始的所以w[i-1];
			if (j<w[i-1]) {
				v[i][j]=v[i-1][j];
			}else {
				if (v[i-1][j]>var[i-1]+v[i-1][j-w[i-1]]) {
					v[i][j]=v[i-1][j];
				}else {
					v[i][j]=var[i-1]+v[i-1][j-w[i-1]];
					path[i][j]=1;
				}
			}
		}
	}
	for (int i = 0; i < v.length; i++) {
		for (int j = 0; j < v[i].length; j++) {
			System.out.print(v[i][j]+" ");
		}
		System.out.println();
	}
	int i=path.length-1;//行和列的最大下标
	int j=path[0].length-1;
	while (i>0&&j>0) {
		if (path[i][j]==1) {
			System.out.println("第"+i+"个商品放入背包");
			j=j-w[i-1];
		}
		i--;
	}
}

}
