package erchashu.hefumanbianma;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Zip {
	//用来存放赫夫曼编码
	static HashMap <Byte, String>huffmanCodes=new HashMap<Byte, String>();
	//进行字符串拼接
	static StringBuilder stringBuilder=new StringBuilder();
	
	//5.把所有方法封装到一块方便调用
	public byte[] hufumanzip(byte[] bytes) {
		List<Node> hufullList = hufullList(bytes);
		//根据hufullList创建哈夫曼树
		Node findNode = findNode(hufullList);
		//对应的哈夫曼编码
		HashMap<Byte, String> codes = getCodes(findNode);
		//根据赫夫曼编码，得到压缩后的哈夫曼编码
		byte[] zip = zip(bytes, codes);
		return zip;
		
	}
	
	// 1.接收一个字符数组并统计每个字符出现的次数
	public List<Node> hufullList(byte[] bytes) {
		// 创建链表用于存储结点
		ArrayList<Node> list = new ArrayList<Node>();
		// 创建哈希表存放带有键值的结点
		HashMap<Byte, Integer> map = new HashMap<>();
		for (byte b : bytes) {
			// 获取键值的value值
			Integer count = map.get(b);
			// 对value值进行计数
			if (count == null) {
				map.put(b, 1);
			} else {
				map.put(b, count+1);
			}
		}
		// 对哈希表进行遍历取出键值对
		for (Map.Entry<Byte, Integer> entry : map.entrySet()) {
			list.add(new Node(entry.getKey(), entry.getValue()));
		}
		return list;
	}
	

	// 2.转化成哈夫曼树
	public Node findNode(List<Node> list) {
		while (list.size() > 1) {
			Collections.sort(list);
			Node leftNode = list.get(0);
			Node rightNode = list.get(1);
			Node root = new Node(null, leftNode.value + rightNode.value);
			root.left = leftNode;
			root.right = rightNode;
			list.remove(leftNode);
			list.remove(rightNode);
			list.add(root);
		}
		return list.get(0);

	}
	
	//3.重载getCodes（）方法方便调用
	public HashMap<Byte, String> getCodes(Node node) {
		if (node==null) {
			return null;
		}
		getCodes(node, "", stringBuilder);
		return huffmanCodes;
	}
	
	//3.创建哈夫曼表每个字符用它对应的哈夫曼编码表示（每个叶子结点的路径码）
	public void getCodes(Node node,String code,StringBuilder stringBuilder) {
		StringBuilder builder=new StringBuilder(stringBuilder);
		builder.append(code);
		if (node!=null) {//为空结点
			//判断是叶子节点还是非叶子结点
			if (node.data==null) {
				//向左递归处理
				getCodes(node.left, "0", builder);
				//向右递归
				getCodes(node.right, "1", builder);
			}else {
				//表示到达叶子结点，放入map中
				huffmanCodes.put(node.data, builder.toString());
			}
		}
	}
	
	//4.对哈夫曼编码转化为byte字符进行压缩
	/**
	 * @param bytes 原始字符串对应的byte[]
	 * @param hufullmancodes 生成哈夫曼编码map
	 * @return 返回赫夫曼编码后的byte[];
	 */	
	public byte[] zip(byte[] bytes,HashMap <Byte, String>hufullmancodes) { 
		StringBuilder stringBuilder=new StringBuilder();
		for (byte b : bytes) {
			stringBuilder.append(hufullmancodes.get(b));
		}
		//System.out.println("赫夫曼编码"+stringBuilder);
		//return bytes;
		//统计返回的byte[] 的长度
		int len;
		if (stringBuilder.length()%8==0) {
			len=stringBuilder.length()/8;
		}else {
			len=stringBuilder.length()/8+1;
		}
		//创建压缩后的byte数组
		byte[] by=new byte[len];
		//因为一个八位的二进制数构成一个byte字节
		int index=0;//记录byte[]数组的下标
		for (int i = 0; i < stringBuilder.length(); i+=8) {
			String strByte;
			if (i+8>stringBuilder.length()) {//不够八位
				strByte=stringBuilder.substring(i);	
			}else {
				
				strByte=stringBuilder.substring(i,i+8);
			}
			//将strByte转成一个byte，放入到by；
			by[index]=(byte) Integer.parseInt(strByte,2);
			index++;
		}
		return by;
	}
}
