import java.util.Scanner;

public class Regular_040A {

	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);

		int N = sca.nextInt();
		int t = 0;
		int a = 0;

		for (int i = 0; i < N; i++) {
			String s = sca.next();
			for (int k = 0; k < N; k++) {
				if (s.charAt(k) == 'R')
					t++;
				if (s.charAt(k) == 'B')
					a++;
			}
		}

		if (t > a)
			System.out.println("TAKAHASHI");
		else if (t < a)
			System.out.println("AOKI");
		else if (t == a)
			System.out.println("DRAW");

	}

}
