package longest_palindromic_substring;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void TestCase1Success() {
        String got = new Solution().longestPalindrome("babad");
        String want = "bab";
        String want2 = "aba";
        assertThat(got, CoreMatchers.either(CoreMatchers.is(want)).or(CoreMatchers.is(want2)));
    }

    @Test
    public void TestCase2Success() {
        String got = new Solution().longestPalindrome("cbbd");
        String want = "bb";
        assertEquals(got, want);
    }

    @Test
    public void TestCase3Success() {
        String got = new Solution().longestPalindrome("abaceudekq");
        String want = "aba";
        assertEquals(got, want);
    }

    @Test
    public void TestCase4Success() {
        String got = new Solution().longestPalindrome("ababab");
        String want = "ababa";
        String want2 = "babab";
        assertThat(got, CoreMatchers.either(CoreMatchers.is(want)).or(CoreMatchers.is(want2)));
    }

    @Test
    public void TestCase5Success() {
        String got = new Solution().longestPalindrome("ceudekqaba");
        String want = "aba";
        assertEquals(got, want);
    }

    @Test
    public void TestCase6Success() {
        String got = new Solution().longestPalindrome("a");
        String want = "a";
        assertEquals(got, want);
    }

    @Test
    public void TestCase7Success() {
        String got = new Solution().longestPalindrome("ab");
        String want = "a";
        String want2 = "b";
        assertThat(got, CoreMatchers.either(CoreMatchers.is(want)).or(CoreMatchers.is(want2)));
    }

    @Test
    public void TestCase8Success() {
        String got = new Solution().longestPalindrome("ac");
        String want = "a";
        String want2 = "c";
        assertThat(got, CoreMatchers.either(CoreMatchers.is(want)).or(CoreMatchers.is(want2)));
    }

    @Test
    public void TestCase9Success() {
        String got = new Solution().longestPalindrome("aacabdkacaa");
        String want = "aca";
        assertEquals(got, want);
    }

    @Test
    public void TestCase10Success() {
        String got = new Solution().longestPalindrome("ccc");
        String want = "ccc";
        assertEquals(got, want);
    }

    @Test
    public void TestCase11Success() {
        String got = new Solution().longestPalindrome("aaabaaaa");
        String want = "aaabaaa";
        assertEquals(got, want);
    }

    @Test
    public void TestCase12Success() {
        String got = new Solution().longestPalindrome("tattarrattat");
        String want = "tattarrattat";
        assertEquals(got, want);
    }
}
