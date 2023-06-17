package day9;

import java.util.Arrays;

public class UnionFind {

	static int N = 7;
	static int[] parents = new int[N];

	static void make() {
		for (int i = 0; i < N; i++)
			parents[i] = i;
	}

	static int find(int x) {
		if (parents[x] == x)
			return x;
		return parents[x] = find(parents[x]);
	}

	static void union(int x, int y) {
		int xRoot = find(x);
		int yRoot = find(y);
		if (xRoot == yRoot)
			return;
		parents[yRoot] = xRoot;
	}

	static boolean isSame(int x, int y) {
		int xRoot = find(x);
		int yRoot = find(y);
		if (xRoot == yRoot)
			return true;
		return false;
	}

	public static void main(String[] args) {
		make();
		int a = 3, b = 4;
		Math.abs(b - a);
		union(0, 1);
		System.out.println(Arrays.toString(parents));
		union(1, 2);
		System.out.println(Arrays.toString(parents));
		union(5, 6);
		System.out.println(Arrays.toString(parents));
		union(0, 5);
		System.out.println(Arrays.toString(parents));
		isSame(0, 6);
		System.out.println(Arrays.toString(parents));
	}// etc

}// etc
