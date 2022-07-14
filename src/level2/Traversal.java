package level2;

import java.util.Scanner;

public class Traversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int h = Integer.parseInt(sc.nextLine());

		String[] line = sc.nextLine().split(" ");

		int[] q = new int[line.length];

		for (int i = 0; i < line.length; i++) {
			q[i] = Integer.parseInt(line[i]);
		}

		for (int i : solution(h, q)) {
			System.out.print(i + " ");
		}
		sc.close();
	}
	
	public static int[] solution(int h, int[] q) {

		int[] ans = new int[q.length];

		for (int i = 0; i < q.length; i++) {
			int n = pow(2, h) - 1;
			if (q[i] == n)
				ans[i] = -1;
			else {
				ans[i] = findX(n, h - 1, q[i]);
			}
		}
		return ans;
	}

	private static int findX(int prev, int level, int x) {
		int genR = prev - 1;
		int genL = genR - (pow(2, level) - 1);

		if (x == genR || x == genL)
			return prev;
		if (x < genL)
			return findX(genL, level - 1, x);
		return findX(genR, level - 1, x);
	}

	private static int pow(int a, int b) {
		int ans = a;
		if (b == 0)
			return 1;

		for (int i = 0; i < b - 1; i++) {
			ans *= a;
		}

		return ans;
	}

}
