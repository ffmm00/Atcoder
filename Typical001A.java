import java.util.Scanner;

public class Typical001A {

	static String r;
	static int h, w, sx, gx, sy, gy;
	static boolean[][] map;
	static char[][] c;

	static void search(int x, int y) {

		if (x < 0 || x >= h || y < 0 || y >= w || map[x][y] || c[x][y] == '#')
			return;

		map[x][y] = true;

		search(x + 1, y);
		search(x - 1, y);
		search(x, y + 1);
		search(x, y - 1);

	}

	public static void main(String[] args) {

		Scanner sca = new Scanner(System.in);

		h = sca.nextInt();
		w = sca.nextInt();

		map = new boolean[h][w];
		c = new char[h][w];

		for (int i = 0; i < h; i++) {
			String r = sca.next();
			for (int k = 0; k < w; k++) {
				c[i][k] = r.charAt(k);
				if (r.charAt(k) == 's') {
					sx = i;
					sy = k;
				} else if (r.charAt(k) == 'g') {
					gx = i;
					gy = k;
				}
			}
		}

		search(sx, sy);

		System.out.println(map[gx][gy] ? "Yes" : "No");

	}

}
