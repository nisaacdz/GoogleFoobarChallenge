package level2;

import java.util.Scanner;

public class Solution {

	private static String solution(int x, int y) {

		long diff = 1 + y;

		long start = (long) ((0.5 * y * y) - (0.5 * y) + 1);

		long steps = x - 1;

		long ans = (long) (start + ((diff * steps) + (0.5 * steps * steps) - (0.5 * steps)));

		return String.valueOf(ans);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] line = sc.nextLine().split(" ");

		int x = Integer.parseInt(line[0]);
		int y = Integer.parseInt(line[1]);

		System.out.println(solution(x, y));
		sc.close();

	}

}
