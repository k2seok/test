import java.util.Arrays;
import java.util.HashMap;
import java.util.Vector;

public class programmers_42579 {

	final static int IDX_MAX = 10000;
	static int genresCnt;

	public static class gen {
		String name = "";
		int num;
		Vector<Integer> plays = new Vector<Integer>();

		public gen(String name, int num) {
			this.name = name;
			this.num = num;
			plays.add(num);
		}

		public void sort() {
			Arrays.sort(plays.toArray());
		}

	}

	public static int[] solution(String[] genres, int[] plays) {
		genresCnt = 0;
		int[] answer = new int[4];

		HashMap<String, gen> map = new HashMap<String, gen>();
		// 1. 최고 재생된 장르 : plays[i]의 모든 gneres[i] 의 합
		for (int i = 0; i < genres.length; i++) {

			String gen = genres[i];
			int play = plays[i];

			if (map.containsKey(gen)) {// exist
				gen now = map.get(gen);
				now.num += plays[i];
				now.plays.add(play);

			} else { // exist
				map.put(gen, new gen(gen, play));
			}
		}

		// 2. 장르 내 가장 plays[i] 가 가장 큰 값 2개
		for (int i = 0; i < 2; i++) {
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
			now.sort();
			for (int j = 0; j < 2; j++) {
				// 3. plays[i] 는 idx 가 적은값 : gen 2개에서 2개 plays 찾기

				int v = now.plays.get(now.plays.size() - 1 - j);
				System.out.println(v); //결과값 value 출력
				answer[i * 2 + j] = v; // TODO : idx 출력으로 변경

			}
			now.num = -1; // pop 처리
			
		}

//		
		return answer;

	}

	public static void main(String[] args) {
		String[] genres;
		int[] plays;

		genres = new String[] { "classic", "pop", "classic", "classic", "pop" };
		plays = new int[] { 500, 600, 150, 800, 2500 };
//				[4, 1, 3, 0]
		solution(genres, plays);
	}
}
