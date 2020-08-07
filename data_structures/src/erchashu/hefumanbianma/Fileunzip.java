package erchashu.hefumanbianma;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;

public class Fileunzip {
	public void unzip(String zipfile, String srcfile) throws Exception {
		FileInputStream is = new FileInputStream(zipfile);
		ObjectInputStream os = new ObjectInputStream(is);
		// 读取赫夫曼字节数组
		byte[] huffmanBytes = (byte[]) os.readObject();
		// 读取赫夫曼编码表
		HashMap<Byte, String> huffmanCodes = (HashMap<Byte, String>) os.readObject();
		Unzip jieya = new Unzip();
		// 解码
		byte[] decode = jieya.decode(huffmanCodes, huffmanBytes);
		// 创建输出流
		FileOutputStream fos = new FileOutputStream(srcfile);
		// 把文件写入到指定位置
		fos.write(decode);
		is.close();
		os.close();
		fos.close();
	}
}
