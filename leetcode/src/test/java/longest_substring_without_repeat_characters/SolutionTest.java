package longest_substring_without_repeat_characters;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    @Test
    public void TestCase1Success() {
        int got = new Solution().lengthOfLongestSubstring("abcabcbb");
        int want = 3;
        assertEquals(got, want);
    }

    @Test
    public void TestCase2Success() {
        int got = new Solution().lengthOfLongestSubstring("bbbbb");
        int want = 1;
        assertEquals(got, want);
    }

    @Test
    public void TestCase3Success() {
        int got = new Solution().lengthOfLongestSubstring("pwwkew");
        int want = 3;
        assertEquals(got, want);
    }

    @Test
    public void TestCase4Success() {
        int got = new Solution().lengthOfLongestSubstring("aab");
        int want = 2;
        assertEquals(got, want);
    }

    @Test
    public void TestCase5Success() {
        int got = new Solution().lengthOfLongestSubstring("dvdf");
        int want = 3;
        assertEquals(got, want);
    }

    @Test
    public void TestCase6Success() {
        int got = new Solution().lengthOfLongestSubstring("abba");
        int want = 2;
        assertEquals(got, want);
    }

    @Test
    public void TestCase7Success() {
        int got = new Solution().lengthOfLongestSubstring(" ");
        int want = 1;
        assertEquals(got, want);
    }
}
