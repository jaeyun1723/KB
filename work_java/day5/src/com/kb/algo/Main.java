package com.kb.algo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("input.txt"));
//		Scanner s=new Scanner(System.in);
//		int su = s.nextInt();
//		int su1 = s.nextInt();
//		int su2 = s.nextInt();
//		int su3 = s.nextInt();
//		System.out.println(su + " " + su1);
//		FileInputStream fis = new FileInputStream("input.txt");	// file 8bit씩 읽음
//		InputStreamReader isr = new InputStreamReader(fis);	// 8bit -> 16bit
//		BufferedReader br = new BufferedReader(isr);	// 입출력 속도차를 위해 버퍼 제공
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		
		String data = br.readLine(); // 한 줄 읽기
		System.out.println(data);
		String[] d = data.split(" "); // 공백으로 분리
		int[] sd = new int[d.length];
		for (int i = 0; i < d.length; i++) {
			sd[i] = Integer.parseInt(d[i]); // 문자열-> 정수
		}
		System.out.println(Arrays.toString(sd));
		
	}// etc

}// etc
