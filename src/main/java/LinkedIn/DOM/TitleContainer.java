package LinkedIn.DOM;

/**
 * Created by adyachenko on 24.01.17.
 */
public class TitleContainer {
    public static final String TITLE_CONTAINER = "div[@class='title-container']";
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
