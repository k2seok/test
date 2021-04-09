public class programmers_42861 {
//Solution
	public static void main(String[] args) {
		int[][] costs;
		int n = 0;
		
		n = 4 ;costs= new int[][]{{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}}; //4
		System.out.println(solution(n, costs));
		
		// 섬의 2그룹 
		n = 4 ;costs= new int[][]{{0,1,5},{0,2,5},{1,2,5},{1,3,5},{2,3,5}}; //4
		System.out.println(solution(n, costs));
		
		//섬의 2그룹 2
		n = 5 ;costs= new int[][]{{0,1,1},{0,2,2},{1,2,5},{1,3,3},{2,3,8},{3,4,1}}; //;7
		System.out.println(solution(n, costs));

	}

	/**
	 * 모든, 연결에서 최소의 연결값을 지정
		goal: 모든 n 을 연결하였을때의 최소값을 찾기
		트리구조로 생각, 시작노드를 찾는것이 중요, 내가 찾은 값이 최소라는 보장이 되는방법?
		모든 cost를 더한값 : 최대값
		최소 cost를 이용한값 : 최소값
		1) answer = 최소 연결값을 찾아 합함
		2) 1의 결과로 모든 연결이 이루어지지않음(visit == all? 1 : answer)
	 * @param n
	 * @param costs
	 * @return
	 */
	public static int solution(int n, int[][] costs) {
		int answer = 0;
		
		//init
		int map[][] = new int[n][n];
		for (int i = 0; i < costs.length; i++) {
			final int I = costs[i][0];
			final int J = costs[i][1];
			final int V = costs[i][2];
			map[I][J] = V;
			map[J][I] = V;
		}
		int linkCount = 0;
		boolean visit[] = new boolean[n];
		
		while(linkCount != n-1) {
			//1
			for (int i = 0; i < visit.length; i++) { // i 번 섬에서 최소이동길이 찾기
				int minV = -1;
				int idx = -1;
				
				for (int j = 0; j < n; j++) {
					if(i == j || map[i][j] < 1 ) continue;
					//get
					minV = minV < 0 ? map[i][j] :  minV < map[i][j] ? minV : map[i][j];
					if(minV == map[i][j])
						idx = j;
				}
				
				//find
				if(idx > -1) {
					answer += map[i][idx]; //link
					linkCount++;
					map[i][idx] = -1; // 비워주기
					map[idx][i] = -1; // 비워주기
					
					if(!visit[i]) {
						visit[i] = true;
					}
					
					if(!visit[idx]) {
						visit[idx] = true;
					}
				}
				
				if(linkCount == n -1) // end
					break;
			}
			
			
			
		}
		
		return answer;
	}

}
