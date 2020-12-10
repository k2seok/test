import java.util.Scanner;

public class Main {

	private static int N;
	private static int M;
	private static boolean[] visit;
	private static int[][] map;
	private static int result;

	private static final int I = 0;
	private static final int J = 1;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		visit = new boolean[N + 1];
		map = new int[N + 1][N + 1];

		sc.nextLine();
		for (int m = 0; m < M; m++) {
			String[] s = sc.nextLine().split(" ");
			int i = Integer.parseInt(s[I]);
			int j = Integer.parseInt(s[J]);
			map[i][j] = j;
			map[j][i] = i;
			// map[i].setNext(list[j]);
			// list[j].setPrev(list[i]);
		}

		for (int i = 1; i <= N; i++) {
			if (visit[i])
				continue;
			result++;
			cal(i, map[i]);

		}
		System.out.println(result);

	}

	private static void cal(int i, int[] value) {
		if (visit[i])
			return;
		visit[i] = true;

		for (int j = 1; j <= N; j++) {
			if (map[i][j] > 0 || map[j][i] > 0)
				cal(j, map[j]);
		}

	}
}
