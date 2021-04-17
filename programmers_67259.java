import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Vector;

public class programmers_67259 {
//Solution

	
	/*
	 * BFS : 최소값 찾기
	 * con: 도착시 최소값이 아닌경우 삭제 > 모든 경우 체크 필요  
	 */
	static int[][] map = null;
	
	static int I  = 0;
	static int J  = 1;
	static int V  = 2;
	static int W  = 3; //way
	
	static public int solution(int[][] board) {
		int answer = Integer.MAX_VALUE;
		
		map = board;
		map[0][0] = 100;
//		int[] now = new int[] {0,0};
		// i,j , nowCost
		Queue<int[]> queue = new ArrayDeque<int[]>(); 
		
		queue.add(new int[] {0,0,100,0}); // 최초 cost : 100
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			
			for (int i = 0; i < map.length; i++) {
				System.out.println(Arrays.toString(map[i]));
			}
			System.out.println();
			
			if(now[I] == map.length -1 && now[J] == map.length -1) //end
			{
				answer = now[V] < answer ? now[V] : answer;
			}
			
			if(now[V] >= answer)
				continue; //버림처리
			
			
			//up
			if(!isWall(new int[] {now[I] -1 , now[J]})) {
				int v = getCost(now, 1);
				int[] next = new int[] {now[I] -1, now[J], now[V] + v, 1};
				
				//move
				if(map[next[I]][next[J]] < 1) {
					map[next[I]][next[J]] = next[V];
					queue.add(next);
				}else {
					if(map[next[I]][next[J]] > next[V])//작은경우에만 이동,
					{
						map[next[I]][next[J]] = next[V];
						queue.add(next);
					}
				}
			}
			//right
			if(!isWall(new int[] {now[I] , now[J] + 1})) {
				int v = getCost(now, 2);
				int[] next = new int[] {now[I], now[J] +1, now[V] + v, 2};
				
				//move
				if(map[next[I]][next[J]] < 1) {
					map[next[I]][next[J]] = next[V];
					queue.add(next);
				}else {
					if(map[next[I]][next[J]] > next[V])//작은경우에만 이동,
					{
						map[next[I]][next[J]] = next[V];
						queue.add(next);
					}
				}
			}
			//down
			if(!isWall(new int[] {now[I] + 1 , now[J]})) {
				int v = getCost(now, 3);
				int[] next = new int[] {now[I] + 1, now[J], now[V] + v, 3};
				
				//move
				if(map[next[I]][next[J]] < 1) {
					map[next[I]][next[J]] = next[V];
					queue.add(next);
				}else {
					if(map[next[I]][next[J]] > next[V])//작은경우에만 이동,
					{
						map[next[I]][next[J]] = next[V];
						queue.add(next);
					}
				}
			}
			//left
			if(!isWall(new int[] {now[I] , now[J] -1})) {
				int v = getCost(now, 4);
				int[] next = new int[] {now[I], now[J] - 1, now[V] + v, 4};
				
				//move
				if(map[next[I]][next[J]] < 1) {
					map[next[I]][next[J]] = next[V];
					queue.add(next);
				}else {
					if(map[next[I]][next[J]] > next[V])//작은경우에만 이동,
					{
						map[next[I]][next[J]] = next[V];
						queue.add(next);
					}
				}
			}
			
		
		}
		
		
		return answer;
	}

	private static int getCost(int[] now, int way) {
		//최초 이동인경우에도 처리
		if(now[W] == 0)
			return 100;
		
		if(now[W]%2 > 0) //ver
		{
			return now[W]%2 > 0 ? 100 :500; 
		}else //if(way%5 == 2 || way%5 == 4) 
		{
			return now[W]%2 > 0 ? 500 :100;
		}

	}


	private static boolean isWall(int[] now) {
		if(now[I] < 0 || now[J] < 0 )
			return true;
		if( now[I] >= map[0].length || now[J] >= map[0].length )
			return true;
		
		if(map[now[I]][now[J]] == 1)
			return true;
		
		return false;
}

	public static void main(String[] args) {

		int[][] board = null;
		
		board = new int[][]
			{{0,0,0},{0,0,0},{0,0,0}};
		System.out.println(solution(board));
		board = new int[][]
		{{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}};
		System.out.println(solution(board));

	}
}