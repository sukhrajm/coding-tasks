package sanitize;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Sanitizer {

    private static final List<String> BAD_WORDS = new ArrayList();

    private static final String EMAIL_REGEX = "^(.+)@(.+)$";

    static {
        BAD_WORDS.add("crap");
        BAD_WORDS.add("swearword");
    }

    public String sanitize(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        String[] words = input.split(" ");

        for (int i=0; i<words.length; i++) {
            String current = words[i];
            if (BAD_WORDS.contains(current)) {
                words[i] = makeReplacement(current.length());
            }

            if (current.matches(EMAIL_REGEX)) {
                words[i] = "<email address>";
            }
        }
        return Arrays.stream(words).collect(Collectors.joining(" "));
    }

    private String makeReplacement(int length) {
        char[] chars = new char[length];
        Arrays.fill(chars, '*');
        return new String(chars);
    }
}
