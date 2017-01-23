package LinkedIn.DOM;

/**
 * Created by adyachenko on 23.01.17.
 */
public class Headline {
    public static final String HEADLINE = "h3[@class='headline']";
    public static final String TEXT = "";

    public String text;

    public Headline(String text) {
        this.text = text;
    }
}
