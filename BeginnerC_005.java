import java.util.Scanner;

public class BeginnerC_005 {

	public static void main(String[] args) {

		Scanner sca = new Scanner(System.in);

		int t = sca.nextInt();

		int n = sca.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = sca.nextInt();

		int m = sca.nextInt();
		int[] b = new int[m];
		for (int i = 0; i < m; i++)
			b[i] = sca.nextInt();

		if (m > n) {
			System.out.println("no");
			return;
		}

		boolean sell = true;
		int i = 0;
		int k = 0;

		while (sell) {
			if (b[k] - a[i] <= t) {
				if (b[k] - a[i] < 0) {
					System.out.println("no");
					return;
				}
				i++;
				k++;
			} else
				i++;
			
			if (k > m - 1) {
				System.out.println("yes");
				return;
			}
			if (i > n - 1) {
				System.out.println("no");
				return;
			}

		}
	}
}
