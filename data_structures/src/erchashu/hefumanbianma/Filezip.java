package erchashu.hefumanbianma;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Filezip {

	public void filezip(String srcFile, String dstFile) throws Exception {
	
				//创建文件输入流
				FileInputStream is = new FileInputStream(srcFile);		
			//创建byte数组；
			byte[] bytes=new byte[is.available()];		
			is.read(bytes);
			Zip zip = new Zip();
			byte[] hufumanzip = zip.hufumanzip(bytes);
			//创建文件输出流
			FileOutputStream os=new FileOutputStream(dstFile);	
			//创建一个对象输出流
			ObjectOutputStream oos=new ObjectOutputStream(os);	
			//把赫夫曼编码后的字节数组写入压缩文件
			oos.writeObject(hufumanzip);
			//把赫夫曼编码写入压缩文件
			oos.writeObject(Zip.huffmanCodes);
			is.close();
			os.close();
			oos.close();
	}
}
