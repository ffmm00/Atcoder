import java.util.HashSet;
import java.util.Scanner;

public class BeginnerC_019 {

	public static void main(String[] args) {

		Scanner sca = new Scanner(System.in);
		int n = sca.nextInt();
		int[] a = new int[n];

		int c = 0;

		HashSet<Integer> box = new HashSet<Integer>();

		for (int i = 0; i < n; i++) {
			int t = sca.nextInt();
			while (t > 1 && t % 2 == 0)
				t /= 2;

			if (!box.contains(t)) {
				c++;
				box.add(t);
			}

		}

		System.out.println(c);

	}
}
