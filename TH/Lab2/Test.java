public class Test {
    public static void main(String[] args) {
        MyQueue<Integer> mq = new MyQueue<Integer>();
        System.out.println("---MyQueue---");
        mq.enQueue(59);
        mq.enQueue(22);
        mq.enQueue(33);
        mq.enQueue(8);
        mq.enQueue(66);
        mq.print();

        mq.deQueue();
        mq.print();
    }
}