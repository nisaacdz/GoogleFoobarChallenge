package level4;

public class Solution {

	private static int N;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 1, 1, 2 };

		System.out.println(solution((arr)));
	}

	public static int solution(int[] numbers) {
		// Your code here
		N = numbers.length;
		boolean[][] graph = getGraph(numbers);
		int count = getPairs(graph);
		return N - 2 * (count / 2);
	}

	private static boolean[][] getGraph(int[] arg) {
		boolean[][] ans = zeros(N);

		for (int i = 0; i < N; i++) {

			for (int j = 0; j < N; j++) {
				if (i < j) {
					ans[i][j] = getBool(arg[i], arg[j]);
					ans[j][i] = ans[i][j];
				}

			}
		}
		return ans;
	}

	private static boolean[][] zeros(int x) {
		boolean[][] ans = new boolean[x][x];
		for (int a = 0; a < x; a++) {
			for (int b = 0; b < x; b++) {
				ans[a][b] = false;
			}
		}
		return ans;
	}

	private static int gcd(int x, int y) {
		if (y == 0)
			return x;
		return gcd(y, x % y);
	}

	private static boolean getBool(int key, int value) {

		if (key == value)
			return false;

		int gcd = gcd(key, value);

		if ((key + value) % 2 == 1)
			return true;

		key = key / gcd;
		value = value / gcd;

		int[] maxmin = sort(key, value);

		value = maxmin[0];
		key = maxmin[1];

		key -= value;
		value *= 2;

		return getBool(key, value);

	}

	private static boolean bpm(boolean[][] graph, int u, boolean seen[], int matchR[]) {

		for (int v = 0; v < N; v++) {

			if (graph[u][v] && !seen[v]) {

				seen[v] = true;

				if (matchR[v] < 0 || bpm(graph, matchR[v], seen, matchR)) {
					matchR[v] = u;
					return true;
				}
			}
		}
		return false;
	}

	private static int getPairs(boolean bpGraph[][]) {
		int matchR[] = new int[N];

		for (int i = 0; i < N; ++i)
			matchR[i] = -1;

		int result = 0;
		for (int u = 0; u < N; u++) {

			boolean seen[] = new boolean[N];
			for (int i = 0; i < N; ++i)
				seen[i] = false;

			if (bpm(bpGraph, u, seen, matchR))
				result++;
		}
		return result;
	}

	private static int[] sort(int a, int b) {
		// A and B are not supposed to be equal
		int[] ans = { Math.min(a, b), Math.max(a, b) };
		return ans;
	}
}
