package suanfa.KMP_Baolipipei;

public class Baolipipei {

	public static void main(String[] args) {
		String str1="我叫杨宁啊";
		String str2="杨宁";
		int i = find(str1, str2);
		System.out.println(i);
		//System.out.println(str1.indexOf(str2));
	}
public static int find(String str1,String str2) {
	char[] c1=str1.toCharArray();
	char[] c2=str2.toCharArray();
	int len1=c1.length;
	int len2=c2.length;
	int i=0;
	int j=0;
	while (i<len1&&j<len2) {
		if (c1[i]==c2[j]) {
			i++;
			j++;
		}else {
			i=i-(j-1);
			j=0;
		}
	}
	if (j==len2) {
		return i-j;
	}else {
		return -1;
	}

}
}
