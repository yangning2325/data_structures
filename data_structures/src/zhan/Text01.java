package zhan;

import java.util.Stack;

public class Text01 {
//栈在java中的直接调用
	public static void main(String[] args) {
		Stack<String> stack=new Stack<String>();
		//向栈中添加内容
		stack.add("张三");	
		stack.add("李四");
		stack.add("王五");
		stack.add("杨宁");
		//进行遍历
		while (stack.size()>0) {
			System.out.println(stack.pop());//出栈
			
		}
	}

}
