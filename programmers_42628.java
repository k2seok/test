import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * https://programmers.co.kr/learn/courses/30/lessons/42628
 * 
 * priorityQ 는 insert 시마다 정렬됨.
 * LinkedList 를 만들고, Delete 시에만 정렬(insert 된 값이 없으면 정렬하지 않음) 으로 처리하면 더 효율적
 * 
 * 
 */
public class programmers_42628 {
//Solution

	public static int[] solution(String[] operations) {
		class lQ {
			int i;

			lQ next;
			lQ prev;
			
			
			

			public lQ(int i) {
				this.i = i;
			}

			public void add(lQ next) {
				this.next = next;
				next.prev = this;
			}

			public lQ next() {
				return this.next;
			}

			public lQ prev() {
				return this.prev;
			}

			public int compare(lQ next) {
				if (next == null)
					return 0; // can added
				else if (next.i > this.i)
					return 1;
				else if (next.i <= this.i)
					return -1;

				return 0;
			}
		}

		int[] answer = {};

		lQ lq = null; // always min

		for (String oper : operations) {
			String[] arr = oper.split(" ");
			String sep = arr[0];
			Integer i = Integer.parseInt(arr[1]);
			if ("I".equals(sep)) {
				lQ now = new lQ(i); // 입력할 값
				if (lq == null)
					lq = now; // 비어있는 경우 입력
				else {
					lQ idx = lq;

					while (idx != null) {
						if (idx.compare(now) > 0) {
							if (idx.next == null) {
								// now가 최고값
								idx.add(new lQ(i));
								break;
							} else
								idx = idx.next;
						} else { // 현재 지점보다 now가 작으로, idx-1 now idx 로 연결
							if (idx.prev != null) {
								now.next = idx;
								now.prev = idx.prev;
								idx.prev.next = now;
								idx.prev = now;
							} else {
								idx.prev = now;
								now.next = idx;
							}
							break;
						}
					}

//					for (lQ now = lq; lq.next() != null; lq = lq.next()) {
//					}
				}

			} else if ("D".equals(sep)) {// "D"
//				if(minQ.size() < 1 )
//					continue;
//				
//				int v = 0; 
//				if(i > 0) {
//					v = minQ.poll();
//					maxQ.
//				}else {
//					
//				}
//				
//				int a =  i > 0 ? pQ.poll() : pQ.;
			}

		}

		return answer;
	}

	public static void main(String args[]) {

//		String[] oper = new String[] { "I 16", "D 1" };
		String[] oper = new String[] { "I 1", "I 6", "I 5", "I 16", "I 1" };
		System.out.println(solution(oper));

	}
}
