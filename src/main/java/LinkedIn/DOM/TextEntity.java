package LinkedIn.DOM;

/**
 * Created by adyachenko on 24.01.17.
 */
public class TextEntity {
    public static final String TEXTENTITY = "div[@class='text-entity shortened']";
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public TextEntity(String text) {
        this.text = text;
    }
}
