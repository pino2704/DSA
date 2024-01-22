import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;

class Student implements Comparator<Student>{
    private String name;
    private double math;
    private double programming;
    private double DSA1;

    @Override
    public int compare(Student o1, Student o2) {
        if (o1.average() > o2.average())    return 1;
        if(o1.average() == o2.average())   return 0;
        if(o1.average() < o2.average())    return -1;
        throw new UnsupportedOperationException("Unimplemented method 'compare'");
    }

    public Student(String name, double math, double programming, double DSA1) {
        this.name = name;
        this.math = math;
        this.programming = programming;
        this.DSA1 = DSA1;
    }

    public double average() {
        return 1.0/3 * (math + programming + DSA1);
    }

    public String toString() {
        return name;
    }
}

public class Ex2{

    public static void main(String[] args) {
        Student a = new Student("A", 5, 4, 3);
        Student b = new Student("B", 9, 4, 3);
        Student c = new Student("C", 5, 4, 3);
        Student d = new Student("D", 1, 4, 3);
        Student e = new Student("E", 6, 4, 3);

        ArrayList<Student> st = new ArrayList<>();
        st.add(a);
        st.add(b);
        st.add(c);
        st.add(d);
        st.add(e);

        Collections.sort(st, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.average() > o2.average() ? 1 : -1;
            } 
        });
        System.out.println(st);

        Collections.sort(st, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.average() > o2.average() ? -1 : 1;
            } 
        });
        System.out.println(st);

    }

}
