/**
 * Class for get some user data and return object
 */
public class InputData {
    private final String text;
    private final int repeatCount;

    public InputData(String text, int repeatCount) {
        this.text = text;
        this.repeatCount = repeatCount;
    }

    public String getText() {
        return text;
    }

    public int getRepeatCount() {
        return repeatCount;
    }
}
