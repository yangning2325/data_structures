package suanfa.fenzhi;

public class Hannotower {
	static long n = 0;

	public static void main(String[] args) {

		hannoTower(3, 'A', 'B', 'C');
		System.out.println("一共挪动了" + n + "次");
	}

	public static void hannoTower(int num, char a, char b, char c) {
		n++;
		// 若只有一个盘
		if (num == 1) {
			System.out.println("第" + num + "个盘从" + a + "=>" + c);
		} else {
			// 如果num>=2情况，我们总是把整体看成两个盘，最下边的一个盘和上面的所有盘
			// 1.先把最上面所有盘A->B,移动过程会用到c
			hannoTower(num - 1, a, c, b);
			// 2.把最下边的盘A->C
			System.out.println("第" + num + "个盘从" + a + "=>" + c);
			// 3.把B塔的所有盘从B->C,移动过程使用到a
			hannoTower(num - 1, b, a, c);
		}
	}
}
