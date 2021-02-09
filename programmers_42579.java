import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class programmers_42579 {

	/**
	 * ** 
	 * 1) genres 에서 hashMap key value add 2) key
	 * 
	 * @param N
	 * @param number
	 * @return
	 */
	class playData {
		playData prev;
		playData next;
		int v;

		public playData(int v) {
			this.v = v;
		}

	}

	final static int IDX_MAX = 10000;
	static int genresCnt;

	public static int[] solution(String[] genres, int[] plays) {
		genresCnt = 0;
		int[] answer = {};

		int[] map = new int[IDX_MAX * 100];
		Vector<String> genV = new Vector<String>();
		
//		for (int idx = 0; idx < genresCnt + 1; idx++) { // find idx
//			int idx_Gen = 0;
//			String gen = genres[idx];
//			while(idx_Gen < genresCnt) {
//				if(map[idx_Gen] gen)
//				idx_Gen+=IDX_MAX;
//			}
//			for (int idx_Gen = 0; idx_Gen < map.length; idx_Gen+=IDX_MAX) {
//				//idx_Gen
//			}
//			if (genV.contains(genres[idx])) // exist{
//			{
//				int nowV = plays[idx];
//				for (int prevV : map.get(genres[idx])) {
//					if (prevV < nowV)
//						;
//
//				}
//
//			} else {
//				
//				genV.add(genres[idx]);
//				
////				map[genV.size()*IDX_MAX+1] = new playData(plays[idx]);
////				map.put(genres[idx], data);
//			}
//		}
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
