import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class BeginnerC_020 {

	public static void main(String[] args) {

		Scanner sca = new Scanner(System.in);

		int H = sca.nextInt();
		int W = sca.nextInt();
		int T = sca.nextInt();

		int[] a = { 1, -1, 0, 0 };
		int[] b = { 0, 0, 1, -1 };

		char[][] map = new char[H][];

		for (int i = 0; i < H; i++) {
			map[i] = sca.next().toCharArray();
		}

		int sx = -1;
		int sy = -1;

		for (int i = 0; i < H; i++)
			for (int k = 0; k < W; k++) {
				if (map[i][k] == 'S') {
					sx = i;
					sy = k;
				}
			}

		int[][][] dp = new int[H][W][H * W];
		for (int i = 0; i < H; i++)
			for (int k = 0; k < W; k++) {
				Arrays.fill(dp[i][k], 1000000000);
			}

		dp[sx][sy][0] = 0;
		int max = 0;

		Deque<Integer[]> deque = new ArrayDeque<>();
		deque.addLast(new Integer[] { sx, sy, 0 });
		while (!deque.isEmpty()) {
			Integer[] poll = deque.pollFirst();
			for (int k = 0; k < a.length; k++) {
				int x = poll[0] + a[k];
				int y = poll[1] + b[k];
				int t = poll[2];
				if (x < 0 || y < 0 || x >= H || y >= W) {
					continue;
				}

				if (map[x][y] == '.'
						&& dp[x][y][t] > dp[poll[0]][poll[1]][t] + 1) {

					dp[x][y][t] = dp[poll[0]][poll[1]][t] + 1;
					if (map[x][y] == '.')
						deque.addLast(new Integer[] { x, y, t });
				}

				else if (map[x][y] == '#' && t + 1 < H * W
						&& dp[x][y][t + 1] > dp[poll[0]][poll[1]][t] + 1) {
					dp[x][y][t + 1] = dp[poll[0]][poll[1]][t] + 1;
					deque.addLast(new Integer[] { x, y, t + 1 });
				}

				else if (map[x][y] == 'G'
						&& dp[x][y][t] > dp[poll[0]][poll[1]][t] + 1) {
					dp[x][y][t] = dp[poll[0]][poll[1]][t] + 1;
					if (t != 0) {
						int rest = T - dp[x][y][t];
						max = Math.max(max, rest / t + 1);
					}
				}
			}
		}

		System.out.println(max);

	}
}
