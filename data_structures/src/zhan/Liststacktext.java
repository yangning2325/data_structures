package zhan;

public class Liststacktext {

	public static void main(String[] args) {
		Liststack l1=new Liststack(1);
		Liststack l2=new Liststack(2);
		Liststack l3=new Liststack(3);
		Liststack l4=new Liststack(4);
	 //Liststack l5=new Liststack(5);
		Stack1 lis=new Stack1(4);
		lis.add(l1);
		lis.add(l2);
		lis.add(l3);
		lis.add(l4);
		
//		lis.pop();
//		lis.pop();
//		lis.pop();
		lis.pop();
		lis.show();

	}

}
