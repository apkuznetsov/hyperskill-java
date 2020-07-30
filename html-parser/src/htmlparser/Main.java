package htmlparser;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static final Pattern tagPattern = Pattern.compile("<([a-zA-Z0-9]+)>(.+?)</\\1>");

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String input = scanner.nextLine();

        final Matcher matcher = tagPattern.matcher(input);
        while (matcher.find()) {
            recursivePrintln(matcher.group(2));
        }

        scanner.close();
    }

    /* processInput()
     * If it has no children Then
     * * Print content
     * else
     * * For each child processInput()
     * * * Print child content */

    private static void recursivePrintln(String input) {
        final Matcher hasChildrenMatcher = tagPattern.matcher(input);
        if (!hasChildrenMatcher.find()) {
            System.out.println(input);
            return;
        }

        Matcher eachChildMatcher = tagPattern.matcher(input);
        while (eachChildMatcher.find()) {
            recursivePrintln(eachChildMatcher.group(2));
        }

        System.out.println(input);
    }
}
