package LinkedIn.Getters.Elements;

import LinkedIn.DOM.DomClasses;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;

/**
 * Created by Andrey Dyachenko on 25.01.17.
 */
public class GetSideArticle {
    public String getSideArticle (HtmlDivision content) {
        String sideArticleContent = "";
        HtmlDivision sideArticle = null;
        try {
            sideArticle = (HtmlDivision) content.getByXPath(DomClasses.SIDE_ARTICLE).get(0);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        if(sideArticle!=null){sideArticleContent=sideArticle.asText();}
        return sideArticleContent;
    }
}
