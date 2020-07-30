package htmlparser;

import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static final String TEST_STR = "<html><a>hello</a><h1><h4>nestedHello</h4><h3>nestedWorld</h3><h6><br>top</br></h6></h1><br>world</br></html>";

    private static final Pattern javaPattern = Pattern.compile("(.*?<.*?>)(.*)(</.*?>.*?)", Pattern.CASE_INSENSITIVE);
    private static final Pattern htmlPattern = Pattern.compile("(.*?<html>)(.*)(</html>.*?)", Pattern.CASE_INSENSITIVE);

    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        //process(TEST_STR);

        Stack<String> outputStack = new Stack<>();

        Matcher matcher = htmlPattern.matcher(TEST_STR);
        if (matcher.find()) {
            outputStack.add(matcher.group(2));
        }

        System.out.println(outputStack.pop());

    }

    private static void process(final String input) {
        Matcher matcher = htmlPattern.matcher(input);
        if (matcher.find()) {
            System.out.println(matcher.group(2));
            process(matcher.group(2));
        } else {

        }
    }
}
