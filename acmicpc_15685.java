import java.util.Scanner;

//https://www.acmicpc.net/problem/15685
public class acmicpc_15685 {

	private static int M = 101;
	private static int I = 0;
	private static int J = 1;
	private static int eI = 2;
	private static int eJ = 3;
	private static int WAY = 4;

	private static boolean visit[][] = null;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		visit = new boolean[M][M];
		int[] gen = new int[] { 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024 };

		int[][][] lines = null;
		

		lines = new int[N][][];
		int maxG = 0;
		for (int n = 0; n < N; n++) {
			int j = sc.nextInt();
			int i = sc.nextInt();
			int way = sc.nextInt();
			int round = sc.nextInt();
			lines[n] = new int[gen[round]][5];

			int[] eP = move(new int[] { i, j }, way);
			lines[n][0] = new int[] { i, j, eP[I], eP[J], way };

			visitP(i, j);
			visitP(eP);

			maxG = Math.max(maxG, round);
		}

		// cal
		for (int i = 0; i < maxG; i++) {
			for (int j = 0; j < lines.length; j++) {
				if (lines[j].length <= gen[i])
					continue;
				// end 지점부터 그리기출발

				int idx = gen[i];
				int end = gen[i] - 1;
				for (int l = gen[i] - 1; l >= 0; l--) {
					int[] sP = new int[] { lines[j][end][eI], lines[j][end][eJ] };
					int[] eP = move(sP, lines[j][l][WAY] + 1);

					visitP(sP);
					visitP(eP);

					lines[j][idx++] = new int[] { sP[I], sP[J], eP[I], eP[J], (lines[j][l][WAY] + 1) % 4 };

					end++;
				}

			}
		}
		System.out.println(calR());
	}

	private static int[] move(int[] start, int way) {
		int[] end = start.clone();
		switch (way) {
		case 4:
		case 0:
			end[J] += 1;
			break;
		case 1:
			end[I] -= 1;
			break;
		case 2:
			end[J] -= 1;
			break;
		case 3:
			end[I] += 1;
			break;
		}
		return end;
	}

	private static void visitP(int[] v) {
		visit[v[I]][v[J]] = true;
	}

	private static void visitP(int i, int j) {
		visit[i][j] = true;
	}

	private static int calR() {
		int result = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {

				if (i + 1 > 100 || j + 1 > 100)
					continue; // not run

				// i + 1 check
				if (!visit[i][j])
					continue;
				if (!visit[i + 1][j])
					continue;
				if (!visit[i][j + 1])
					continue;
				if (!visit[i + 1][j + 1])
					continue;

				result++;
			}
		}

		return result;
	}

}