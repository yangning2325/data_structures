package erchashu.hefumanbianma;

import java.util.Arrays;
import java.util.List;

public class Text {

	public static void main(String[] args) {
		String s="i like like like java do you like a java";
		byte[] bytes=s.getBytes();
		Zip tree = new Zip();
		System.out.println("压缩前的长度"+bytes.length);
		byte[] hufuman = tree.hufumanzip(bytes);
		System.out.println(Zip.huffmanCodes);
		System.out.println("哈夫曼压缩后的："+Arrays.toString(hufuman)+"长度为"+hufuman.length);
		Unzip jieya = new Unzip();
		byte[] decode = jieya.decode(Zip.huffmanCodes, hufuman);
		System.out.println("原数组"+new String(decode));
	}

}
