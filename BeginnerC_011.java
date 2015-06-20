import java.util.Scanner;

public class BeginnerC_011 {

	public static void main(String[] args) {

		Scanner sca = new Scanner(System.in);

		int n = sca.nextInt();

		int n1 = sca.nextInt();
		int n2 = sca.nextInt();
		int n3 = sca.nextInt();

		if (n == n1 || n == n2 || n == n3) {
			System.out.println("NO");
			return;
		}

		for (int i = 0; i < 100; i++) {
			if (n - 3 != n1 && n - 3 != n2 && n - 3 != n3) {
				n -= 3;
			} else if (n - 2 != n1 && n - 2 != n2 && n - 2 != n3) {
				n -= 2;
			} else if (n - 1 != n1 && n - 1 != n2 && n - 1 != n3) {
				n -= 1;
			}

			if (n <= 0) {
				System.out.println("YES");
				return;
			}
		}

		System.out.println("NO");

	}

}
