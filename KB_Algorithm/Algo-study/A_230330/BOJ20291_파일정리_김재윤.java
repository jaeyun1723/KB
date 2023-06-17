package A230330;
import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class BOJ20291_파일정리_김재윤 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		Map<String, Integer> map = new HashMap<>(); // 중복 불가
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			String[] s = str.split("\\."); 	// 점으로 자르기
			map.put(s[s.length-1], map.getOrDefault(s[s.length-1], 0) + 1);	// <확장자, 개수>
		}
		
		List<String> list = new ArrayList<>(map.keySet()); // 키 셋 따로 가져옴
		Collections.sort(list);
		for(String name : list) {
			System.out.println(name + " " + map.get(name));
		}
	}

}