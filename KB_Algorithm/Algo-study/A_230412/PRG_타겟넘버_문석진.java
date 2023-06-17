package A_230412;

class PRG_타겟넘버_문석진 {

    static int answer = 0;
    static int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);

        return answer;
    }

    static void dfs(int [] numbers, int depth, int target, int sum) {
        // numbers : 알고리즘을 실행할 대상 배열
        // depth : 노드의 깊이 -> numbers 길이만큼만 들어갈 예정
        // target : 타겟 넘버
        // sum : 이전 노드 까지의 합한 결과값
        if (depth == numbers.length) { // 노드의 깊이가 배열의 길이와 같다면 재귀 끝
            if (target == sum) answer++;
        } else {
            dfs(numbers, depth + 1, target, sum + numbers[depth]);
            dfs(numbers, depth + 1, target, sum - numbers[depth]);
        }
    }


    public static void main(String[] args) {
//        System.out.println(solution(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println(solution(new int[]{4, 1, 2, 1}, 4));
    }
}