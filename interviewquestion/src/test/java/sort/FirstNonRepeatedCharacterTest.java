package sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FirstNonRepeatedCharacterTest {
    @Test
    public void test_case1_success() {
        FirstNonRepeatedCharacter f = new FirstNonRepeatedCharacter();
        String actual = f.find("hello world");
        String expect = "h";
        Assertions.assertEquals(expect, actual);
    }
}
