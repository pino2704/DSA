import java.util.Stack;
public class Cau2 {
    public static String reverseVowels(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (Character.toLowerCase(str.charAt(i)) == 'u' || Character.toLowerCase(str.charAt(i)) == 'e' || Character.toLowerCase(str.charAt(i)) == 'o' || Character.toLowerCase(str.charAt(i)) == 'i' || Character.toLowerCase(str.charAt(i)) == 'a') {
                s.push(str.charAt(i));
            }
        }

        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (Character.toLowerCase(ch[i]) == 'u' || Character.toLowerCase(ch[i]) == 'e' || Character.toLowerCase(ch[i]) == 'o' || Character.toLowerCase(ch[i]) == 'i' || Character.toLowerCase(ch[i]) == 'a') {
                ch[i] = s.pop();
            }
        }
        
        str = new String(ch);
        return str;    
        
    }
    public static void main(String[] args) {
        System.out.println(reverseVowels("international"));;
    }
}
