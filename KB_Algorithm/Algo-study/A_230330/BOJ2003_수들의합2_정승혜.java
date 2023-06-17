package A_230330;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*투포인터*/
// 아직 잘 모르겟
public class BOJ2003_수들의합2_정승혜 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int count = 0;
        int sum = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        int s = 0, e = 0;
        while (s < N) {
            if (sum >= M || e == N) sum -= arr[s++];
            else sum += arr[e++];
            if (sum == M) count++;
        }
        System.out.println(count);
    }
}
