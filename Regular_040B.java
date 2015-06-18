import java.util.Scanner;

public class Regular_040B {

	public static void main(String[] args) {

		Scanner sca = new Scanner(System.in);

		int n = sca.nextInt();
		int r = sca.nextInt();
		String s = sca.next();
		char[] d = s.toCharArray();
		int t = 0;

		for (int i = 0; i < n; i++) {
			if (d[i] == '.') {
				for (int k = 0; k < r; k++)
					d[i + k] = 'o';
				t++;
			}

			boolean flag = true;
			for (int k = 0; k < n; k++) {
				if (d[k] == '.')
					flag = false;
			}

			if (flag)
				break;

			if (s.lastIndexOf('.') <= i + r - 1) {
				t++;
				break;
			}
			t++;
		}

		System.out.println(t);

	}

}
