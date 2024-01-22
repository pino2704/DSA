interface QueueInterface<E> {
    public void enQueue(E item);
    public E deQueue();
    public int size();
    public boolean contains(E item);
    public boolean isEmpty();
    public E getFront();
}