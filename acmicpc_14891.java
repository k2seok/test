import java.util.Scanner;

public class acmicpc_14891 {

	// https://www.acmicpc.net/problem/14891

	private static final int TOPNI = 8;
	private static final int TOPNUM = 4;
	private static final int N = 0;
	private static final int S = 1;

	static int[][] top = new int[TOPNUM][TOPNI];
	static boolean[] visitTop = new boolean[TOPNUM];
	// AWAY
	private static final int BAN = -1;

	private static final int RIGHT = 2;
	private static final int LEFT = 6;
	// private static int K = 0;

	// private static int[] top = new int[TOPNI];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < TOPNUM; i++) {
			String[] s = sc.nextLine().split("");

			for (int j = 0; j < TOPNI; j++) {
				if (N == Integer.parseInt(s[j]))
					top[i][j] = N;
				else
					top[i][j] = S;
			}
		}

		int K = sc.nextInt();
		// Input & Calcul
		for (int i = 0; i < K; i++) {
			visitTop = new boolean[TOPNUM];
			turn(sc.nextInt() -1, sc.nextInt());
			//
		}

		// result
		int result = 0;
		for (int i = 0; i < TOPNUM; i++) {
			if (top[i][0] > 0)
				result += Math.pow(2.0, i);
		}
		System.out.println(result);

	}

	private static void turn(int num, int away) {
		if (visitTop[num])
			return;
		visitTop[num] = true;

		int rightNum = top[num][RIGHT];
		int leftNum = top[num][LEFT];

		// number top turn

		// turn
		int nextAway = 0;

		if (away == BAN) {
			int temp = top[num][0];
			for (int i = 0; i < TOPNI - 1; i++) {
				top[num][i] = top[num][i + 1];
			}
			top[num][TOPNI - 1] = temp;
			nextAway++;
		} else {
			int temp = top[num][TOPNI - 1];
			for (int i = TOPNI - 1; i > 0; i--) {
				top[num][i] = top[num][i - 1];
			}
			top[num][0] = temp;

			nextAway--;
		}

		// // left
		if (num > 0 && leftNum != top[num - 1][RIGHT])
			turn(num - 1, nextAway);
		// right
		if (num < TOPNUM - 1 && rightNum != top[num + 1][LEFT])
			turn(num + 1, nextAway);
	}
}