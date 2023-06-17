import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2108_통계학_정승혜 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] input = new int[n];

        double avg = 0.;
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(br.readLine());
            avg += input[i];
        }
        Arrays.sort(input);
        int cntDup = 1, cntTmp = 1; //cntDup : 최빈값의 개수, cntTmp : 현재 숫자의 개수 세는 변수
        int mode = input[0]; // 최빈값 저장 변수
        int flag = 0; // 최빈값이 여러개인경우 몇번째인지 표시
        for (int i = 0; i < n - 1; i++) {
            if (input[i] == input[i + 1]) { //다음 숫자랑 같을 경우
                cntTmp++;
                if (i != n - 2) continue;
            }
            // 다음 숫자랑 다른 경우
            if (cntDup < cntTmp) { //최빈값 개수보다 크면 갱신
                cntDup = cntTmp;
                mode = input[i];
                flag = 0;
            }
            if (cntDup == cntTmp) { //최빈값 개수와 같으면 flag 조정. 두번째 값인 경우 mode 변수 갱신
                if(flag == 1)
                    mode = input[i];
                flag++;
            }
            cntTmp = 1;
        }

        int median = (n%2 == 1)? input[n/2]: (input[n/2]+input[n/2+1])/2; // 개수가 짝수면 가운데 두 숫자 더한뒤 나누어주고 홀수면 가운데 숫자

        System.out.println((int) Math.round(avg / n)); // avg
        System.out.println(median); // median
        System.out.println(mode); // mode
        System.out.println(input[n-1]-input[0]); //max-min
    }
}
