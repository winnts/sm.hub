package LinkedIn.Feeds;

/**
 * Created by win on 24.01.17.
 */
public class PulseContentPool {

    public String feedName;
    public String header;
    public String meta;
    public String headline;
    public String contentDescription;

    public PulseContentPool(String header, String meta, String headline, String contentDescription) {
        this.feedName = "pulseContentPool";
        this.header = header;
        this.meta = meta;
        this.headline = headline;
        this.contentDescription = contentDescription;
    }
}
