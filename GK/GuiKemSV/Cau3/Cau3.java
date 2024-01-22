import java.util.Stack;

public class Cau3 {
    public static int calculate(String[] expression) {
        Stack<String> s = new Stack<>();
        int o3 = 0;
        for(String str : expression) {
            if(str.equals("+") || str.equals("-")) {
                int o1 = Integer.parseInt(s.pop());
                int o2 = Integer.parseInt(s.pop());
                if (str.equals("+")) {
                    o3 = o2 + o1;
                    s.push(Integer.toString(o3));
                } else {
                    o3 = o2 - o1;
                    s.push(Integer.toString(o3));
                }
                
            } else {
                s.push(str);
            }
        }
        return o3;
    }

    public static void main(String args[]){
		System.out.println(calculate(new String[]{"3", "4", "+", "2", "1", "+", "-"}));

	}
}