package A_230406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2630_색종이만들기_정승혜 {
    static int[][] matrix;
    static int cnt0 = 0, cnt1 = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                matrix[i][j] = Integer.parseInt(st.nextToken());
        }
        search(0, N, 0, N);
        System.out.println(cnt0);
        System.out.println(cnt1);
    }

    static void search(int startY, int endY, int startX, int endX) {
        int startColor = matrix[startY][startX];
        boolean flag = true;
        for (int i = startY; i < endY; i++) {
            for (int j = startX; j < endX; j++) {
                if (startColor != matrix[i][j]) { //구역내 색이 다르면 반복문 탈출
                    flag = false;
                    break;
                }
                if(!flag) break;
            }
        }
        if(flag){
            if(startColor == 0) cnt0++; 
            else cnt1++;
        }else{ // 구역내 색이 다른 경우 분할해서 탐색
            int gap = (endX - startX)/2;
            search(startY, endY-gap, startX, endX-gap);
            search(startY, endY-gap, startX+gap, endX);
            search(startY+gap, endY, startX, endX-gap);
            search(startY+gap, endY, startX+gap, endX);
        }
    }
}
