package level4;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fact(8));
	}

	private static int[] combination(int[] arg, int x) {
		int n = arg.length;
		if (x == n)
			return arg;
		if (x > n)
			throw new IllegalArgumentException("The Supplied Argument Is Too Big");
		int[] ans = new int[comb(n, x)];
		
		
		return ans;

	}

	private static int comb(int x, int y) {
		if (y > x)
			throw new IllegalArgumentException("The r cannot be bigger than the n");

		return fact(x) / (fact(y) * fact(x - y));
	}

	private static int fact(int x) {
		if (x > 1)
			return x * fact(x);

		return x;
	}

	private static int getPairs(int[][] g) {
		int matched = 0;
		int checks = g.length;
		while (g.length > 1 && checks >= 1) {
			int min = 0;
			int min2 = 1;

			for (int i = 0; i < checks; i++) {

			}

			for (int i = 0; i < checks; i++) {

			}

			if (g.length > 1) {
				checks = g.length;
			}
		}
		return matched;
	}

	private static int[][] delete(int index, int[][] array) {
		int[][] copy = new int[array.length - 1][];

		for (int i = 0, j = 0; i < array.length; i++) {
			if (i != index) {
				copy[j++] = array[i];
			}
		}
		return copy;
	}

}
