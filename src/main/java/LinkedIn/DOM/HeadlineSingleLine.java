package LinkedIn.DOM;

/**
 * Created by adyachenko on 24.01.17.
 */
public class HeadlineSingleLine {
    public static final String HEADLINE_SINGLELINE = "h3[@class='headline single-line']";
    private String text;
//    private TitleContainer titleContainer;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


}
