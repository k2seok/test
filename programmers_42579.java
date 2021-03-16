import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class programmers_42579 {
//Solution
	final static int IDX_MAX = 10000;
	
	public static class gen {
		String name = "";
		int num;
		List<int[]> plays = new ArrayList<int[]>();

		public gen(String name, int i, int num) {
			this.name = name;
			this.num = num;
			plays.add(new int[]{i,num});
		}

		public void sort() {
//			Arrays.sort(plays.toArray(),);
			plays.sort(new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o2[1] - o1[1] == 0 ? o1[0] - o2[0] : o2[1] - o1[1]; // DESC, 같은경우 idx ASC
				}
			});
		}

	}

	public static int[] solution(String[] genres, int[] plays) {
		int[] answer = new int[IDX_MAX];
		int cnt = 0;

		HashMap<String, gen> map = new HashMap<String, gen>();
		// 1. 최고 재생된 장르 : plays[i]의 모든 gneres[i] 의 합
		for (int i = 0; i < genres.length; i++) {

			String gen = genres[i];
			int play = plays[i];

			if (map.containsKey(gen)) {// exist
				gen now = map.get(gen);
				now.num += plays[i];
				now.plays.add(new int[]{i,play});

			} else { // not exist
				map.put(gen, new gen(gen, i, play));
			}
		}

		// 2. 장르 내 가장 plays[i] 가 가장 큰 값 2개
		for (int i = 0; i < map.size(); i++) {
			int max = 0;
			String maxKey = "";
			for (gen now : map.values()) {
				if (now.num > max) {
					max = now.num;
					maxKey = now.name;
				}
			}

			// 최고값
			gen now = map.get(maxKey);
			if(now == null || max < 1) // 결과 없음
				break;
			now.sort();  // 정렬
			for (int j = 0; j < now.plays.size(); j++) {
				if(j == 2) {
					break; // 2개씩만 입력됨
				}
				
				int idx = now.plays.get(j)[0]; // idx 가져오기
				answer[cnt++] = idx;

			}
			now.num = -1; // pop 처리
//			map.remove(maxKey);
			
		}

//		
		return Arrays.copyOfRange(answer, 0, cnt);  // 1 <= answer.Len <= gen*2

	}
	
	public static void main(String[] args) {
		String[] genres;
		int[] plays;

//		genres = new String[] { "classic", "pop", "classic", "classic", "pop" };
//		genres = new String[] { "classic", "z", "classic"  };
//		plays = new int[] { 1000, 500, 100}; // 1 2

//		genres = new String[] {"pop", "pop", "pop", "rap", "rap"};
////	    plays = new int[]{45,50,40, 60, 70}; // [ 1, 0, 4, 3]
//	    plays = new int[]{45,45,40, 60, 70}; // [  0, 1, 4, 3]
				
	    
	    //장르의 속한곡이 1개일 때 케이스 테스트
//		genres = new String[] {"a", "a", "a", "a", "a"};
//		plays = new int[] { 5, 5, 40, 5, 5}; // [ 1, 0, 4, 3]


	    //장르가 2개를 넘는 경우 : answer 는  1장르 * 2개씩 출력
		genres = new String[] {"a", "b", "b", "c", "c"};
		plays = new int[] { 5, 5, 40, 5, 5}; // [ 1, 0, 4, 3]

		
		
		System.out.println(Arrays.toString(solution(genres, plays)));
	}
}