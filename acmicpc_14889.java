import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class acmicpc_14889 {

	private static String F = "./tcFile/main2.txt";
	private static int N;
	private static int result;
	private static boolean[] visit;
	private static int[][] map;

	// https://www.acmicpc.net/problem/14889 - samsung
	public static void main(String[] args) throws FileNotFoundException{
		// 이전풀이 계산법 참고

		Scanner sc = new File(F).exists() ? new Scanner(new File(F)): new Scanner(System.in); 
				 

		N = sc.nextInt();
		visit = new boolean[N + 1];
		result = 999999999;
		map = new int[N + 1][N + 1];
		// init
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		make(1, 0);

		System.out.println(result);

	}

	private static void make(int round, int prev) {
		if (round > N / 2) {
			int now = cal();
			result = result < now ? result : now;
			return; // end
		}

		//
		for (int i = prev + 1; i <= N; i++) {
			if (visit[i])
				continue;

			visit[i] = true;
			make(round + 1, i);
			visit[i] = false;
		}

	}

	private static int cal() {
		// t, f cal
		
		int teamA[] = new int[N/2];
		int teamB[] = new int[N/2];
		int acnt =0;
		int bcnt =0;
		for (int idx = 1; idx <= N; idx++) {
			if (visit[idx])
				teamA[acnt++] = idx;
			else
				teamB[bcnt++] = idx;
		}

		return ((int)Math.abs(teamValue(teamA) - teamValue(teamB)));
	}
	
	private static int teamValue(int[] team) {
		int value = 0;
		for (int i = 0; i < team.length - 1; i++) {
			for (int j = i + 1; j < team.length; j++) {
				value += map[team[i]][team[j]] + map[team[j]][team[i]];
			}
		}
		return value;
	}

}
