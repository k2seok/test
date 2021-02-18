public class programmers_12904{
//Solution

   public static void main(String[] args) {
//      System.out.println(solution("zabbabzzcdcdcz"));// 7
	   
	   StringBuffer sb = new StringBuffer();
	   sb.append("a");
	   sb.append("b");
	   System.out.println(sb.toString());
      System.out.println(solution("zbdabdabddd"));//3
   }

   public static int solution(String s) {

      return recur(s);

   }

   private static int recur(String s) {
      if (s.length() <= 1) // min 1
         return 1;
      
      ///TODO: memoization
      

      StringBuffer sb = new StringBuffer();
      sb.append(s);
      if (sb.reverse().toString().equals(s)) // palin
         return s.length();
      else {
         return Math.max(recur(s.substring(0, s.length()-1)), recur(s.substring(1, s.length())));
      }
   }
}