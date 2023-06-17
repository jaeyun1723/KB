package A_230406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ1874_스택수열_정승혜 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine());
        int num = 1;
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < n; i++) {
            while (num <= arr[i]) { //배열에 담긴 수보다 작거나 같으면 push
                stack.push(num++);
                sb.append("+\n");
            }
            if (arr[i] == stack.pop()) // 같으면 pop
                sb.append("-\n");
            else {
                System.out.println("NO"); //pop한 값이 다르면 불가능한 경우임
                return;
            }
        }
        System.out.print(sb.toString());
    }
}
