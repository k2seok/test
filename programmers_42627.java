import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * https://programmers.co.kr/learn/courses/30/lessons/42627
 * 
 * readyQueue : time 이 되지않아 대기중 
 * runQueue : runnable 한 값, 최소값 찾아서 실행 read,
 * runnable is empty 인경우 종료
 */
public class programmers_42627 {

	static final int I = 0;
	static final int J = 1;

	public static int solution(int[][] jobs) {
		int answer = 0;

		PriorityQueue<int[]> readyQueue = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[I] - o2[I];
			}
		});
		PriorityQueue<int[]> runnableQueue = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[J] - o2[J];
			}
		});

		for (int[] job : jobs) {
			readyQueue.add(job);
		}
		for (int[] is : readyQueue) {
			System.out.println(Arrays.toString(is));
		}

		long time = readyQueue.peek()[I];// min Run Time
		while (!readyQueue.isEmpty() || !runnableQueue.isEmpty()) {
			// input runnable
			int size = readyQueue.size();
			for (int i = 0; i < size; i++) {
				int[] job = readyQueue.poll();
				if (job[I] <= time)
					runnableQueue.offer(job);
				else {
					readyQueue.add(job);
					break; // 이후 값은 모두 !runnable 함
				}
			}

			if (!runnableQueue.isEmpty()) {
				time += runnableQueue.poll()[J];
			} else //
				time += readyQueue.peek()[I] - time; // 다음 실행시간까지 더함.

		}
		return (int) (time / jobs.length);
	}

	public static void main(String args[]) {

		int[][] com = { { 0, 3 }, { 1, 9 }, { 2, 6 } }; // answer : 9
		System.out.println(solution(com));

	}
}
