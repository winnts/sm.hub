package LinkedIn.DOM;

/**
 * Created by adyachenko on 23.01.17.
 */
public class Headline {
    public static final String HEADLINE = "h3[@class='headline']";

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
