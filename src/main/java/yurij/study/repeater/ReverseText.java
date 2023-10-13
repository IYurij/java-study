package yurij.study.repeater;

/**
 * Class witch reversing text
 */
public class ReverseText implements TextProcessor {
    /**
     * @param text - input string
     * @return - result string after reversing
     */
    public String process(String text) {
        return new StringBuilder(text).reverse().toString();
    }
}
