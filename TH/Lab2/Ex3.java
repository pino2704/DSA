public class Ex3 {
    public static void main(String[] args) {
        String str = "AB CDE F";
        MyStack<Character> msc = new MyStack<>();
        char a[] = new char[str.length()];
        a = str.toCharArray();
        for(int i = 0; i < a.length; i++) {
            msc.push(a[i]);
        }
        for(int i = 0; i < a.length; i++) {
            a[i] = msc.pop();
        }
        System.out.println(a);
    }
}
