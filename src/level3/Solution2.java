package level3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Pair {

	int first, second;

	public Pair(int first, int second) {
		this.first = first;
		this.second = second;
	}

	public void setFirst(int first) {
		this.first = first;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	public int getFirst() {
		return first;
	}

	public int getSecond() {
		return second;
	}

}

public class Solution2 {

	public static int[] X = { 0, 0, 1, -1 };
	public static int[] Y = { 1, -1, 0, 0 };

	public static int solution(int[][] map) {
		int row = map.length;
		int col = map[0].length;
		int ans = 1000;
		int[][] forward = bfs(map, row, col, 0, 0);
		int[][] backward = bfs(map, row, col, row - 1, col - 1);

		for (int i = 0; i < row; ++i) {
			for (int j = 0; j < col; ++j) {
				if (forward[i][j] > 0 && backward[i][j] > 0) {
					ans = Math.min(ans, forward[i][j] + backward[i][j] - 1);
				}
			}
		}
		return ans;

	}

	private static int[][] bfs(int[][] map, int row, int col, int xx, int yy) {
		int[][] dis = new int[row][col];
		Queue<Pair> Q = new LinkedList<>();
		Q.add(new Pair(xx, yy));
		for (int k = 0; k < row; ++k)
			Arrays.fill(dis[k], 0);

		dis[xx][yy] = 1;

		while (!Q.isEmpty()) {
			Pair first_ele = Q.poll();
			int x = first_ele.getFirst();
			int y = first_ele.getSecond();

			for (int i = 0; i < 4; ++i) {
				int new_x = x + X[i], new_y = y + Y[i];
				if (new_x >= 0 && new_y >= 0 && new_x < row && new_y < col && dis[new_x][new_y] == 0) {

					dis[new_x][new_y] = dis[x][y] + 1;
					if (map[new_x][new_y] == 1)
						continue;
					Q.add(new Pair(new_x, new_y));

				}
			}
		}
		return dis;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] temp = { { 0, 0, 0, 0, 0, 0 }, { 1, 1, 1, 1, 1, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 1, 1, 1, 1, 1 },
				{ 0, 1, 1, 1, 1, 1 }, { 0, 0, 0, 0, 0, 0 } };
		System.out.println(solution(temp));
	}

}
