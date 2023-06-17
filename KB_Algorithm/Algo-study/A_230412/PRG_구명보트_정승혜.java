package A_230412;

import java.util.Arrays;

public class PRG_구명보트_정승혜 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{70,50,80,50},100));
        System.out.println(solution(new int[]{70, 80, 50},100));
    }
    public static int solution(int[] people, int limit) {
        Arrays.sort(people);
        int count = 0;
        int left = 0, right = people.length - 1;
        while(left<=right){
            count++;
            if(people[left]+people[right] <= limit) left++; //최소무게+최대무게가 제한 이하 -> 나갈 수 있음
            //else의 경우 최대무게한명만 나감
            right --;
        }
        return count;
    }
}
