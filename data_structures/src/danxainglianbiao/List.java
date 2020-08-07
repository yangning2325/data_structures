package danxainglianbiao;

import java.util.Stack;

//定义一个链表类管理英雄
public class List {
	
	//先初始化一个头节点，头节点不能动,不存放具体数据；
		
		public Hero head=new Hero(0, " ", " ");
		//添加节点到单向链表中
		//当不考虑编号顺序时，找到当前链表的最后节点，找到这个节点的next指向新的节点；
		public void add(Hero h) {
			//因为head节点不能动，因此需要一个辅助变量temp;
			Hero temp=head;
			//遍历链表找到最后
			while (true) {
				//找到链表的最后
				if (temp.next==null) {
					break;
				}
				//如果没有找到最后，temp 后移
				temp=temp.next;
			}
			//当退出while循环时，temp指向链表的最后
			//将最后节点的next指向新的节点；
			temp.next=h;
		}
		//显示链表（遍历）
		int num=0;
		public void list() {
			//判断链表是否为空
			int i=0;
			if (head.next==null) {
				System.out.println("链表为空");
				return;
			}
			//因为头节点不能动，因此我们需要一个辅助变量来遍历；
			Hero temp=head.next;
			while (true) {
				i++;
				if (temp==null) {
					break;
				}
					//输出节点信息
				System.out.println(temp);
				//将temp后移
				
				temp=temp.next;
			}
			num=i-1;
			System.out.println("个数为"+(i-1));
		}
		//
		public void add2(Hero h) {
			//通过辅助变量找到添加位置，temp是位于添加位置的前一个节点，否则插入不了；
			
			Hero temp=head;
			boolean f=false;		//f 标志添加的编号是否存在，默认为false；
			while (true) {
			if (temp.next==null) {	//说明temp已经在链表的最后，也就是说添加的元素恰好在最后
				break;
			}
			if (temp.next.no>h.no) {//位置找到，就在temp的后面插入；
				break;
			}
			if (temp.next.no==h.no) {//说明添加的编号已存在
				f=true;
				break;
			}
				temp=temp.next; //后移遍历
			}
			if (f) { //判断f的值
				System.out.printf("%d英雄已经存在，不能重复添加！",h.no);
			}else {
				//将值插入到temp的后面
				h.next=temp.next;
				temp.next=h;
			}
		}
		//链表的修改
		//根据Hero的no来修改Hero的其他值，即Hero的no不能修改；
		public void updata(Hero h ) {
			//判定链表是否为空，若为空直接返回；
			if (head.next==null) {
				System.out.println("链表为空！！！");
				return;
			}
			//定义一个辅助变量temp指向head.next
			Hero temp=head.next;
			//做标记
			boolean b=false;
			while (true) {
				//已经遍历到链表的最后
				if (temp==null) {
					break;
				}
				//找到要修改的编号
				if (temp.no==h.no) {
					b=true;		//返回一个true
					break;
				}
				//后移
				temp=temp.next;
			}
			if (b) {
				temp.name=h.name;
				temp.nickname=h.nickname;
			}else {
				System.out.printf("没有找到编号为%d这个人物,不能修改\n",h.no);
			}
		}
		//链表的删除
		//思路：1.定义一个辅节点找到待删除节点的前一个节点；
		//			 2.比较时，比较的是temp.next.no与删除的no的比较
		public void del( int no) {
			
			Hero temp=head;
			boolean b=false;				//标志是否找到删除节点；

			while (true) {
				if (temp.next==null) {	//已经遍历到链表的最后；
					break;
				}
				if (temp.next.no==no) {	//找到要删除的节点
					b=true;
					break;
				}
			temp=temp.next;			//后移
			}
			if (b) {
				temp.next=temp.next.next;		//删除节点的操作
			}else {
				System.out.printf("你要删除的%d号不存在\n",no);
			}
		}
		//链表的查找
		public void find( int no) {
			Hero temp=head;
			boolean b=false;
			
			while(true) {
				if (temp.next==null) {
					break;
				}
				if (temp.no==no) {
					b=true;
					break;
				}
				temp=temp.next;
			}
			if (b) {
				System.out.printf("你所查找编号为%d的信息为:%s\n",no,temp);
			}else {
				System.out.printf("你要查找的编号%d不存在\n",no);
			}
		}
		//链表中节点个数
		
		public void num(Hero hero ) {
			Hero temp=hero.next;
			if (hero.next==null) {
				System.out.println("链表为空");
				return;
			}
			int i=0;
			 boolean b=true;
			 while(b) {
				 i++;
				 if (temp.next==null) {
					 b=false;
					break;
				}
				 temp=temp.next;
			 }
		
			 System.out.println("链表的个数为"+i);;
				
		}
		public void find2(int no1) {
			int i=num-no1+1;
			Hero temp=head.next;
			boolean b=false;
			while(true) {
				if (temp==null) {
					break;
				}
				if(no1<=0||no1>num) {
					break;
				}
				if (temp.no==i ){
					b=true;
					break;
				}
				temp=temp.next;
			}
			if (b) {
				System.out.printf("你所查找的倒数第%d个的信息为:%s\n",no1,temp);
			}else {
				System.out.printf("你要查找的倒数第%d个不存在\n",no1);
			}
		}
		//链表反转
		public void rever(Hero h) {
			Hero temp=head.next;
			Hero head2=new Hero(0, "", "");
			Hero n=null;			//指向当前节点的下一个节点；
			if (head.next==null||head.next.next==null) {
				//System.out.println("链表为空");
				return;
			}
			while (temp!=null) {
				n=temp.next;	//暂时保存当前节点大下一个节点
				temp.next=head2.next;	//	当前temp的下一个节点指向新链表的最前端的节点；
				//当前节点覆盖新链表的最前端的节点，此时该节点的下一个节点正是上一步的最前端节点
				//也就是上一步的代码
				head2.next=temp;	
				temp=n;
			}
			head.next=head2.next;
		}
		//用栈演示从尾到头打印链表
		public void reverprinf(Hero h) {
			if (head.next==null) {
				return;
			}
			 Stack<Hero> stack=new Stack<Hero>();
			Hero temp=head.next;
			//将链表的所有节点压入栈内
			while (temp!=null) {
				stack.add(temp);
				temp=temp.next; //遍历
			}
			//出栈
			while (stack.size()>0) {
				System.out.println(stack.pop()); //打印出栈内容
			}
		}
}
	

