package yurij.study.repeater;

/**
 * Class for create repeated text from user string.
 */
public class RepeatText {
    /**
     * Method for build string with repeat.
     * @param text - user text.
     * @param  repeatCount - count repeat.
     * @return repeated string.
     */
    public String process(String text, int repeatCount) {
        StringBuilder resultString = new StringBuilder();

        for (int i = 0; i < repeatCount; i++) {
            resultString.append(text).append("\n");
        }

        return resultString.toString();
    }
}
