import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 
 * https://programmers.co.kr/learn/courses/30/lessons/42628
 * 
 * priorityQ 는 insert 시마다 정렬됨. LinkedList 를 만들고, Delete 시에만 정렬(insert 된 값이 없으면
 * 정렬하지 않음) 으로 처리하면 더 효율적
 * 
 * 
 */
public class programmers_42628 {
//Solution
	public static int[] solution(String[] operations) {
		int[] answer = {};

		Comparator<Integer> asc = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		};
		
		List<Integer> list = new LinkedList<Integer>();
		boolean isChange = false;
		for (String oper : operations) {
			String sep = oper.split(" ")[0];
			int i = Integer.parseInt(oper.split(" ")[1]);

			if("I".equals(sep)) {// "I"
				list.add(i);
				isChange = true;
			} else if ("D".equals(sep)) {// "D"
				if(isChange) {
					list.sort(asc);
					isChange = false;
				}
				
				int dum = 0;
				if(list.size() >0)
					dum = i > 0 ? list.remove(list.size()-1): list.remove(0);

			}
		}
		
		if(list.size() > 0) {
			list.sort(asc);
			answer = new int[] {list.get(list.size()-1), list.get(0)};
		}else {
			answer = new int[] {0,0};
		}
		


		return answer;
	}

	public static void main(String args[]) {

//		String[] oper = new String[] { "I 16", "D 1" }; // 0 0
//		String[] oper = new String[] { "I 1", "I 6", "I 5", "I 16", "I 1" };
//		String[] oper = new String[] { "I 1", "I 6", "D -1", "D -1", "I 1" };
		String[] oper = new String[] {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"}
;
		

		System.out.println(Arrays.toString(solution(oper)));

	}
}
