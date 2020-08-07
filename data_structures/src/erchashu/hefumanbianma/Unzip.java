package erchashu.hefumanbianma;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Unzip {

	/**
	 * @param flag     标志是否需要补高位如果是true，表示需要，false表示否.最后一个字符无需补高位
	 * @param b传入的byte
	 * @return 是该b对应的二进制的字符串（按补码返回）
	 */
	public String byteTobitString(boolean flag, byte b) {
		// 使用变量保存b
		int temp = b; // 将b转成int
		// 如果是正数我们还存在补高位
		if (flag) {
			temp |= 256; // 按位或256 1 0000 0000 | 0000 0001=> 1 0000 0001
		}
		String str = Integer.toBinaryString(temp);// 返回的是temp对应的二进制的补码
		if (flag) {
			return str.substring(str.length() - 8);
		} else {
			return str;
		}
	}

	/**
	 * @param huffmancodes 赫夫曼编码表map 32=01, 97=100, 100=11000, 117=11001, 101=1110,
	 * @param huffmanbytes 赫夫曼编码得到的字节数组 -88, -65, -56, -65, -56, -65, -55, 77, -57,
	 *                     6, -24, -14,
	 * @return
	 */
	public byte[] decode(HashMap<Byte, String> huffmancodes, byte[] huffmanbytes) {
		// 先得到huffmanbytes对应的二进制的字符串
		StringBuilder stringBuilder = new StringBuilder();
		// 将byte数组转成二进制的字符串
		for (int i = 0; i < huffmanbytes.length; i++) {
			byte b = huffmanbytes[i];
			// 判断是不是最后一个字节
			boolean flag = (i == huffmanbytes.length - 1);
			stringBuilder.append(byteTobitString(!flag, b));
		}
		// System.out.println(stringBuilder.toString());
		// 把字符串按照指定的赫夫曼编码进行解码
		// 把赫夫曼编码来进行调换，因为反向查询
		HashMap<String, Byte> hashMap = new HashMap<String, Byte>();
		for (Map.Entry<Byte, String> entry : huffmancodes.entrySet()) {
			hashMap.put(entry.getValue(), entry.getKey());
		}
		// System.out.println(hashMap);
		// 创建集合，存放byte；
		List<Byte> list = new ArrayList<>();
		// i可以理解为是索引，扫描stringBuilder
		for (int i = 0; i < stringBuilder.length();) {
			int count = 1; // 计数器
			boolean flag = true;
			Byte b = null;

			while (flag) {
				// 取出一个‘1’‘0’
				String key = stringBuilder.substring(i, i + count);// i不动，让count移动，直到匹配到一个字符
				b = hashMap.get(key);
				if (b == null) { // 说明没有匹配到
					count++;
				} else {
					flag = false;
				}
			}
			list.add(b);
			i += count; // i直接移动到count
		}
		// for循环结束后，我们list中就存放了所有的字符
		// 把list中的数据放入到byte[] 并返回
		byte[] b = new byte[list.size()];
		for (int i = 0; i < b.length; i++) {
			b[i] = list.get(i);
		}
		return b;

	}
}
