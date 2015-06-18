import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BeginnerC_007 {

	public static void main(String[] args) {

		Scanner sca = new Scanner(System.in);

		int r = sca.nextInt();
		int c = sca.nextInt();

		int sy = sca.nextInt() - 1;
		int sx = sca.nextInt() - 1;
		int gy = sca.nextInt() - 1;
		int gx = sca.nextInt() - 1;

		boolean[][] map = new boolean[r][c];

		for (int i = 0; i < r; i++) {
			String w = sca.next();
			for (int k = 0; k < c; k++) {
				if (w.charAt(k) == '.')
					map[i][k] = true;
				else
					map[i][k] = false;
			}
		}

		int[] x = { 1, -1, 0, 0 };
		int[] y = { 0, 0, 1, -1 };

		Queue<Integer> queX = new LinkedList<Integer>();
		Queue<Integer> queY = new LinkedList<Integer>();

		int[][] check = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int k = 0; k < c; k++) {
				check[i][k] = -1;
			}
		}

		queX.add(sx);
		queY.add(sy);
		check[sx][sy] = 0;

		while (!queX.isEmpty()) {
			int nowx = queX.poll();
			int nowy = queY.poll();

			for (int i = 0; i < 4; i++) {
				int Y = nowy + y[i];
				int X = nowx + x[i];

				if (check[Y][X] == -1 && map[Y][X] && 0 < Y && Y <= r && 0 < X
						&& X <= c) {
					check[Y][X] = check[nowy][nowx] + 1;
					queY.add(Y);
					queX.add(X);
				}
			}
		}

		System.out.println(check[gy][gx]);

	}
}
