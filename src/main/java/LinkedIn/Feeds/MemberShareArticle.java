package LinkedIn.Feeds;

/**
 * Created by win on 24.01.17.
 */
public class MemberShareArticle {

    public String feedName;
    public String header;
    public String meta;
    public String headline;
    public String textEntity;

    public MemberShareArticle(String header, String meta, String headline, String textEntity) {
        this.feedName = "memberShareArticle";
        this.header = header;
        this.meta = meta;
        this.headline = headline;
        this.textEntity = textEntity;
    }
}
