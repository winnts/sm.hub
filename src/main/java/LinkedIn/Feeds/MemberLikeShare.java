package LinkedIn.Feeds;

/**
 * Created by adyachenko on 23.01.17.
 */
public class MemberLikeShare {
    public static final String HEADER = "div[@class='header ']";
    public static final String META = "div[@class='meta']";
    public static final String HEADLINE = "h3[@class='headline']";
    public static final String AUTHOR = "div[@class='author']";
    public static final String TEXT_ENTITY = "div[@class='text-entity']";

    public String header;
    public String meta;
    public String headline;
    public String author;
    public String textEntity;

    public MemberLikeShare(String header, String meta, String headline, String author, String textEntity) {
        this.header = header;
        this.meta = meta;
        this.headline = headline;
        this.author = author;
        this.textEntity = textEntity;
    }
}
