public class Ex4 {
    public static boolean balanced(String str) {
        MyStack<Character> msc = new MyStack<>();
        char[] c = new char[str.length()];
        c = str.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if(c[i] == '(' || c[i] == '{' || c[i] == '[') {
                msc.push(c[i]);
            }
            if(c[i] == ')' && msc.getPeek() == '(')     return true;
            if(c[i] == '}' && msc.getPeek() == '{')     return true;
            if(c[i] == ']' && msc.getPeek() == '[')     return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        System.out.println(balanced("sa(as[asdv{aaa])"));
        System.out.println(balanced("sa(as[asdv{aaa}])"));
    }
}
