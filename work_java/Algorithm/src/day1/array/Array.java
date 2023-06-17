package day1.array;

import java.util.Arrays;

public class Array {

	public static void main(String[] args) {
		int[] ar = { 100, 200, 300, 400, 500 };
		System.out.println(ar[2]);
		ar[3]=999;
		System.out.println(Arrays.toString(ar));
		Arrays.sort(ar);
		System.out.println(Arrays.toString(ar));
		
		int[][] arr= {{1,2,3},{4,5,6},{7,8,9}};
		
		arr[1][1]=999;
		System.out.println(Arrays.toString(arr[1]));
		System.out.println(Arrays.deepToString(arr));
	}

}
