package day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class SelectionSort {

	static int[] arr = { 7, 2, 8, 1, 6, 3, 5 };

	public static void main(String[] args) throws IOException {
//		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int n=Integer.parseInt(st.nextToken());
//		arr=new int[n];
//		for(int i=0;i<n;i++)
//		{
//			st = new StringTokenizer(br.readLine());
//			arr[i]=Integer.parseInt(st.nextToken());
//		}
		selectionSort();
		System.out.println(Arrays.toString(arr));
		
		
	}

	static void selectionSort() {
		for (int i = 0; i < arr.length; i++) {
			int midx = i;
			for (int j = i; j < arr.length; j++) {
				if (arr[j] < arr[midx])
					midx = j;
			}
			swap(i, midx);
		}
	}

	static void swap(int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

}
