package A_230412;

public class PRG_타켓넘버_정승혜 {
    static int cnt;
    static int t;
    static int[] arr;
    public static int solution(int[] numbers, int target) {
        arr = numbers;
        cnt = 0;
        t = target;
        getSum(0, 0);
        return  cnt;
    }
    static void getSum(int idx, int sum){
        if(idx == arr.length){
            if(sum == t) cnt++;
            return;
        }
        getSum(idx+1,sum+arr[idx]);
        getSum(idx+1,sum-arr[idx]);
    }
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 1, 1, 1, 1},3));
        System.out.println(solution(new int[]{4, 1, 2, 1},4));
    }
}
