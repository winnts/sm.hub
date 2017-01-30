package LinkedIn.Feeds;

/**
 * Created by win on 24.01.17.
 */
public class CompanyShareArticle {

    public String feedName;
    public String header;
    public String meta;
    public String headline;
    public String textEntityShort;
    public String sideArticle;

    public CompanyShareArticle(String header, String meta, String headline, String textEntityShort, String sideArticle) {
        this.feedName = "companyShareArticle";
        this.header = header;
        this.meta = meta;
        this.headline = headline;
        this.textEntityShort = textEntityShort;
        this.sideArticle = sideArticle;
    }
}
