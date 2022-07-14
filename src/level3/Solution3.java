package level3;

public class Solution3 {
	public static void main(String[] args) {
		System.out.println(solution("", ""));
	}

	public static String solution(String a, String b) {

		java.math.BigInteger m = max(new java.math.BigInteger(a), new java.math.BigInteger(b));
		java.math.BigInteger f = min(new java.math.BigInteger(a), new java.math.BigInteger(b));

		java.math.BigInteger ans = java.math.BigInteger.ZERO;

		while (f.compareTo(java.math.BigInteger.ZERO) == 1) {
			ans = ans.add(m.divide(f));

			java.math.BigInteger temp = m;
			m = f;
			f = temp.mod(f);
		}

		if (m.compareTo(java.math.BigInteger.ONE) != 0) {
			return "impossible";
		}

		return String.valueOf(ans.subtract(java.math.BigInteger.ONE));

	}

	private static java.math.BigInteger max(java.math.BigInteger a, java.math.BigInteger b) {
		if (a.compareTo(b) == -1)
			return b;
		return a;
	}

	private static java.math.BigInteger min(java.math.BigInteger a, java.math.BigInteger b) {
		if (a.compareTo(b) == 1)
			return b;
		return a;
	}
}
