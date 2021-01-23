import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class acmicpc_42888 {
//Solution
	/**
	 * //https://programmers.co.kr/learn/courses/30/lessons/42888 오픈채팅방 goal : 문자열
	 * 받아서 입력에맞게 결과 반환 condition : 첫 단어는 Enter, Leave, Change 중 하나이다. 각 단어는 공백으로
	 * 구분되어 있으며, 알파벳 대문자, 소문자, 숫자로만 이루어져있다. 유저 아이디와 닉네임은 알파벳 대문자, 소문자를 구별한다. 유저 아이디와
	 * 닉네임의 길이는 1 이상 10 이하이다.
	 * 
	 */

	public static void main(String args[]) {

		String[] record = null;
		// record = new String[] { "Enter uid1234 Muzi" };
		record = new String[] { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
				"Change uid4567 Ryan" };
		// , "Enter

		// user == hash로 구분

		for (String string : solution(record)) {
			System.out.println(string);
		}
	}

	public static String[] solution(String[] record) {
		Map<String, String> map = new HashMap<String, String>();
		Vector<String> msg = new Vector<String>();

		for (String s : record) {
			String data[] = s.split(" ");
			String data1 = data[1];
			String data2 = "";
			if (data.length > 2)
				data2 = data[2];
			switch (data[0]) {

			case "Enter": // 입장
				map.put(data1, data2);
				msg.add(data1 + "@님이 들어왔습니다.");// Id 로 구분
				break;
			case "Leave":
				msg.add(data1 + "@님이 나갔습니다."); // Id 로 구분
				break;
			case "Change":
				map.replace(data1, data2); //
				break;
			}

		}

		String[] answer = new String[msg.size()];

		for (int i = 0; i < msg.size(); i++) {
			String id = msg.get(i).split("@")[0].toString(); // 구분자를 이용해 id 값 찾기
			String name = map.get(id);
			answer[i] = msg.get(i).replace(id, name).replace("@", "");	// 구분자 제거
		}

		return answer;
	}

}