public class Ex2 {
    public static int func(int n) {
        if(n == 1)  return 3;
        return (int)Math.pow(2, n) + (int)Math.pow(n,2);
    }
    
    public static void main(String[] args) {
        MyStack<Integer> ms = new MyStack<>();
        
        for(int i = 4; i > 0; i--) {
            ms.push(func(i));
        }
        ms.print();
        int total = 0;
        while(!ms.isEmpty()) {
            total += ms.pop();
        }
        ms.print();
        System.out.println(total);
        
    }
}
