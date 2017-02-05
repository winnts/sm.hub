package FB.Getters;

import com.restfb.FacebookClient;
import com.restfb.types.User;

/**
 * Created by Andrey Dyachenko on 05.02.17.
 */
public class GetUser {
    public User getUser (FacebookClient facebookClient){
        User user =  facebookClient.fetchObject("me", User.class);
        return user;
    }
}
