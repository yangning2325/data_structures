package findways;

import java.util.Arrays;

public class Chazhifindway {

	public static void main(String[] args) {
		int[] arr=new int[100];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=i+1;
		}
		int index=find(arr,0,arr.length-1,1000);
		//System.out.println(Arrays.toString(arr));
		if (index!=-1) {
			System.out.println("index="+index);
		}else {
			System.out.println("不存在！！");
		}
	}

	private static int find(int[] arr, int left, int right, int num) {
		//System.out.println("haha");
		if (left>right||num>arr[right]||num<arr[left]) {
			return -1;
		}
		int mid=left+(right-left)*(num-arr[left])/(arr[right]-arr[left]);
		int valmid=arr[mid];
		if (num>valmid) {
			return find(arr, mid+1, right, num);
		}else if (num<valmid) {
			return find(arr, left, mid-1, num);
		}
		return mid;
	}

}
