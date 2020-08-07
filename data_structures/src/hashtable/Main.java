package hashtable;

public class Main {

	public static void main(String[] args) {
		Empy empy1=new Empy(1, "yn");
		Empy empy2=new Empy(1, "zr");
		Empy empy3=new Empy(2, "mn");
		Empy empy4=new Empy(2, "ly");
		Empy empy5=new Empy(3, "uk");
		Hashtable h=new Hashtable(5);
		h.add(empy1);
		h.add(empy2);
		h.add(empy3);
		h.add(empy4);
		h.add(empy5);
		h.findbyd(3);
		//h.list();
	}

}
