package LinkedIn.Feeds;

/**
 * Created by win on 24.01.17.
 */
public class ManyMembersConnectMembers {
    public static final String HEADLINE = "h3[@class='headline']";
    public static final String ROLLUP = "ul[@class='rollup']";

    public String headline;
    public String rollup;

    public ManyMembersConnectMembers(String headline, String rollup) {
        this.headline = headline;
        this.rollup = rollup;
    }
}
