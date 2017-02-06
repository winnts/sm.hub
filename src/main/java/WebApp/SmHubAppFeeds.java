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
    public SendFeeds sendData(@QueryParam("accessToken") Optional<String> accessToken,
                              @QueryParam("linkedName") String linkedName,
                              @QueryParam("linkedPass") String linkedPass) throws Exception {
        if (accessToken.isPresent()){
            return new SendFeeds(counter.incrementAndGet(),
                    new GetFeed().getFeed(new LoginFB().getFBClient(accessToken.orElse(""))),
                    new ParseFeeds().parseFeeds(new LoginHTMLUnit().getDomNode(linkedName, linkedPass)));
        }else {

        return new SendFeeds(counter.incrementAndGet(),
                  null,
                  new ParseFeeds().parseFeeds(new LoginHTMLUnit().getDomNode(linkedName, linkedPass)));
    }}
}
