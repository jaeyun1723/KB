package day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ17608 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		Stack<Integer> stk = new Stack<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			stk.push(Integer.parseInt(st.nextToken()));
		}

		int cnt = 1;
		int top = stk.peek();
		while (!stk.isEmpty()) {
			int res = stk.pop();
			if (top < res) {
				top = res;
				cnt++;
			}
		}
		System.out.println(cnt);
	}// etc

}// etc
