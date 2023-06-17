package com.kb.algo;

import java.util.Scanner;

public class RecursiveTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int result = recursive(sc.nextInt());
		System.out.println(result);
	}// etc 

	public static int recursive(int su) {
		if (su < 1)
			return 1;
		else
			return su * recursive(--su);
	}
}// etc