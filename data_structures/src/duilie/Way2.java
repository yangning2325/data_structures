package duilie;

public class Way2 {
	//假设max=4；
	private int max;
	private int rear;		//表示最后一个元素后一个位置
	private int front;		//表示队列第一个元素
	private int[] arre;
	//创建队列构造器；
	public Way2(int maxsize) {
		
		max = maxsize;	//队列最大容量；
		rear = 0;				//列头；
		front = 0;			//列尾；
		arre =new int[max]; 	//用数组模拟队列；
	}
	//判断队列是否已满；
	public boolean full() {
		return (rear+1)%max==front;
	}
	//判断队列是否为空；
	public boolean empty() {
		return rear==front;
	}
	//往队列加数据；
	public void add(int n) {	
		if (full()) {
			System.out.println("队列已满！！");
			return;
		}
		arre[rear]=n;		//假设rear=2，此时已经加入了3个元素
		rear=(rear+1)%max;	//此时的rear=3，再进行判断时队列已满；也就是说max=4时，最多只能加3个
	}
	//取队列
	public int get() {
		if (empty()) {
			throw new RuntimeException("队列早已经空了！！！");
		}
		int v=arre[front];					//把front对应的值放在一个临时变量v；
		front=(front+1)%max;			//front后移，考虑取模
		return v;								//将临时变量返回；
	}
	//显示队列的所有数据；
	public void show() {
		if (empty()) {
			System.out.println("亲，队列是空队列！");
			return;
		}
		/* 假设数组[0,1,2,3]
		 * 假如max=4;rear=0;front=3;此时size为2
		 * (当调用add方法时数组为arre[0]（0为rear刚开始值），此时经过rear=(rear+1)%max，rear变成1)
		 * 也就是说size方法中的rear是经过递增后的rear；（1+4-3）%4=2
		 * i=3；i<3+2=5;3++; 
		 * 也就是说i只能取3  4  ；
		 * 3%4=3;4%4=0;
		 * arre[3]=n1;arre[0]=n2
		 */
		for (int i = front; i < front+size(); i++) {
			System.out.printf("arre[%d]=%d\n",i%max,arre[i%max]);
		}
	}
	//数组内元素个数
	private int size() {
		//假设（1+4-3）%4=2
		return (rear+max-front)%max;
	}
	//显示队列的头数据；
	public int head() {
		if (empty()) {
			throw new RuntimeException("队列早已经空了！！！");
		}
		return arre[front];
	}
}
