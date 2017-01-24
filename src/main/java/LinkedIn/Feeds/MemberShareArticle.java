package LinkedIn.Feeds;

/**
 * Created by win on 24.01.17.
 */
public class MemberShareArticle {
    public static final String HEADER = "div[@class='header ']";
    public static final String META = "div[@class='meta']";
    public static final String HEADLINE = "h3[@class='headline']";

    public String header;
    public String meta;
    public String headline;

    public MemberShareArticle(String header, String meta, String headline) {
        this.header = header;
        this.meta = meta;
        this.headline = headline;
    }
}
