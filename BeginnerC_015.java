import java.util.Scanner;

public class BeginnerC_015 {

	static int n;
	static int k;
	static int[][] g;

	static boolean dfs(int q, int x) {
		if (q == n)
			return x == 0;

		for (int i = 0; i < k; i++) {
			if (dfs(q + 1, x ^ g[q][i]))
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);

		n = sca.nextInt();
		k = sca.nextInt();
		g = new int[n][k];

		for (int i = 0; i < n; i++)
			for (int j = 0; j < k; j++)
				g[i][j] = sca.nextInt();

		System.out.println(dfs(0, 0) ? "Found" : "Nothing");

	}
}
