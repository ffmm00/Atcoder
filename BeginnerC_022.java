import java.util.Scanner;

public class BeginnerC_022 {

	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);

		int st[][] = new int[364][364];
		int ed[] = new int[364];
		int n = sca.nextInt();
		int m = sca.nextInt();
		int inf = 100000000, ret = inf;
		int a, b, c, d;

		for (int i = 0; i < n; i++) {
			ed[i] = inf;
			for (int k = 0; k < n; k++)
				st[i][k] = inf;
			st[i][i] = 0;
		}

		for (int i = 0; i < m; i++) {
			a = sca.nextInt();
			b = sca.nextInt();
			c = sca.nextInt();
			a--;
			b--;
			if (a > b) {
				d = a;
				a = b;
				b = d;
			}
			if (a == 0)
				ed[b] = c;
			else
				st[a][b] = st[b][a] = c;
		}



		for (int k = 0; k < n; k++)
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++) {
					st[i][j] = Math.min(st[i][j], st[i][k] + st[k][j]);
				}


		for (int i = 1; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++)
				if (ed[i] < inf && ed[j] < inf && st[i][j] < inf) {
					ret = Math.min(ret, ed[i] + ed[j] + st[i][j]);
				}
		}

		if (ret >= inf)
			System.out.println(-1);
		else
			System.out.println(ret);

	}
}
