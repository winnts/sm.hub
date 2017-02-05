package FB.Getters;

import com.restfb.Connection;
import com.restfb.FacebookClient;
import com.restfb.types.Post;

import java.util.List;

/**
 * Created by Andrey Dyachenko on 05.02.17.
 */
public class GetFeed {
    public List<Post> getFeed (FacebookClient facebookClient) {
        Connection<Post> myFeed = facebookClient.fetchConnection("me/feed", Post.class);
        List<Post> feed = myFeed.getData();
        return feed;
    }
}
