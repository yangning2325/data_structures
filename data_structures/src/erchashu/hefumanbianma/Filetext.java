package erchashu.hefumanbianma;

public class Filetext {

	public static void main(String[] args) throws Exception {
		Filezip filezip = new Filezip();
		String s1="E:\\1.txt";
		String s2="E:\\2.zip";
		filezip.filezip(s1, s2);
		System.out.println("压缩成功");
//		Fileunzip fileunzip = new Fileunzip();
//		String sr1="E:\\2.zip";
//		String sr2="E:\\3.txt";
//		fileunzip.unzip(sr1, sr2);
//		System.out.println("解压成功");
	}

}
