package tester;

/**
 * 
 * https://programmers.co.kr/learn/courses/30/lessons/43105?language=java
	//점화식
	// r(idx) =  원본에서 ori[r][idx] (ex : r(4) = 2)
	1 == 1
	2 3  == 2 + 1  3 + 1
	4  5 6 == 4 + 2 5+3 5+4 6+4
	round == n + r-1(n-1)  n+ r-1(n)
 *
 */
class Solution {
	public int solution(final int[][] triangle) {
		int answer = 0;

		int start = triangle[0][0];
		
		answer = start; // min

		int len =  triangle[triangle.length - 1].length;
		int[][] map = new int[len+1][len];
		

        map[0][0] = start;
        
        for (int i = 1; i < triangle.length; i++) {
        	for (int idx = 0; idx < triangle[i].length; idx++) {
        		int now = triangle[i][idx];
        		
        		//현 idx 기준 이전위치값 2개 계산
        		// idx - 1 계산
        		int left = 0, right = 0; 
        		if(idx-1 >= 0  && triangle[i-1].length > idx-1) {
        			left = map[i-1][idx-1];
        		}
        		
        		// idx 계산
    			if(idx >= 0 && triangle[i-1].length > idx ) {
        			right = map[i-1][idx];
        		}

    			map[i][idx] = now + (left > right ? left :right); // 큰 값을 취함
        		
			}
        }
        
        //result
        for (int j = 0; j < map[len-1].length; j++) {
        	answer = answer > map[len-1][j] ? answer : map[len-1][j];
		}

		return answer;
	}
}