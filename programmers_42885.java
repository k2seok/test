
import java.util.Arrays;
import java.util.HashSet;

public class programmers_42885 {
//Solution
	
	/**
	1) 오름차순 정렬
	2) limit 중간값 나눔
	3) 하나씩 greedy 입력 
	 
	    
	
	**/
	static public int solution(int[] people, int limit) {
		int answer = 0;

		int count = 0;

		Arrays.sort(people);

			for (int i = people.length -1; i >= 0; i--) {
				
				if(people[i] < 1) continue; // use
				int a = people[i];
				boolean find = false; 
				for (int j = i -1 ; !find && j >= 0; j--) {
					if(people[j] < 1) continue; //use
					int b = people[j];
					
					if(a + b <= limit) { //find
						answer++;
						count +=2;
						find = true;
						people[i] = -1;
						people[j] = -1;
					}
				}
				
				if(!find) {
					answer++;
					people[i] = -1;
					count++;
				}

		}

		return answer;
	}

	static public void main(String args[]) {
//		[70, 50, 80, 50]	100	3
		System.out.println(solution(new int[] { 70, 50, 80, 50 }, 100)); // 3
	}

}
