
import java.util.NoSuchElementException;

public interface ListInterface {
    public void addFrist(Fraction item);
    public void addAfter(NodeFraction curr, Fraction item);
    public void addLast(Fraction item);
    public Fraction removeFrist() throws NoSuchElementException;
    public Fraction removeAfter(NodeFraction curr) throws NoSuchElementException;
    public Fraction removeLast() throws NoSuchElementException;
    public int size();
    public boolean contains(Fraction item);
    public void print();
    public boolean isEmpty() throws NoSuchElementException;
    public NodeFraction getHead();
    public Fraction getFrist();
} 