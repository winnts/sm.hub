package LinkedIn.Getters;

import LinkedIn.DOM.DomClasses;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;

/**
 * Created by Andrey Dyachenko on 25.01.17.
 */
public class GetSideArticle {
    public HtmlDivision getSideArticle (HtmlDivision content) {
        HtmlDivision sideArticle = (HtmlDivision) content.getByXPath(DomClasses.SIDE_ARTICLE).get(0);
        return sideArticle;
    }
}
