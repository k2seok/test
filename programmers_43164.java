import java.util.Arrays;

public class programmers_43164 {
//Solution
   /**
    * 
    * 
    * 여행경로 start > end 간선이 주어졌을때 모두 이동하는 순서 구하기
    * 
    * end : 주어진 항공권은 모두 사용해야 합니다 len(tickets)
    * 
    * 1) tickets[idx] 에서 key , String values add 1.1) map . sorting //알파벳순 2) ICN
    * 에서 0 부터 이동, 이동한 값의 다음 key 값으로 이동 2.2 ) 2의 value input 2.2 key .. iterate
    * 
    * @param args
    */
   public static void main(String[] args) {
      // TODO Auto-generated method stub


      String[][] tickets;
      tickets = new String[][] { { "ICN", "JFK" }, { "HND", "IAD" }, { "JFK", "HND" } };
//      tickets = new String[][] { { "ICN", "ZZZ" }, { "ICN", "JFK" }, { "HND", "IAD" }, { "JFK", "HND" } };
      System.out.println(Arrays.toString(solution(tickets)));

   }

   public static class port {
      String key;
      String values = "";
      String[] tickets;

      public port(String key) {
         this.key = key;
      }

      public void add(String v) {
         values += "," + v;
      }
   }

   static int end = 0;
   static String answer = "";
   final static int _MAXPORT = 10000;

   public static String[] solution(String[][] tickets) {

      end = tickets.length + 1;
      port[] arrP = new port[end];

      int idx_ICN = -1;
      for (int idx = 0; idx < tickets.length; idx++) {
         String key = tickets[idx][0];
         String value = tickets[idx][1];

         for (int i = 0; i < arrP.length; i++) {

            if (arrP[i] == null) { // end
               arrP[i] = new port(key);
               arrP[i].add(value);

               if (idx_ICN < 0 && key.equals("ICN"))
                  idx_ICN = i;
               break;
            } else if (arrP[i].key.equals(key)) {
               arrP[i].add(value);

               if (idx_ICN < 0 && key.equals("ICN"))
                  idx_ICN = i;
               break;
            }
         }
      }

      // 1.1 sort
      for (int i = 0; i < arrP.length; i++) {
         if (arrP[i] == null)
            break;
         String[] arr = arrP[i].values.split(",");
         Arrays.sort(arr);
         arrP[i].tickets = arr;
      }

      // 2 move 0 to end

      goEnd("ICN", arrP.clone(), 1, "");
      return answer.split(",");
   }

   private static boolean goEnd(String _nowK, port[] arrP, int use, String log) {
      // port nowP = arrP[idxS];
      log += "," + _nowK;

      if (use >= end) {
         answer = log.substring(1);
         return true; // success
      }

      // find next idx
      int nowIdx = -1;
      for (int j = 0; j < arrP.length; j++) {
         if (arrP[j] == null) // end
            return false;
         else if (_nowK.equals(arrP[j].key)) {
            nowIdx = j;
            break;
         }
      }

      // 0 is dummy
      for (int i = 0; i < arrP[nowIdx].tickets.length; i++) {
         String next = arrP[nowIdx].tickets[i];
         if (next.length() < 1)
            continue;
         arrP[nowIdx].tickets[i] = ""; // 사용한 값 dummy 처리
         if (goEnd(next, arrP, use + 1, log))
            return true;
         arrP[nowIdx].tickets[i] = next; // rollback
      }
      // TODO Auto-generated method stub

      return false;
   }
}