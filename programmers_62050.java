public class programmers_62050 {

	/**
	 * 
	 * //https://programmers.co.kr/learn/courses/30/lessons/62050?language=java 1)
	 * 사다리 놔야하는 값모두 확인 : 위치 값 저장 2) i번째 사다리1개 놓고 출발 : answer + 사다리 비용 3) 방문 검증 call
	 * (사다리위치 , 현재 최소비용 )
	 * 
	 * 4) land .length is 300* 300  < 10^5
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] land = { { 1, 4, 8, 10 }, { 5, 5, 5, 5 }, { 10, 10, 10, 10 }, { 10, 10, 10, 20 } };

		int height = 3;

		System.out.println(solution(land, height));

	}

	static int[][] map;

	public static int solution(int[][] land, int height) {
		int answer = 0;
		map = new int[land.length][land.length];
		for (int i = 0; i < land.length; i++) {
//			map[i] = Arrays.copyOf(land[i], land.length);	 // deep copy : 직관적, 구조상 System.arraycopy 사용함.
		     System.arraycopy(land[i], 0, map[i], 0, land[i].length); // deep copy 2번째 방법 : native 

		}
		
		//결과 확인 : land 에는 -1 값 들어가지 않음 
		for (int i = 0; i < land.length; i++) {
			map[2][i] = -1;
		}
		
		
//		for (int i = 0; i < map.length; i++) {
//			for (int j = 0; j < map[i].length; j++) {
//				int v = map[i][j];
//				int v1 = move(new int[i][j], 1);
//				int v2 = move(v, 2);
//				int v3 = move(v, 3);
//				int v4 = move(v, 4);
//
//			}
//		}

		return answer;
	}

	private static int move(int arr[], int away) {
		// TODO Auto-generated method stub
		switch (away) {
		case 1:

			break;
		}
		return 0;
	}
}
