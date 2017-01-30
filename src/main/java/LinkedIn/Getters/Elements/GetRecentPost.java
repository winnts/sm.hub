package LinkedIn.Getters.Elements;

import LinkedIn.DOM.DomClasses;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;

/**
 * Created by Andrey Dyachenko on 28.01.17.
 */
public class GetRecentPost {
    public HtmlDivision getRecentPost(HtmlDivision content) {
        HtmlDivision recentPost = (HtmlDivision) content.getByXPath(DomClasses.RECENT_POST).get(0);
        return recentPost;
    }

}
