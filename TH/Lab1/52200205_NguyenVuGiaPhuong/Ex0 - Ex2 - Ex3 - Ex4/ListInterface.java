
import java.util.NoSuchElementException;

public interface ListInterface<E> {
    public void addFrist(E item);
    public void addAfter(Node<E> curr, E item);
    public void addLast(E item);
    public E removeFrist() throws NoSuchElementException;
    public E removeAfter(Node<E> curr) throws NoSuchElementException;
    public E removeLast() throws NoSuchElementException;
    public E removeCurr(Node<E> curr) throws NoSuchElementException;
    public int size();
    public boolean contains(E item);
    public void print();
    public boolean isEmpty() throws NoSuchElementException;
    public Node<E> getHead();
    public E getFrist();
} 