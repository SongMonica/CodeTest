import org.example.ConsecutiveCharacters;
import org.junit.Test;
import org.junit.jupiter.api.Timeout;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ConsecutiveCharactersTest {


        @Test
        public void testRemoveConsecutiveChars() {
            String inputRemove = "aabcccbbad";
            List<Map.Entry<String, String>> listRemove = ConsecutiveCharacters.removeConsecutiveChars(inputRemove);
            assertEquals(3, listRemove.size());
            assertEquals("aabbbad", listRemove.get(0).getKey());
            assertEquals("aaad", listRemove.get(1).getKey());
            assertEquals("d", listRemove.get(2).getKey());
        }
        @Test
        public void testReplaceConsecutiveChars() {
            String inputReplace = "abcccbad";
            List<Map.Entry<String, String>> listReplace = ConsecutiveCharacters.replaceConsecutiveChars(inputReplace);

            assertEquals(3, listReplace.size());
            assertEquals("abbbad,bbb is replaced by b", listReplace.get(0).getKey());
            assertEquals("aaad,aaa is replaced by a", listReplace.get(1).getKey());
            assertEquals("d", listReplace.get(2).getKey());
        }
    @Test
    public void testRemoveConsecutiveChars_NoConsecutiveChars() {
        String input = "abcde";
        List<Map.Entry<String, String>> result = ConsecutiveCharacters.removeConsecutiveChars(input);
        assertEquals(1, result.size());
        assertEquals("abcde", result.get(0).getKey());
    }

    @Test
    public void testReplaceConsecutiveChars_NoConsecutiveChars() {
        String input = "abcde";
        List<Map.Entry<String, String>> result = ConsecutiveCharacters.replaceConsecutiveChars(input);

        assertEquals(1, result.size());
        assertEquals("abcde", result.get(0).getKey());
    }

    @Test
    public void testRemoveConsecutiveChars_EmptyInput() {
        String input = "";
        List<Map.Entry<String, String>> result = ConsecutiveCharacters.removeConsecutiveChars(input);

        assertEquals(1, result.size());
        assertEquals("", result.get(0).getKey());
    }

    @Test
    public void testReplaceConsecutiveChars_EmptyInput() {
        String input = "";
        List<Map.Entry<String, String>> result = ConsecutiveCharacters.replaceConsecutiveChars(input);

        assertEquals(1, result.size());
        assertEquals("", result.get(0).getKey());
    }
    @Test
    @Timeout(value = 5) // specify the maximum time for the test to run (in seconds)
    public void testPerformance() {
        // Perform the operation you want to test for performance
        String input = "aabbccddeeffgghhii";
        ConsecutiveCharacters.replaceConsecutiveChars(input);

    }


}
