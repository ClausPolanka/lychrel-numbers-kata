package lychrel.template;

import java.math.BigInteger;

public class Lychrel {
    public static int convergesAtIteration(int n, int limit) {
        int iteration = 0;
        return converge(BigInteger.valueOf(n), iteration, limit);
    }

    private static int converge(BigInteger n, int iteration, int limit) {
        if (!isPalindrome(n) && iteration < limit) {
            return converge(n.add(reverse(n)), iteration + 1, limit);
        } else {
            return iteration;
        }
    }

    static boolean isPalindrome(BigInteger n) {
        String digits = n.toString();
        int lastIndex = digits.length() - 1;
        for (int i = 0; i < digits.length(); i++) {
            if (digits.charAt(i) != digits.charAt(lastIndex - i)) {
                return false;
            }
        }
        return true;
    }

    static BigInteger reverse(BigInteger n) {
        char nDigits[] = n.toString().toCharArray();
        char rDigits[] = new char[nDigits.length];
        int lastIndex = nDigits.length -1;
        for (int i = 0; i < nDigits.length; i++) {
            rDigits[i] = nDigits[lastIndex - i];
        }
        return new BigInteger(new String(rDigits)) ;
    }
}
