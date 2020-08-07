package suanfa.fingway;

public class Findway {

	public static void main(String[] args) {
		int arr[]= {1, 2 ,3 , 4 , 5 , 7};
		System.out.println(find(3, arr));
	}
public static int find(int n,int[] arr) {
	int left=arr[0];
	int right=arr.length-1;	
	while (left<=right) {
		int mid=(left+right)/2;
		if (arr[mid]==n) {
			return mid;
		}else if (arr[mid]<n) {
			left=mid+1;
		}else {
			right=mid-1;
		}
	}
	return -1;
}
}
