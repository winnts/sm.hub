package LinkedIn.Feeds;

/**
 * Created by Andrey Dyachenko on 28.01.17.
 */
public class MemberPeopleFollowMember {

    public String feedName;
    public String header;
    public String headline;
    public String author;
    public String sideArticle;

    public MemberPeopleFollowMember(String header, String headline, String author, String sideArticle) {
        this.feedName = "memberPeopleFollowMember";
        this.header = header;
        this.headline = headline;
        this.author = author;
        this.sideArticle = sideArticle;
    }
}
