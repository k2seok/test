package tester;

import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

public class programmers_42895 {

	/*
	 * ������� : map �� n ���� ����� ��� ������� �Է�
	 * map^2 ��ŭ ��Ģ����
	 * ���������� ����ϴٰ�, ��ġ�ϸ� ��ȯ, ������ -1
	 */
	public int solution(final int N, final int number) {
//		int answer = -1;

		
		if(N == number)
			return 1;
		
		
		Vector<Set<Integer>> data = new Vector<Set<Integer>>();

		
		int[] arr = new int[9];
		int idx = 1;
		data.add(null); // 0�� idx �� null
		for (int i = 1; i <= 11111111; i = i*10 + 1) {
			Set<Integer> set =  new HashSet<Integer>();
			set.add(i*N);
			data.add(set);
			
			arr[idx] = i*N; 
			if(i*N == number)
				return idx;
			idx++;
		}
		
		//���ķ� ��Ģ���� ����
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
		
		//��� ���� �翬��
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
			
			//��� Ȯ��
			if(data.get(i).contains(number))
				return i;
		}
		
		
		return -1;
	}

}
