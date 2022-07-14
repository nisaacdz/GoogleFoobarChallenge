package level1;

public class Solution {

	private static boolean satisfied(String s, int factor) {
		// TODO Auto-generated method stub
		boolean returnValue = true;

		int n = s.length();

		String str = s.substring(0, factor);

		for (int i = 0; i < n; i += factor) {
			String tString = s.substring(i, i + factor);
			if (!str.equals(tString))
				return false;
		}

		return returnValue;
	}

	public static int solution(String x) {
		// Your code here
		int n = x.length();
		// the smallest factor that satisfies the condition
		for (int i = 1; i <= n; ++i) {
			if (n % i == 0) {
				if (satisfied(x, i))
					return (n / i);
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		System.out.println(solution(sc.nextLine()));
		sc.close();

	}

}
