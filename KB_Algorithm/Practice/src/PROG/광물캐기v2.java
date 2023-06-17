package PROG;

public class 광물캐기v2 {

	static int DIA = 0;
	static int IRON = 1;
	static int STONE = 2;
	static int[] USE_INDEX,PICKS; // 사용할 순서를 담을 배열
	static boolean[] visisted;
	static String[] MINERALS;

	static int pirodo = Integer.MAX_VALUE;
// 1. 사용할 곡괭이 조합을 
	public static void dfs(int cnt) {
		if (cnt == 3) {
			pirodo = Math.min(use(), pirodo);
			return;
		}

		for (int i = 0; i < 3; i++) {
			if (visisted[i])
				continue;
			visisted[i] = true;
			USE_INDEX[cnt] = i;
			dfs(cnt + 1);
			visisted[i] = false;
		}
	}
	
	public int solution(int[] picks, String[] minerals) {
		int answer = 0;
		USE_INDEX = new int[3];
		visisted = new boolean[3];

		PICKS = picks;	// 곡괭이
		MINERALS = minerals;

		dfs(0);
		return pirodo;
	}

	public static int use() {
		int totalPiro = 0;
		int lastIndex = 0;
		int index = 0; // 몇번째 곡괭이 index
		// 반복
		for (int i = 0; i < 3; i++) {
			int use = USE_INDEX[i]; // 사용할 곡괭이 index
			int cnt = 0;

			int tempUse = PICKS[use] * 5;
			if (PICKS[use] == 0)
				continue;
			for (int j = lastIndex; j < MINERALS.length; j++) {
				// if (cnt == 5) break; // 5번을 쓰면 사용불가
				if (tempUse == 0)
					break;

				if (use == DIA) {
					if (MINERALS[j].equals("diamond")) {
						totalPiro += 1;
					} else if (MINERALS[j].equals("iron")) {
						totalPiro += 1;
					} else if (MINERALS[j].equals("stone")) {
						totalPiro += 1;
					}
				} else if (use == IRON) {
					if (MINERALS[j].equals("diamond")) {
						totalPiro += 5;
					} else if (MINERALS[j].equals("iron")) {
						totalPiro += 1;
					} else if (MINERALS[j].equals("stone")) {
						totalPiro += 1;
					}
				} else if (use == STONE) {
					if (MINERALS[j].equals("diamond")) {
						totalPiro += 25;
					} else if (MINERALS[j].equals("iron")) {
						totalPiro += 5;
					} else if (MINERALS[j].equals("stone")) {
						totalPiro += 1;
					}
				}
				tempUse--;
				lastIndex++;
			}
		}
		System.out.println(totalPiro);
		return totalPiro;
	}

	


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
