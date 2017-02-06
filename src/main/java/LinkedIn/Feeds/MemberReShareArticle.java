package LinkedIn.Feeds;

/**
 * Created by win on 24.01.17.
 */
public class MemberReShareArticle {

    public String feedName;
    public String header;
    public String meta;
    public String headline;
    public String textEntity;
    public String sideArticle;

    public MemberReShareArticle(String header, String meta, String headline, String textEntity, String sideArticle) {
        this.feedName = "memberReShareArticle";
        this.header = header;
        this.meta = meta;
        this.headline = headline;
        this.textEntity = textEntity;
        this.sideArticle = sideArticle;
    }
}
