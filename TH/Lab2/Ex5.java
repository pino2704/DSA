public class Ex5<E> {
    private MyStack<E> stack1;
    private MyStack<E> stack2;

    public Ex5() {
        stack1 = new MyStack<>();
        stack2 = new MyStack<>();
    }

    public void enQueue(E item) {
        stack1.push(item);
    }

    public E deQueue() {
        if (stack2.isEmpty()) {
            stack2 = new MyStack<>();
            int temp = stack1.size();
            for(int i = 0; i < temp - 1; i++) {
                stack2.push(stack1.pop());
            }
            E tmp = stack1.pop();
            return tmp;
        }
        stack1 = new MyStack<>();
        int temp = stack2.size();
        for(int i = 0; i < temp - 1; i++) {
            stack1.push(stack1.pop());
        }
        E tmp = stack2.pop();
        return tmp;
        
    }


    public static void main(String[] args) {  
        System.out.println("---Implements Queue Using 2 Stacks---");
        Ex5<Integer> iq2s = new Ex5<Integer>();
        iq2s.enQueue(59);
        iq2s.enQueue(22);
        iq2s.enQueue(33);
        iq2s.enQueue(8);
        iq2s.enQueue(66);

        System.out.println(iq2s.deQueue());
        System.out.println(iq2s.deQueue());
        System.out.println(iq2s.deQueue());
        System.out.println(iq2s.deQueue());
        System.out.println(iq2s.deQueue());

    }

}
