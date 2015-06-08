import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BeginnerC_021 {

	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);

		int N = sca.nextInt();
		int st = sca.nextInt() - 1;
		int gl = sca.nextInt() - 1;
		int M = sca.nextInt();
		List<Integer>[] root = new List[N];
		int inf = 1000000000;
		int mod = 1000000007;

		for (int i = 0; i < N; i++)
			root[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			int from = sca.nextInt() - 1;
			int to = sca.nextInt() - 1;
			root[from].add(to);
			root[to].add(from);
		}

		int[] cnt = new int[N];
		int[] dis = new int[N];
		Arrays.fill(dis, inf);
		cnt[st] = 1;
		dis[st] = 0;

		Queue<Integer> q = new LinkedList<>();
		q.offer(st);

		while (!q.isEmpty()) {
			int target = q.poll();

			for (int tmp : root[target]) {
				if (dis[target] + 1 < dis[tmp]) {
					dis[tmp] = dis[target] + 1;
					cnt[tmp] = cnt[target];
					q.offer(tmp);
				} else if (dis[target] + 1 == dis[tmp]) {
					cnt[tmp] = (cnt[tmp] + cnt[target]) % mod;
				}
			}
		}

		System.out.println(cnt[gl]);

	}

}
