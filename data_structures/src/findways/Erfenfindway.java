package findways;

public class Erfenfindway {

	public static void main(String[] args) {
		int[] arr= {9,15,24,34,56,89};
		int index=find(arr,0,arr.length-1,5);
		if (index!=-1) {
			System.out.println("元素下标为"+index);
		}else {
			System.out.println("未找到！");
		}
	}

	private static int  find(int[] arr, int left, int right, int num) {
		if (left>right) {
			return -1;
		}
		int mid=(left+right)/2;
		int midnum=arr[mid];
		if (num>midnum) {
			return find(arr, mid+1,right, num);
		}
		else if (num<midnum) {
			return find(arr, left, mid-1, num);
		}else {
			return mid;
		}
			

		}		
	}


