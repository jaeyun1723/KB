package A_230406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ17103_골드바흐파티션_정승혜 {
    static int[] primeNumbers; //소수이면 1 아닐경우 -1. 판별작업안된경우 0

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[T];
        int max = 0;
        for (int i = 0; i < T; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }
        primeNumbers = new int[max];
        for (int a : arr) getGP(a);
    }

    static void getGP(int n) { // 파티션 개수
        int cnt = 0;
        for (int i = 2; i <= n / 2; i ++)
            if (isPrime(i) && isPrime(n - i))  cnt++;
        System.out.println(cnt);
    }

    static boolean isPrime(int n) { // 소수인지 판별
        if (primeNumbers[n] == 1) return true;
        if (primeNumbers[n] == -1) return false;

        for (int i = 2; i <= Math.sqrt(n); i ++) { //루트까지만 탐색
            if (n % i == 0) {
                primeNumbers[n] = -1;
                return false;
            }
        }
        primeNumbers[n] = 1;
        return true;
    }
}
