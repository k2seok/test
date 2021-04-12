
import java.util.Arrays;
import java.util.HashSet;

public class programmers_42885 {

	/**
	1) 오름차순 정렬
	2) limit 중간값 나눔
	3) 하나씩 greedy 입력 
	    max[-1]부터
	    
	    + 남은 값들 DP 식으로 계산
	    
	    int now = limit - max[i];
	    i -1 한 값을 입력가능? 입려 후 종료
	
	    i -1 : 최대값
	    0 : 최소값
	    
	    i - n
	    
	    do{
	    
	    }
	    while(now/2 > min){
	     int n = now/2
	     // 나누고도 더 나눌 수 있으면(n이 작으면) 한번 더 나눔
	     if(n < now)
	     // N = n;
	     else{ // n이 더 큰경우
	     
	     }
	    }
	    
	    min[-1] 
	    
	
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
