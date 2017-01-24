package LinkedIn.Feeds;

/**
 * Created by win on 24.01.17.
 */
public class CompanyShareArticle {
    public static final String HEADER = "div[@class='header ']";
    public static final String META = "div[@class='meta']";
    public static final String HEADLINE = "h3[@class='headline']";
    public static final String TEXT_ENTITY_SHORT = "div[@class='text-entity shortened']";
    public static final String SIDE_ARTICLE = "div[@class='side-article']";

    public String header;
    public String meta;
    public String headline;
    public String textEntityShort;
    public String sideArticle;

    public CompanyShareArticle(String header, String meta, String headline, String textEntityShort, String sideArticle) {
        this.header = header;
        this.meta = meta;
        this.headline = headline;
        this.textEntityShort = textEntityShort;
        this.sideArticle = sideArticle;
    }
}
