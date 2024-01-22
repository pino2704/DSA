public class Cau2 {
    public static int recur(int n, int k) {
        return (k == 0) ? 1 : n * recur(n, k - 1);
    }

    public static void main(String args[]){
		System.out.println(recur(3, 1));
	}
}