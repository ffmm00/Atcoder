import java.util.Scanner;

public class BeginnerC_024 {

	public static void main(String[] args) {

		Scanner sca = new Scanner(System.in);

		int N = sca.nextInt();
		int D = sca.nextInt();
		int K = sca.nextInt();

		int[] L = new int[D];
		int[] R = new int[D];

		for (int i = 0; i < D; i++) {
			L[i] = sca.nextInt();
			R[i] = sca.nextInt();
		}

		for (int i = 0; i < K; i++) {
			int S = sca.nextInt();
			int T = sca.nextInt();

			int min = S, max = S;
			for (int k = 0; k < D; k++) {
				if (min <= R[k])
					min = Math.min(min, L[k]);
				if (L[k] <= max)
					max = Math.max(max, R[k]);
				if (min <= T && T <= max) {
					System.out.println(k + 1);
					break;
				}

			}
		}
	}

}
