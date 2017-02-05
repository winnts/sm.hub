package WebApp;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.restfb.types.Post;

import java.util.List;

/**
 * Created by adyachenko on 29.08.16.
 */
public class SendFeeds {
    private long id;

    private List<Post> contentFB;
    private List<Object> contentLI;

    public SendFeeds(long id, List<Post> contentFB, List<Object> contentLI) {
        this.id = id;
        this.contentFB = contentFB;
        this.contentLI = contentLI;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public List<Post> getContentFB() {
        return contentFB;
    }

    @JsonProperty
    public List<Object> getContentLI(){return contentLI;}


}
