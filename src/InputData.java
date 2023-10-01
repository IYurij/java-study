/**
 * Class for get some user data and return object
 * @version 0.1
 */
public class InputData {
    private String text;
    private int repeatCount;

    /**
     * Class constructor
     */
    InputData(String text, int repeatCount) {
        this.text = text;
        this.repeatCount = repeatCount;
    }

    /**
     * Getter for text field
     * @return text
     */
    public String getText() {
        return text;
    }

    /**
     * Getter for repeatCount
     * @return repeatCount
     */
    public int getRepeatCount() {
        return repeatCount;
    }
}
