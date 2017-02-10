package fj.woo.test;

public class QuickSort {
	public static void main(String[] args) {
		int[] a = {3,5,1,2,7,6,8,10};
		quickSort(a,0,a.length-1);
		print(a);
	}
	
	private static void quickSort(int a[], int left, int right){
		//递归结束
		if(left>right)
			return;
		
		int mark = a[left];
		int i = left;
		int j = right;
		//一次处理，直到哨兵相遇
		while(i<j){
			//1.从右向左找大于mark的数
			while(i<j&&a[j]<=mark)
				j--;
			//2.从左向右找小于mark的数
			while(i<j&&a[i]>=mark)
				i++;
			//3.交互位置
			if(i<j){
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}
		//4.最后交换mark和最后的数
		a[left] = a[i];
		a[i] = mark;
		
		//递归处理左边子数组
		quickSort(a, left, i-1);
		//递归处理右边子数组
		quickSort(a, i+1, right);
	}
	
	private static void print(int[] a){
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
