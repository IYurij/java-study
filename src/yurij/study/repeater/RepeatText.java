package yurij.study.repeater;

/**
 * Class for create repeated text from user string.
 */
public class RepeatText implements TextProcessor {
    private final int repeatCount;

    public RepeatText(int repeatCount) {
        this.repeatCount = repeatCount;
    }

    /**
     * Method for build string with repeat.
     * @param text - user text.
     * @return repeated string.
     */
    public String process(String text) {
        StringBuilder resultString = new StringBuilder();

        for (int i = 0; i < repeatCount; i++) {
            resultString.append(text).append("\n");
        }

        return resultString.toString();
    }
}
