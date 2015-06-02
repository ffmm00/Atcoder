import java.util.Scanner;

public class BeginnerC_023 {

	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);

		int R = sca.nextInt();
		int C = sca.nextInt();

		int K = sca.nextInt();
		int N = sca.nextInt();

		int[] r = new int[N];
		int[] c = new int[N];

		for (int i = 0; i < N; i++) {
			r[i] = sca.nextInt() - 1;
			c[i] = sca.nextInt() - 1;
		}

		int[] rcnt = new int[R];
		int[] ccnt = new int[C];

		for (int i = 0; i < N; i++) {
			rcnt[r[i]]++;
			ccnt[c[i]]++;
		}

		int[] rnum = new int[N + 1];
		int[] cnum = new int[N + 1];

		for (int i = 0; i < R; i++)
			rnum[rcnt[i]]++;
		for (int i = 0; i < C; i++)
			cnum[ccnt[i]]++;


		long A = 0;

		for (int i = 0; i <= K; i++)
			A += rnum[i] * cnum[K - i];

		for (int i = 0; i < N; i++) {
			int cnt = rcnt[r[i]] + ccnt[c[i]];
			if (cnt == K)
				A--;
			if (cnt == K + 1)
				A++;
		}

		System.out.println(A);

	}
}
