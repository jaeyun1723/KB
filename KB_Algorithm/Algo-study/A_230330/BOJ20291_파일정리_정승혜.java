package A_230330;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ20291_파일정리_정승혜 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> cnt = new HashMap<>(); //key : 확장자, value : 개수
        ArrayList<String> keys = new ArrayList<>(); // 확장자
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), ".");
            st.nextToken();
            String info = st.nextToken();
            if (cnt.containsKey(info)) cnt.replace(info, cnt.get(info) + 1); //이미 있으면 개수 하나 추가
            else { // 없으면 추가
                cnt.put(info, 1);
                keys.add(info);
            }
        }
        Collections.sort(keys); 
        for (String key : keys)
            System.out.println(key+" "+cnt.get(key));
    }
}
