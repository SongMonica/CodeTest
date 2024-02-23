import org.example.ConsecutiveCharacters;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ConsecutiveCharactersTest {


        @Test
        public void testRemoveConsecutiveChars() {
            String inputRemove = "aabcccbbad";
            List<String> listRemove = ConsecutiveCharacters.removeConsecutiveChars(inputRemove);

            assertEquals(4, listRemove.size());
            assertEquals("aabcccbbad", listRemove.get(0));
            assertEquals("aabbbad", listRemove.get(1));
            assertEquals("aaad", listRemove.get(2));
            assertEquals("d", listRemove.get(3));
        }
        @Test
        public void testReplaceConsecutiveChars() {
            String inputReplace = "abcccbad";
            List<String> listReplace = ConsecutiveCharacters.replaceConsecutiveChars(inputReplace);

            assertEquals(3, listReplace.size());
            assertEquals("abbbad,bbb is replaced by b", listReplace.get(0));
            assertEquals("aaad,aaa is replaced by a", listReplace.get(1));
            assertEquals("d", listReplace.get(2));

        }


    @Test
    public void testRemoveConsecutiveChars_NoConsecutiveChars() {
        String input = "abcde";
        List<String> result = ConsecutiveCharacters.removeConsecutiveChars(input);

        assertEquals(1, result.size());
        assertEquals("abcde", result.get(0));
    }

    @Test
    public void testReplaceConsecutiveChars_NoConsecutiveChars() {
        String input = "abcde";
        List<String> result = ConsecutiveCharacters.replaceConsecutiveChars(input);

        assertEquals(1, result.size());
        assertEquals("abcde", result.get(0));
    }

    @Test
    public void testRemoveConsecutiveChars_EmptyInput() {
        String input = "";
        List<String> result = ConsecutiveCharacters.removeConsecutiveChars(input);

        assertEquals(1, result.size());
        assertEquals("", result.get(0));
    }

    @Test
    public void testReplaceConsecutiveChars_EmptyInput() {
        String input = "";
        List<String> result = ConsecutiveCharacters.replaceConsecutiveChars(input);

        assertEquals(1, result.size());
        assertEquals("", result.get(0));
    }

}
