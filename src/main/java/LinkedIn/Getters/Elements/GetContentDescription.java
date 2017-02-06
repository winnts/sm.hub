package LinkedIn.Getters.Elements;

import LinkedIn.DOM.DomClasses;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;

/**
 * Created by Andrey Dyachenko on 06.02.17.
 */
public class GetContentDescription {
    public String getContentDescription (HtmlDivision content) {
        String contentDescriptionContent = "";
        HtmlDivision contentDescription = null;
        try {
            contentDescription = (HtmlDivision) content.getByXPath(DomClasses.SIDE_ARTICLE).get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (contentDescription!=null){contentDescriptionContent=contentDescription.asText();}
        return contentDescriptionContent;
    }
}
