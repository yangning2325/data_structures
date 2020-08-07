package xishusz;


import java.io.FileOutputStream;

import java.io.PrintStream;

public class Text01 {

	public static void main(String[] args) throws Throwable {
		System.setOut(new PrintStream(new FileOutputStream("D:\\javamax.txt"))); //打印到指定文件，不打印到控制台
		int[][] m=new int[8][8];
		int sum=0;
		m[1][3]=1;
		m[2][4]=2;
		m[3][6]=2;
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				if (m[i][j]!=0) {
					sum++;
				}
				System.out.print(m[i][j]+"    ");
			}
			System.out.println();
}
		System.out.println("元素的个数为 : "+sum);
		int[][] n=new int[sum+1][3];
		n[0][0]=8;		//表示原数组的行数
		n[0][1]=8;		//表示原数组的列数
		n[0][2]=sum;	//表示原数组中非0数字的个数
		int count=0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (m[i][j]!=0) {
					count++;
					n[count][0]=i;//稀疏数组中表示原数组中该值在第几行（横坐标）
					n[count][1]=j;//稀疏数组中表示原数组中该值在第几列（竖坐标）
					n[count][2]=m[i][j];//稀疏数组中表示原数组的值
				}
			
			}

}
		
		System.out.println("稀疏数组为~~~~");
		//遍历稀疏数组
		for (int i = 0; i < n.length; i++) {
		
				System.out.print(n[i][0]+"     "+n[i][1]+"    "+n[i][2]+"    ");
			
			System.out.println();
		}
		

		System.out.println("还原后的二维数组");
		int[][] m2=new int[n[0][0]][n[0][1]];
		//遍历一下稀疏数组的行数，从1开始
	for (int i = 1; i < n.length; i++) {
		m2[n[i][0]][n[i][1]]=n[i][2];
	}
	//遍历一下原二维数组
	for (int i = 0; i < m2.length; i++) {
		for (int j = 0; j < m2[i].length; j++) {
			System.out.print(m2[i][j]+"    ");
		}
		System.out.println();
	}
	}

}
