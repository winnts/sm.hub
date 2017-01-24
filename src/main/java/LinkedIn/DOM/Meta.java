package LinkedIn.DOM;

/**
 * Created by adyachenko on 23.01.17.
 */
public class Meta {
    public static final String META = "div[@class='meta']";
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
