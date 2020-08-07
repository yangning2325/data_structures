package zhan;

import javax.management.RuntimeErrorException;

public class Stack {
	private int top=-1; //栈顶
	private int max;    //栈最大值
	private int[] stack;
	//构造器初始 化数组
	public Stack(int max) {
		this.max = max;
		this.stack=new int[max];
	}
	//判断为满
	public boolean full() {
		return top==max-1;
	}
	public boolean empty() {
		return top==-1;
		
	}
	public void push(int num) {
		if (full()) {
			System.out.println("栈已经满了！！");
			return;
		}
		top++;
		stack[top]=num;
	}
	public int pop() {
		if (empty()) {
			throw new RuntimeException("栈已经空了");
		}
		int value=stack[top];
		top--;
		return value;
	}
	public void show() {
		if (empty()) {
			System.out.println("栈为空！！");
			return;
		}
		for (int i = top; i >= 0; i--) {
			System.out.printf("stack[%d]=%d\n",i,stack[i]);
		}
		
	}
}
