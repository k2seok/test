
import java.util.HashSet;

public class programmers_42895 {

	/*
	 * 
	 * DP  :  1부터 N 까지 작은계산, 그리고 이후 결과합(memoization) 으로 인한 값 도출.
		1 만으로 가능한지 확인 ...  i  =  max ;  i  >  0 ; i--    &  j = max - i  ; j  > 0 ; j--;  >>>  모든 사칙연산
		2 만으로 가능한지 확인 >> memo[1]  memo[1]
		3 만으로 가능한지 확인 >> memo[2]  memo [1] >> 중복값이 발생할 수 있으니 set 처리
		n 번째에서 결과가 나왔는지 check 
	 */
	static HashSet<Integer>[] memo = new HashSet[10];  // way using Arrays
	static public int solution(final int N, final int number) {
		
		for (int i = 1; i < 9; i++) { // max : 8
			StringBuffer b= new StringBuffer(); 
			for (int j = 0; j < i; j++) {
				b.append(N);
			}
//			System.out.println(b);
			cal(i, Integer.parseInt(b.toString()));
			if(memo[i].contains(number)) // check
				return i;
		}
		return -1;
				
	}

	static private void cal(int idx, int v) {
		if(memo[idx] == null) {
			memo[idx] = new HashSet<Integer>();
			memo[idx].add(v);
		}
		for (int i = idx; i > 0; i--) {
			for (int j = idx - i; j > 0; j--) {
				if(i + j > 8)
					continue;
				
				for (int left : memo[i]) {
					for (int right : memo[j]) {
						memo[i+j].add(left * right);
						memo[i+j].add(left + right);
						if(left - right > 0)
							memo[i+j].add(left - right);
						if(right > 0)
							memo[i+j].add(left / right);
					}	
				}
			}
		}
		
	}
	
	static public void main(String args[]) {
		System.out.println(solution(5, 12)); // 4
		System.out.println(solution(2, 11)); // 3
	}

}
