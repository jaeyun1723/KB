package A_230406;

public class PRG_신규아이디추천_정승혜 {
    public static String solution(String new_id) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < new_id.length(); i++) {
            if (sb.length() == 15) break;
            char tmp = new_id.charAt(i);
            if ((tmp >= 'a' && tmp <= 'z') || (tmp >= '0' && tmp <= '9')) // 소문자 or 숫자 그대로
                sb.append(tmp);
            else if (tmp >= 'A' && tmp <= 'Z')  // 대문자 -> 소문자
                sb.append((char) (tmp + ('a' - 'A')));
            else if (tmp == '-' || tmp == '_') sb.append(tmp); // 허용되는 문자
            else if (tmp == '.') { // 점은 하나만
                if (sb.length() > 0 && sb.charAt(sb.length()-1)!='.') sb.append(tmp);
            }
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '.')  // 마지막이 점이면 제거
            sb.deleteCharAt(sb.length() - 1);
        if (sb.length() == 0) sb.append('a');
        if (sb.length() < 3) { //길이 3자이상
            char c = sb.charAt(sb.length() - 1);
            while (sb.length() < 3) sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("...!@BaT#*..y.abcdefghijklm"));
        System.out.println(solution("z-+.^."));
        System.out.println(solution("=.="));
        System.out.println(solution("123_.def"));
        System.out.println(solution("abcdefghijklmn.p"));
        System.out.println(solution(""));
        System.out.println(solution("abc..........2340"));
    }
}
