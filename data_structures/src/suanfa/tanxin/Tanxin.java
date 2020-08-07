package suanfa.tanxin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Tanxin {

	public static void main(String[] args) {
		Map<String, HashSet<String>> broadcasts = new HashMap<String, HashSet<String>>();
		HashSet<String> hashSet1 = new HashSet<String>();
		hashSet1.add("北京");
		hashSet1.add("上海");
		hashSet1.add("天津");
		HashSet<String> hashSet2 = new HashSet<String>();
		hashSet2.add("广州");
		hashSet2.add("北京");
		hashSet2.add("深圳");
		HashSet<String> hashSet3 = new HashSet<String>();
		hashSet3.add("成都");
		hashSet3.add("上海");
		hashSet3.add("杭州");
		HashSet<String> hashSet4 = new HashSet<String>();
		hashSet4.add("上海");
		hashSet4.add("天津");
		HashSet<String> hashSet5 = new HashSet<String>();
		hashSet5.add("杭州");
		hashSet5.add("大连");
		broadcasts.put("K1", hashSet1);
		broadcasts.put("K2", hashSet2);
		broadcasts.put("K3", hashSet3);
		broadcasts.put("K4", hashSet4);
		broadcasts.put("K5", hashSet5);
		HashSet<String> allAreas = new HashSet<String>();
		allAreas.add("北京");
		allAreas.add("上海");
		allAreas.add("天津");
		allAreas.add("广州");
		allAreas.add("深圳");
		allAreas.add("成都");
		allAreas.add("杭州");
		allAreas.add("大连");
		//存放选择的电台集合
		ArrayList<String> selects = new ArrayList<String>();
		//定义临时集合，在遍历过程中，存放遍历过程中的电台覆盖的地区和没有覆盖的地区的交集
		HashSet<String> tempSet = new HashSet<String>();
		//定义给maxKey，保存在每一次遍历过程中，能够覆盖最大未覆盖的地区对应的电台Key
		//如果maxKey部位null，则会加入到selectes
		String maxKey=null; //如果maxkey不为null,则会加入到selects
		while (allAreas.size()!=0) { //如果不为0，则表示没有覆盖到所以地区
			//每进行一次需要把maxkey置空
			maxKey=null;
			for (String key : broadcasts.keySet()) {//keySet()获取map中的所有的key
				//每进行一次for清空tempset清空
				tempSet.clear();
				HashSet<String> areas = broadcasts.get(key);
				tempSet.addAll(areas);
				//求出tempset和allAreas集合的交集会赋给tempset
				tempSet.retainAll(allAreas);
				//如果当前这个集合包含的未覆盖地区的数量，比maxkey指向的集合还多，重置maxkey
				//体现出贪心算法特点，每次找最优
				if (tempSet.size()>0&&
						(maxKey==null||tempSet.size()>broadcasts.get(maxKey).size())) {
					maxKey=key;
					
				}
			}
			//此时加入到selects
			if (maxKey!=null) {
				selects.add(maxKey);
				//将maxkey指向的电台覆盖的地区，从allAeas去除
				allAreas.removeAll(broadcasts.get(maxKey));
				
			}
		}
		System.out.println("得到的选择结果"+selects);
	}

}
