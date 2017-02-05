package FB;

import FB.Getters.GetFeed;
import FB.Getters.GetUser;
import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Version;
import com.restfb.scope.ScopeBuilder;
import com.restfb.scope.UserDataPermissions;
import com.restfb.types.Post;
import com.restfb.types.User;

import javax.jws.soap.SOAPBinding;

import java.util.List;

import static java.lang.System.out;

/**
 * Created by Andrey Dyachenko on 29.01.17.
 */
public class LoginFB {
    public FacebookClient getFBClient (String accessToken) {
        ScopeBuilder scopeBuilder = new ScopeBuilder();
        scopeBuilder.addPermission(UserDataPermissions.USER_STATUS);
        scopeBuilder.addPermission(UserDataPermissions.USER_ABOUT_ME);

        FacebookClient.AccessToken appAccessToken =
                new DefaultFacebookClient(Version.VERSION_2_8).obtainAppAccessToken("252184415193367", "7031982988f1ebc9e47a974fe21e1d86");

        FacebookClient facebookClient = new DefaultFacebookClient(accessToken, Version.VERSION_2_8);
        return facebookClient;
    }
    public static void main(String[] args) {
        String accesTocken = "EAADlXEJ8SRcBAEghZCEAtz0ZCXKuZAL6HQF374U8GvcZAVMrSgpCc61kuoPz5flJ9ZCEzreCPXeiZBpTxPZCyp5pmDnOz2Oq6sJd9ZBZAJ1mGTZCOmAh8lOi0sQYK2JhyHmXTQofasJ7b62JvJOD9FQRkJ45ZBojV5CU3YMGiqVAWWPkZBDtqkWO0rBtsoRBstPyaPEZD";
        List<Post> myFeed = new GetFeed().getFeed(new LoginFB().getFBClient(accesTocken));
//        System.out.println("My name is: " + new GetUser().getUser());
        for (Post post : myFeed) {
            out.println("Post: " + post.getStory());
        }
    }
}
