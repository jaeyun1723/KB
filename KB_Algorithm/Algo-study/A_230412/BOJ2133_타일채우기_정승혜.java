package A_230412;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2133_타일채우기_정승혜 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n % 2 == 1) { //홀수면 못 채움
            System.out.println(0);
            return;
        }
        n /= 2;
        int[] arr = new int[n + 1];
        arr[0] = 1;
        arr[1] = 3; //n=2 -> 3가지
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] * arr[1];
            for (int j = i - 2; j >= 0; j--)
                arr[i] += arr[j] * 2;
        }
        System.out.println(arr[n]);
    }

}
