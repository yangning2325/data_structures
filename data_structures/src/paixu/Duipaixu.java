package paixu;

import java.util.Arrays;

public class Duipaixu {

	public static void main(String[] args) {
		int[] arr= {4,6,8,5,9};
		headsort(arr);

	}

	private static void headsort(int[] arr) {
		int temp=0;
		for (int i = arr.length/2-1; i >=0; i--) {
			gethead(arr, i, arr.length);
		}
		
		for (int j = arr.length-1; j >0; j--) {
			//将堆顶元素与末尾元素进行位置交换		
			temp=arr[j];
			arr[j]=arr[0];
			arr[0]=temp;
			System.out.println(Arrays.toString(arr));
			gethead(arr, 0, j);
			//System.out.println(Arrays.toString(arr));
		}
		//System.out.println(Arrays.toString(arr));
	}
/**
 * @param arr 待调整的数组
 * @param i 表示非叶子结点在数组中的索引
 * @param length 表示多少个元素待调整，length是逐渐减少的
 */
public static void gethead(int[] arr,int i,int length) {
	//当前非叶子结点的保存在一个临时指针
		int temp=arr[i];
		//k为非叶子结点的左子结点，k=2*k+1表示以该结点为父节点的左子结点
		for (int k = 2*i+1; k < length; k=2*k+1) {
			//非叶子结点不能大于数组的长度，并且左子结点小于右子结点时
			//k指向右子结点
			if (k+1<length&&arr[k]<arr[k+1]) {
				k++;
			}
			//k指向的当前这个子结点大于其父结点时
			//把当前值赋给父结点，并且将k指向父结点的位置
			if (arr[k]>temp) {
				arr[i]=arr[k];
				i=k;
			}else {
				break;
			}
		}
		//循环结束时我们已经把以i为父结点的最大值放在最顶端
		arr[i]=temp;//把temp放在调整后的位置；
		//System.out.println(Arrays.toString(arr));
	}

}
