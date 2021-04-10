import java.util.Arrays;
import java.util.TreeSet;

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
	 * 모든, 연결에서 최소의 연결값을 지정 > 최소신장트리 (Minimum Spanning Tree)
	 * 프림알고리즘 : 
	 * 1)임의의 votex 에서 시작, 
	 * 2)트리 내부의 두 votex가 선택되지않는한에서, 트리를 만들면서 간선을 잇는다. 
	 * 2-1)간선은 최소가중치 부터 잇는다. (가중치 오름차순 정렬필요)
	 * 3)모든 간선이 이어진 경우, MST가 이루어진다.
	 * 
	 * @param n
	 * @param costs
	 * @return
	 */
	public static int solution(int n, int[][] costs) {
		int answer = 0;
		
		//init TODO : 간선의 가중치를 만드는 알고리즘
		TreeSet<Integer> tree = new TreeSet<Integer>();
		
		int[] vArr = new int[costs.length];
		int[] iArr = new int[costs.length];
		for (int i = 0; i < costs.length; i++) {
			vArr[i] = costs[i][2]; // v
		}
//		Arrays.sort(vArr);
//		for (int i = 0; i < vArr.length; i++) {
//			for (int j = 0; j < iArr.length; j++) {
//			}
//		}
		
		
//		int linkCount = 0;
//		boolean visit[] = new boolean[n];
//		tree.add(0);
//		
//		while(tree.size() == n) {
//			//1
//			
//		
//		}
		
		return answer;
	}

}
