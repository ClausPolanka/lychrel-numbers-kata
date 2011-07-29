package lychrel.template;

import junit.framework.Assert;
import org.junit.Test;
import java.math.BigInteger;
import static junit.framework.Assert.*;

public class LychrelTest {
    private final int LIMIT = 1000;

    @Test
    public void facts() throws Exception {
        convergesAtIteration(1, 0);
        convergesAtIteration(2, 0);
        convergesAtIteration(10, 1);
        convergesAtIteration(11, 0);
        convergesAtIteration(19, 2);
        convergesAtIteration(78, 4);
        convergesAtIteration(89, 24);

        doesNotConverge(196);
    }

    private void convergesAtIteration(int n, int iteration) {
        Assert.assertEquals(iteration, Lychrel.convergesAtIteration(n, LIMIT));
    }

    private void doesNotConverge(int n) {
        convergesAtIteration(n, LIMIT);
    }

    @Test
    public void palindromes() throws Exception {
        isPalindrome(1);
        isPalindrome(11);
        isPalindrome(121);
        isPalindrome(12321);
        isPalindrome(1234321);
    }

    private void isPalindrome(int n) {
        assertTrue(Lychrel.isPalindrome(BigInteger.valueOf(n)));
    }

    @Test
    public void nonPalindromes() throws Exception {
        isNotPalindrome(10);
        isNotPalindrome(12331);
        isNotPalindrome(1243321);
    }

    private void isNotPalindrome(int n) {
        assertFalse(Lychrel.isPalindrome(BigInteger.valueOf(n)));
    }

    @Test
    public void reversals() throws Exception {
        reversed(1, 1);
        reversed(12, 21);
        reversed(123, 321);
        reversed(1234, 4321);
    }

    private void reversed(int n, int r) {
        assertEquals(r, Lychrel.reverse(BigInteger.valueOf(n)).longValue());
    }
}
