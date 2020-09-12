import java.util.Arrays;

/*

Given a string consisting of lowercase English letters, find the largest square number which can be obtained by reordering the string's characters and replacing them with any digits you need (leading zeros are not allowed) where same characters always map to the same digits and different characters always map to different digits.

If there is no solution, return -1.

Example

    For s = "ab", the output should be
    constructSquare(s) = 81.
    The largest 2-digit square number with different digits is 81.
    For s = "zzz", the output should be
    constructSquare(s) = -1.
    There are no 3-digit square numbers with identical digits.
    For s = "aba", the output should be
    constructSquare(s) = 900.
    It can be obtained after reordering the initial string into "baa" and replacing "a" with 0 and "b" with 9.

*/

public class Main {

    public static void main(String[] args) {

        System.out.println( constructSquare("aba"));

    }

    public static int constructSquare(String s) {

        int a = (int)Math.ceil(Math.sqrt(Math.pow(10, s.length()-1)));
        int b = (int)Math.floor(Math.sqrt(Math.pow(10, s.length()) - 1));
        int[] chars = new int[26];

        for (char ch: s.toCharArray())
            chars[ch-'a'] += 1;
        Arrays.sort(chars);

        for (int i = b; i >= a; i--) {
            int n = i*i;
            if (isSquare(n, chars)) return n;
        }

        return -1;

    }

    private static boolean isSquare(int n, int[] chars) {

        int[] digits = new int[26];

        while(n>0) {
            digits[n%10] += 1;
            n/=10;
        }

        Arrays.sort(digits);

        return Arrays.equals(chars, digits);

    }
    
}
