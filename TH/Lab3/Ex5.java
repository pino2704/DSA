public class Ex5 {
    public static long convertDecimalToBinary(int n) {
        if(n == 1)  return 1;
        return (n%2 == 0) ? convertDecimalToBinary(n/2) * 10 : convertDecimalToBinary(n/2) * 10 + 1;
    }

    public static void main(String[] args) {
        System.out.println(convertDecimalToBinary(75));
    }
}