package day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CompleteBinTree {

	static char[] nodes;
	static int SIZE, LastIndex;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		SIZE = Integer.parseInt(st.nextToken());
		nodes = new char[SIZE + 1];
		LastIndex = SIZE;

		for (int i = 1; i <= SIZE; i++) {
			nodes[i] = (char) ('A' + (i - 1));
		}
		System.out.println(Arrays.toString(nodes));
		
		getChild(1);
		getChild(5);
		getParent(5);
	}//

	static void getChild(int currIndex) {
		int left = currIndex * 2;
		int right = currIndex * 2 + 1;
		if (left <= LastIndex)
			System.out.println(nodes[left]);
		if (right <= LastIndex)
			System.out.println(nodes[right]);
	}

	static void getParent(int currIndex) {
		System.out.println(nodes[currIndex/2]);
	}
}//
