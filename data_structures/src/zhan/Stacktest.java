package zhan;

public class Stacktest {

	public static void main(String[] args) {
		Stack s=new Stack(4);
		s.push(5);
		s.push(6);
		s.push(2);
		s.push(8);
		s.show();
		for (int i = 0; i < 3; i++) {
			s.pop();
		}
		s.show();
	}

}
