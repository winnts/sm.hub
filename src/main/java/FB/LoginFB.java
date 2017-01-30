package FB;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Version;
import com.restfb.scope.ScopeBuilder;
import com.restfb.scope.UserDataPermissions;
import com.restfb.types.User;

import javax.jws.soap.SOAPBinding;

import static java.lang.System.out;

/**
 * Created by Andrey Dyachenko on 29.01.17.
 */
public class LoginFB {
    public static void main(String[] args) {
        ScopeBuilder scopeBuilder = new ScopeBuilder();
        scopeBuilder.addPermission(UserDataPermissions.USER_STATUS);
        scopeBuilder.addPermission(UserDataPermissions.USER_ABOUT_ME);


        FacebookClient.AccessToken accessToken =
                new DefaultFacebookClient(Version.VERSION_2_8).obtainAppAccessToken("252184415193367", "7031982988f1ebc9e47a974fe21e1d86");

        FacebookClient facebookClient = new DefaultFacebookClient("EAADlXEJ8SRcBAKUKrTxboQZCArWnj7uqoquPkzfTuxlFuP3rgrF7nMcZCPpXWIsqqb8ZBJ5yM8PZAggy2laAEi7ySeirXOu40kSHZB2Pk62orX5pRm319ld0FuQsZCZCauLxLlBtY4MU1nrm8m0GoLAl35nW7PlvT19szZCTdF6bYZBgH4hZBUF6pZBFidP1QQSJYoZD", Version.VERSION_2_8);
        User user =  facebookClient.fetchObject("me", User.class);
        System.out.println("My name is: " + user.getName());



//        out.println("My extended access token: " + accessToken);
    }
}
