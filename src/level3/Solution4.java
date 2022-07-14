package level3;

public class Solution4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		System.out.println(solution(arr));
	}

	public static int solution(int[] l) {
		// Your code here
		int n = l.length;
		if (n <= 2)
			return 0;
		int count = 0;

		for (int i = 0; i <= n - 3; i++) {
			int first = l[i];
			for (int j = i + 1; j <= n - 2; j++) {
				int second = l[j];
				if (second % first != 0)
					continue;
				for (int k = j + 1; k <= n - 1; k++) {
					int third = l[k];
					if (third % second == 0)
						count++;
				}
			}
		}

		return count;
	}
}
