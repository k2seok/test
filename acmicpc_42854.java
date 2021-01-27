import java.util.*;

////https://www.acmicpc.net/problem/1094
public class acmicpc_42854 {
	public static void main(String[] args) {
		int[] prices = { 1, 2, 3, 2, 3 };
		// TODO Auto-generated method stub
		System.out.println(solution(prices));
	}

	public static int[] solution(int[] prices) {
		int[] answer = {};
		boolean[][] map = new boolean[prices.length][];

		// 가격 입력
		for (int i = 0; i < map.length; i++) {
			map[i] = new boolean[prices[i]];
		}

		// result 입력
		answer = new int[map.length];
		for (int time = 0; time < map.length; time++) {
			int v = 0;
			for (int count = time + 1; count < map.length && time <= map[count].length; count++) {
				v++;
			}
			if (v == 0 && time + 1 < map.length)
				v++;// 1초뒤 종료인경우 +1
			answer[time] = v;
//			map[time]
		}

		return answer;
	}
}
