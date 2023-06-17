package day1.array;

import java.util.Scanner;

// 개수 세기
public class BOJ10807_개수세기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr= new int[201];
		int N= sc.nextInt();
		for(int i=0;i<N;i++)
			arr[sc.nextInt()+100]++;
		int chk=sc.nextInt();
		System.out.println(arr[chk+100]);
	}

}
