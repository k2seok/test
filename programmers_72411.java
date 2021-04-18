import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class programmers_72411 {


	//Solution
	public static void main(String[] args) {
		
		String[] orders = null;
		int[] course  = null;
		
		
		orders = new String[] {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		 course = new int[] {2,3,4};
		System.out.println(Arrays.toString(solution(orders, course)));

orders = new String[] {"XYZ", "XWY", "WXA"};
		course = new int[] {2,3,4};
		
		System.out.println(Arrays.toString(solution(orders, course)));
	}

	///
	/**
	 *  1) set course 값 만큼 for > orders 모든경우의수 입력, 중복인 경우 + 1
	 *  2) set.get(course[i]).max >>sort 필요
	 *  
	 * @param orders
	 * @param course
	 * @return
	 */
	public static  String[] solution(String[] orders, int[] course) {
		String[] answer = null;
		
		Map<String, Integer> map = new HashMap<String, Integer>(); 
		
		//1 set
		for (String s : orders) {
			String[] order = s.split("");
			Arrays.sort(order); // 입력값 정렬 필
			for (int idx = 0; idx < course.length; idx++) {
				for (int i = 0; i < order.length; i++) {
					int count = course[idx];
					String now = set(order[i], i, count,order);
					if(now.length() > 1)
						map.put(now, map.containsKey(now) ? map.get(now)+ 1 :  1 );
				}
			}
		}
		//2 cal : 모든경우의 s를 입력 후, get() == Max? 
		String arr[] = new String[11]; // 코스 최대값
//		StringBuilder[] sb = new StringBuilder[11];
		Arrays.fill(arr, "");
		int idxM[] = new int[11];
		for (String s : map.keySet()) {
			int idx = map.get(s);
			if(idxM[s.length()] < idx) { //현재 가장큰값이 입력되었으므로, 이전값들은 의미가없음
//				arr[s.length()] = "";
				idxM[s.length()] = idx;
			}
			
			arr[s.length()] +=  s + ","; // answer List
		}

		Vector<String> v = new Vector<String>();
		//3, find max
		for (int i = 0; i < course.length; i++) {
			int len = course[i];
			
			String[] answers = arr[len].split(",");
//			Arrays.sort(answers);
			if(idxM[len] < 2) continue;  //최소 2이상 
			
			for (int j = 0; j < answers.length; j++) {
				if(map.get(answers[j]) == idxM[len] &&  answers[j].length() > 1) //, 제거
					v.add(answers[j]);
			}
		}
		
		//put
		answer = new String[v.size()];
		
		for (int i = 0; i < v.size(); i++) {
			answer[i] = v.get(i);
			
		}
		Arrays.sort(answer);
		
		return answer;
	}

	private static String set(String s, int start, int count, String[] order) {
		if(s.length() >= count)
			return s;
		for (int i = start; i < order.length; i++) {
			if(!s.contains(order[i]))
				return set(s + order[i], start +1, count, order);
		}
		return ""; // end 
	}

}