package LinkedIn.Feeds;

/**
 * Created by win on 24.01.17.
 */
public class PulseContentPool {
    public static final String HEADER = "div[@class='header ']";
    public static final String META = "div[@class='meta']";
    public static final String HEADLINE = "h3[@class='headline']";
    public static final String CONTENT_DESCRIPTION = "div[@class='side-article']";

    public String header;
    public String meta;
    public String headline;
    public String contentDescription;

    public PulseContentPool(String header, String meta, String headline, String contentDescription) {
        this.header = header;
        this.meta = meta;
        this.headline = headline;
        this.contentDescription = contentDescription;
    }
}
