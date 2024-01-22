
public class CharLinkedList implements LinkedListInterface {
    private Node head;
    
    public CharLinkedList() {
        this.head = null;
    }

    public boolean addFrist(char value) {
        if (head == null) {
            head = new Node(value, head);
            return true;
        } 
        
        Node tmp = head;
        while (tmp.getNext() != null) {
            tmp = tmp.getNext();
            if (tmp.getValue() == value) {
                return false;
            }
        }

        head = new Node(value, head);
        return true;
    }

    public char removeFristVowel() {
        if (head == null)   return 0;
        if (head.getValue() == 'u' || head.getValue() == 'e' || head.getValue() == 'o' || head.getValue() == 'a' || head.getValue() == 'i') {
            head = head.getNext();
            return head.getValue();
        }

        Node tmp = head, curr;
        while (tmp.getNext() != null) {
            curr = tmp;
            tmp = tmp.getNext();
            if (tmp.getValue() == 'u' || tmp.getValue() == 'e' || tmp.getValue() == 'o' || tmp.getValue() == 'a' || tmp.getValue() == 'i') {
                char temp = tmp.getValue();
                curr.setNext(tmp.getNext());
                return temp;
            }

        }
        return 0;
    }

    public int countConsonant() {
        if (head == null)   return -1;

        int count = 0;
        if (head.getValue() != 'u' && head.getValue() != 'e' && head.getValue() != 'o' && head.getValue() != 'a' && head.getValue() != 'i')
            count++;

        Node tmp = head;
        while (tmp.getNext() != null) {
            tmp = tmp.getNext();
            if (tmp.getValue() != 'u' && tmp.getValue() != 'e' && tmp.getValue() != 'o' && tmp.getValue() != 'a' && tmp.getValue() != 'i')
                count++;
        }
        if (count == 0) return -1;
        return count;
    }

    public void print() {
        if (head == null)   return;
        System.out.print(head.getValue());

        Node tmp = head;
        while (tmp.getNext() != null) {
            tmp = tmp.getNext();
            System.out.print(" -> " + tmp.getValue());
        }
    }
}
