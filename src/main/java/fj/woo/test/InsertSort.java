package fj.woo.test;

public class InsertSort {
	public static void main(String[] args) {
		int[] a = {1,7,3,5,6,4,2,3,6,35,6,23,16,78};
		for (int i = 1; i < a.length; i++) {
			int currentValue = a[i];
			int j=i-1;
			while(j>0&&a[j]>currentValue){
				a[j+1] = a[j];
				j--;
			}
			
			a[j+1] = currentValue;
		}
		
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
