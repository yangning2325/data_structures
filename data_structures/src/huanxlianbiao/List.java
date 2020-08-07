package huanxlianbiao;

public class List {
	// 创建一个Frist节点默认为空；
	Boy first = null;

	public void add(int num) {
		if (num < 2) {
			System.out.println("个数太少了！！");
			return;
		}
		Boy temp = null;
		// 用for循环创捷环形链表
		for (int i = 1; i <= num; i++) {
			// 根据编号创建小孩节点
			Boy boy = new Boy(i);
			// 如果是第一个小孩
			if (i == 1) {
				first = boy;
				first.setNext(first); // 第一个小孩的next指向自身；
				temp = first;
			} else {
				temp.setNext(boy);
				boy.setNext(first);
				temp = boy; // 后移
			}
		}

	}
	// 显示

	public void show() {
		if (first == null) {
			System.out.println("链表为空");
			return;
		}
		Boy temp = first;
		while (true) {

			System.out.printf("这是第%d个小孩\n", temp.getNum());
			if (temp.getNext() == first) { // 遍历到最后了
				break;
			}
			temp = temp.getNext();// 后移
		}

	}

	/**
	 * @param size  表示最初小孩的个数
	 * @param start 表示从第几个小孩开始
	 * @param num   数几下小孩出列
	 */
	public void getboy(int size, int start, int num) {
		if (first == null || start < 1 || start > size) {
			System.out.println("你的输入有误");
			return;
		}
		Boy temp = first; // 定义一个辅助变量
		while (true) {
			if (temp.getNext() == first) { 			// 此时辅助变量指向first前一个节点
				break;
			}
			temp = temp.getNext(); 				// 后移
		}
		for (int i = 0; i < start - 1; i++) { // 找到开始的节点，让first和temp同时移动start-1次
			first = first.getNext();
			temp = temp.getNext();
		}

		while (true) {

			if (temp == first) {					 // 表示圈中只剩下最后一个小孩；
				break;
			}
			// 找到要出列的小孩，让first和temp同时移动num-1次
			for (int i = 0; i < num - 1; i++) {
				first = first.getNext(); 			// 此时的first指向了要出列的小孩
				temp = temp.getNext();
			}
			System.out.printf("出列的小孩为%d\n", first.getNum());
			first = first.getNext(); 				// 出列后小孩在列表中重新的序列
			temp.setNext(first);
		}
		System.out.printf("最后留在圈里的小孩是%d\n", first.getNum());
	}
}
