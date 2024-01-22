public class Ex6 {
    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama".toLowerCase();
        MyStack<Character> msc = new MyStack<>();
        MyQueue<Character> mqc = new MyQueue<>();
        char[] c = str.toCharArray();

        String strR1 = "";
        for(char ch : c) {
            if (Character.isLetterOrDigit(ch)) {
                mqc.enQueue(ch);
            }
        }

        while(!mqc.isEmpty()) {
            strR1 += mqc.deQueue();
        }

        String strR2 = "";
        for(char ch : c) {
            if (Character.isLetterOrDigit(ch)) {
                msc.push(ch);
            }
        }
        while(!msc.isEmpty()) {
            strR2 += msc.pop();
        }
        
        System.out.println(strR1.equals(strR2));

    }
}
