package day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ9742 {

	static String str;
	static StringBuilder result;
	static boolean[] selected;
	static int res, complete;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;

		while ((line = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(line);
			str = st.nextToken();
			res = Integer.parseInt(st.nextToken());
			selected = new boolean[str.length()];
			result = new StringBuilder();
			complete = 0;
			permutation(0);
			if (complete < res)
				System.out.println(str+ " "+ res + " = No permutation");
		}

	}//

	static void permutation(int cnt) {
		if (cnt == str.length()) {
			complete++;
			if (complete == res)
				System.out.println(str + " " + res + " = " + result);
			return;
		}
		for (int i = 0; i < str.length(); i++) {
			if (!selected[i]) {
				result.append(str.charAt(i));
				selected[i] = true;
				permutation(cnt + 1);
				result.deleteCharAt(result.length() - 1);
				selected[i] = false;

			}
		}
	}
}//

// 1 2 3 4 5 : 0 : 1~n
// 6 7 8 9 10 : 1 :  1~n
// 11 12 13 14 15 : 2 :1 ~n
// 16 17 18 19 20
// 21 22 23 24 25

// 1 2 3
// 2 2 3
// 3 3 3