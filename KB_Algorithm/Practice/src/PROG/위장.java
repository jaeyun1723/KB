package PROG;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 위장 {
	public int solution(String[][] clothes) {
		int answer = 1;
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < clothes.length; i++)
			map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
		// value=map.get(key);
		// List<String> list=new ArrayList<>(map.keySet());
		for (String key : map.keySet()) {
			answer *= (map.get(key) + 1);
		}
		return answer - 1;
	}
}
