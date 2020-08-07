package duilie;

import java.util.Random;
import java.util.Scanner;

public class Text {

	public static void main(String[] args) {
		Ways m=new Ways(5);
		char key=' ';
		Scanner s=new Scanner(System.in);
		boolean loop=true;
		while (loop) {
			System.out.println("a(show)~显示数据");
			System.out.println("b(add)~增加数据");
			System.out.println("c(head)~显示头数据");
			System.out.println("d(get)~取出数据");
			System.out.println("e(exit)~退出程序");
			key=s.next().charAt(0);
			switch (key) {
			case 'a':
				m.show();
				break;
			case 'b':
				System.out.println("请输入一个数！");
				Scanner sr=new Scanner(System.in);
				int i=sr.nextInt();
				m.add(i);
				break;
			case 'c':
				try {
					int x=m.head();
					System.out.println("队列的头数据是："+x);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'd':
				try {
					int y=m.get();
					System.out.println("取出的数据是："+y);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'e':
				loop=false;
				s.close();
				break;
			default:
				break;
			}	
		}
		System.out.println("程序已退出！");
	}
	
}
