package WebApp;

import FB.Getters.GetFeed;
import FB.LoginFB;
import LinkedIn.LoginHTMLUnit;
import LinkedIn.ParseFeeds;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by adyachenko on 29.08.16.
 */
@Path("/feeds")
@Produces(MediaType.APPLICATION_JSON)
public class SmHubAppFeeds {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public SmHubAppFeeds(String template, String defaultName){
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public SendFeeds sendData(@QueryParam("accessToken") String accessToken,
                              @QueryParam("linkedName") String linkedName,
                              @QueryParam("linkedPass") String linkedPass) throws Exception {

        return new SendFeeds(counter.incrementAndGet(),
                  new GetFeed().getFeed(new LoginFB().getFBClient(accessToken)),
                  new ParseFeeds().parseFeeds(new LoginHTMLUnit().getDomNode(linkedName, linkedPass)));
    }
}
