package LinkedIn.DOM;

/**
 * Created by adyachenko on 23.01.17.
 */
public class Header {
    public static final String HEADER = "div[@class='header ']";
    private Headline headline;
    private Meta meta;

    public String getHeadline(){
        return headline.text;
    }
    public String getMeta(){
        return meta.text;
    }

    public Header(Headline headline, Meta meta) {
        this.headline = headline;
        this.meta = meta;
    }
}
