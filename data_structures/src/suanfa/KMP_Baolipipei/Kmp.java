package suanfa.KMP_Baolipipei;

import java.util.Arrays;

public class Kmp {

	public static void main(String[] args) {
		String s1="bbc abcdab abcdabcdabde";
		String s2="abcdabd";
		int[] next = next(s2);
		int i = find(s1, s2, next);
		System.out.println(i);
	}
	public static int find(String s1,String s2,int[] next) {
		for (int i = 0,j=0; i < s1.length(); i++) {
			while (j>0&&s1.charAt(i)!=s2.charAt(j)) {
				j=next[j-1];
			}
			if (s1.charAt(i)==s2.charAt(j)) {
				j++;
			}
			if (j==s2.length()) {
				return i-j+1;
			}
		}
		return -1;
		
	}
	public static int[] next(String dest) {
	//保存匹配值
	int[] next=new int[dest.length()];
	next[0]=0; //如果字符串是长度为1部分值就是0；
	for (int i = 1,j=0; i < next.length; i++) {
		while (j>0&&dest.charAt(i)!=dest.charAt(j)) {
			j=next[j-1];
		}
		if (dest.charAt(i)==dest.charAt(j)) {
			j++;
		}
		next[i]=j;
	}
	return next;
	
}
}
