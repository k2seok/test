
import java.util.Arrays;
import java.util.HashSet;

public class programmers_42885 {
//Solution
	
	/**
	1) 오름차순 정렬
	2) limit 중간값 나눔
	3) 하나씩 greedy 입력 
	 
	    
	
	**/
	static  int[] arr;
	static public int solution(int[] people, int limit) {
		int answer = 0;

		int count = 0;
		arr = people.clone();
		
			for (int i = people.length -1; i >= 0; i--) {
				Arrays.sort(people); // -1 갱신

				if(people[i] < 1) continue; // use
				int a = people[i];
				// findCal() : DP
				
				int idx = findCal(count, i-1, limit - a);
				
				if(idx >= 0) {
					answer++;
					count +=2;
					people[i] = -1;
					people[idx] = -1;
				
				}else if(idx <= -1) {
					answer++;
					people[i] = -1;
					count++;
				}

		}

		return answer;
	}

	private static int findCal(int start, int end, int v) {
		if(start < 0 || end < 0)
			return -1;
		
		int idx = (start + end)/2;
		
		if(v > arr[idx]) {
			return findCal(idx + 1, end, v);
		}else if(v < arr[idx]) {
			return findCal(start, idx -1, v);
		}
		else if(v == arr[idx]){ 
			return idx;
		}
		
		return -1; //not Find;
	}

	static public void main(String args[]) {
//		[70, 50, 80, 50]	100	3
		System.out.println(solution(new int[] { 70, 50, 80, 50 }, 100)); // 3
	}

}
