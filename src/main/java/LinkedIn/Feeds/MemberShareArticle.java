package LinkedIn.Feeds;

/**
 * Created by win on 24.01.17.
 */
public class MemberShareArticle {

    public String feedName;
    public String header;
    public String meta;
    public String headline;

    public MemberShareArticle(String header, String meta, String headline) {
        this.feedName = "memberShareArticle";
        this.header = header;
        this.meta = meta;
        this.headline = headline;
    }
}
