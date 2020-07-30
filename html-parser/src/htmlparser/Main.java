package htmlparser;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static final String TEST_STR = "<html><a>hello</a><h1><h4>nestedHello</h4><h3>nestedWorld</h3><h6><br>top</br></h6></h1><br>world</br></html>";

    private static final Pattern javaPattern = Pattern.compile("(.*?<.*?>)(.*)(</.*?>.*?)", Pattern.CASE_INSENSITIVE);

    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        process(TEST_STR);
    }

    private static void process(final String input) {
        Matcher matcher = javaPattern.matcher(input);
        if (matcher.find()) {
            System.out.println(matcher.group(2));
        } else {

        }
    }
}
