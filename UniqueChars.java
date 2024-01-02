/** String processing exercise 2. */
public class UniqueChars {
    public static void main(String[] args) {  
        String str = args[0];
        System.out.println(uniqueChars(str));
    }

    /**
     * Returns a string which is identical to the original string, 
     * except that all the duplicate characters are removed,
     * unless they are space characters.
     */
    public static String uniqueChars(String s) {
        String answer = "";
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            for (int j = 0; j < answer.length(); j++){
                if (s.charAt(i) == answer.charAt(j) && s.charAt(i) != ' '){
                    count++;
                }
            }
            if (count == 0){
                answer+= s.charAt(i);
            }
            count = 0;
        }
        return answer;
    }
}
