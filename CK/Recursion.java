public class Recursion {
    public static int convertDecToBin(int num) {
        if(num/2 == 0)  return num%2 * 10;
        return num%2 == 0 ? convertDecToBin(num/2)*10 : convertDecToBin(num/2)*10 + 1;
    }

    public static int reserveNumber(int num, int noDigital) {
        if(noDigital == 1)  return num;
        return (int) (reserveNumber(num/10, noDigital - 1) + (num%10)*Math.pow(10, noDigital));
    }

    public static int countCharacter(String str, Character c, int index) {
        if(index == str.length() - 1)   return str.charAt(index) == c ? 1 : 0;
        return Character.toLowerCase(str.charAt(index)) == c ? 1 + Character.toLowerCase(countCharacter(str, c, index + 1)) : Character.toLowerCase(countCharacter(str, c, index + 1));
    }

    public static int countVowels(String str) {
        if(str.equals("")) return 0;
        Character c = Character.toLowerCase(str.charAt(0));
        return (c == 'u' || c == 'e' || c == 'o' || c == 'a' || c == 'i') ? 1 + countVowels(str.substring(1)) : countVowels(str.substring(1));
    }

    public static int findMaxSumDigitsIndex(int []arr, int n) {
        if(n == -1) return 0;
        int sum = 0, tmp = arr[n];
        while(tmp/10 != 0) {
            sum += tmp%10;
            tmp /= 10;
        }
        sum += tmp;
        return sum > findMaxSumDigitsIndex(arr, n - 1) ? sum : findMaxSumDigitsIndex(arr, n - 1);
        
    }

    public static void main(String[] args) {
        // System.out.println(convertDecToBin(156));

        // System.out.println(reserveNumber(123, 3));

        // System.out.println(countCharacter("Pinochio", 'o', 0));

        // System.out.println(countVowels("pInochio"));

        int[] arr = {123, 45, 9};
        System.out.println(findMaxSumDigitsIndex(arr, arr.length - 1));
    }
}
