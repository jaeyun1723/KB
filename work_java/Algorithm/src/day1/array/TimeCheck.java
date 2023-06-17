package day1.array;

public class TimeCheck {

	public static void main(String[] args) {
		int N = 500000;
		long start, end;

		start = System.currentTimeMillis();
		int total = 0;
		for (int i = 0; i < N; i++)
			total += i;
		end = System.currentTimeMillis();
		System.out.println(end - start);

		start = System.currentTimeMillis();
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++) {
				total += j;
			}
		end = System.currentTimeMillis();
		System.out.println(end - start);
	}

}