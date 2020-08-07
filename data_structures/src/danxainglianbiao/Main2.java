package danxainglianbiao;

import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		boolean b=true;
		List list=new List();
		while (b) {
			System.out.println("~~~~~~~~~~~~~~水浒英雄~~~~~~~~~~~~~~~");
			System.out.println("1.添加英雄");
			System.out.println("2.查找英雄");
			System.out.println("3.显示全部英雄");
			System.out.println("4.修改英雄");
			System.out.println("5.删除英雄");
			System.out.println("6.退出程序");
			System.out.print("请输入你要选择的功能：");
			Scanner in=new Scanner(System.in);
			int num=in.nextInt();
			switch (num) {
			case 1:
				
				Scanner x=new Scanner(System.in);
				System.out.print("请输入要添加英雄的编号：");
				int no=x.nextInt();
				
				Scanner y=new Scanner(System.in);
				System.out.print("请输入要添加英雄的名字：");
				String name=y.next();
				
				Scanner z=new Scanner(System.in);
				System.out.print("请输入要添加英雄的昵称：");
				String nickname=z.next();
				Hero h=new Hero(no, name, nickname);
				list.add2(h);
				System.out.println("你添加的英雄为"+h);
				break;

			case 2:
				Scanner n=new Scanner(System.in);
				System.out.print("请输入要添加英雄的编号：");
				int num1=n.nextInt();
				list.find(num1);
				break;
			case 3:
				list.list();
				break;
			case 4:
				Scanner x1=new Scanner(System.in);
				System.out.print("请输入要修改英雄的编号：");
				int no1=x1.nextInt();
				
				Scanner y1=new Scanner(System.in);
				System.out.print("请输入要修改英雄的名字：");
				String name1=y1.next();
				
				Scanner z1=new Scanner(System.in);
				System.out.print("请输入要修改英雄的昵称：");
				String nickname1=z1.next();
				Hero h1=new Hero(no1, name1, nickname1);
				list.updata(h1);
				break;
			case 5:
				Scanner n2=new Scanner(System.in);
				System.out.print("请输入要删除的英雄编号：");
				int num2=n2.nextInt();
				list.del(num2);
				break;
			case 6:
				b=false;
				break;
			default:
				System.out.println("你的输入有误，请从新输入！！");
				break;
			}

			
		}
		System.out.println("程序已退出，欢迎下次使用~~");
	}

}
