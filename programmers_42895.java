package tester;

import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

public class programmers_42895 {

	/*
	 * 개선방안 : map 에 n 으로 계산한 모든 결과값을 입력
	 * map^2 만큼 사칙연산
	 * 작은수끼리 계산하다가, 일치하면 반환, 없으면 -1
	 */
	public int solution(final int N, final int number) {
//		int answer = -1;

		
		if(N == number)
			return 1;
		
		
		Vector<Set<Integer>> data = new Vector<Set<Integer>>();

		
		int[] arr = new int[9];
		int idx = 1;
		data.add(null); // 0번 idx 는 null
		for (int i = 1; i <= 11111111; i = i*10 + 1) {
			Set<Integer> set =  new HashSet<Integer>();
			set.add(i*N);
			data.add(set);
			
			arr[idx] = i*N; 
			if(i*N == number)
				return idx;
			idx++;
		}
		
		//정렬로 사칙연산 수행
		for (int i = 1; i < 9; i++) {
			for (int j = 1; j <= i; j++) {
				int use =  i + j;
				if(use > 8)
					break;
				data.get(use).add(arr[i] + arr[j]);
				data.get(use).add(arr[i] - arr[j]);
				data.get(use).add(arr[i] * arr[j]);

				if(arr[j] > 0)
					data.get(use).add(arr[i] / arr[j]);
				
			}
		}
		
		//결과 끼리 재연산
		for (int i = 1; i < 8; i++) {
			for (int j = 1; j <= i; j++) {
				final int use = i + j;
				if(use > 8 || i > 7)
					continue;
				for (int a : data.get(i)) {
					for (int b : data.get(j)) {
						
						data.get(use).add(a + b);
						data.get(use).add(a - b);
						data.get(use).add(a*b);

						if(b > 0)
							data.get(use).add(a/b);
					}
				}
			}
			
			//결과 확인
			if(data.get(i).contains(number))
				return i;
		}
		
		
		return -1;
	}

}
