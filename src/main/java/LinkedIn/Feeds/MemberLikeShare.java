package LinkedIn.Feeds;

/**
 * Created by adyachenko on 23.01.17.
 */
public class MemberLikeShare {

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
