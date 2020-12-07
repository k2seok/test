package tester;

import java.util.ArrayDeque;
import java.util.Queue;

public class programmers_42895 {

	// �ּڰ��� 8���� ũ�� -1�� return �մϴ�. or N > number
	// ����Ǽ�
	// + - / * add(*10+N)
	// ���� now == numbe r���� Ȯ��
	public int solution(final int N, final int number) {
		int answer = 0;

		if (N == number)
			return 1;

		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.add(N);

		/*
		 * number ���� �������, round����
		 * 
		 * number - 
		 */

		/// end���� : 8�� ������ ���, �ּҰ��� ������ �����
		int end = 9;
		for (int round = 2; round < end; round++) { // min
			int size = queue.size();
			
			for (int i = 0; i < size; i++) {

				int now = queue.poll();

				if (true || now * 10 + N <= number) { // add
					int next = now * 10 + N;
					// end?
					if (next == number) {
						answer = round;	 //�ݵ�� �ּҰ�
						return endReturn(answer, end);

					}
					end = checkPlus(next, round, number, N, end);
					queue.add(next);
				}

				if (true || now * N <= number) { // *
					int next = now * N;
					// end?
					if (next == number) {
						answer = round; //�ݵ�� �ּҰ�
						return endReturn(answer, end);
					}
					end = checkPlus(next, round, number, N, end);
					queue.add(next);
				}

				if (true || now / N <= number) { // divide
					int next = now / N;
					// end?
					if (next == number) {
						answer = round; //�ݵ�� �ּҰ�
						return endReturn(answer, end);
					}
					end = checkPlus(next, round, number, N, end);
					queue.add(next);
				}

				if (true || now + N <= number) { // +
					int next = now + N;
					// end?
					if (next == number) {
						answer = round; //�ݵ�� �ּҰ�
						return endReturn(answer, end);
					}
					end = checkPlus(next, round, number, N, end);
					queue.add(next);
				}

				if (true || now - N <= number) { // +
					int next = now - N;
					// end?
					if (next == number) {
						answer = round; //�ݵ�� �ּҰ�
						return endReturn(answer, end);
					}
					end = checkPlus(next, round, number, N, end);
					queue.add(next);
				}
			}

		}

		return endReturn(answer, end);
	}

	private int endReturn(int answer, int end) {
		if(answer < 1 && end > 8)
			return -1;

		if(answer > 0  && answer < end)
			return answer;

		if(end < 9)
			return end;		
		
		return -1;
	}

	private int checkPlus(int next, int round, final int number, final int N, int end) {
		// N���� �������
		/**
		 * N -1 N n-2 
		 */
		int newEnd = round;
		int exist = Math.abs(number - next);

		if(exist < N) { //  -(exist*2) �� �ּ�ȭ����
				/**
				 * 1�̻� ���̳���� (N+N + ..)N ���� ǥ������
				 * ���� �߰�
				 * 5 557 6
				 * 5 558 7
				 * 557 = 555 + (5+5)/5   result : 6 
				 */
			newEnd+=exist + 1;
			return end < newEnd ? end : newEnd;
		}
		
		return end;
		
	}
}
