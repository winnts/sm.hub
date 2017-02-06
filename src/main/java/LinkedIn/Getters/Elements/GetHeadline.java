package LinkedIn.Getters.Elements;

import LinkedIn.DOM.DomClasses;
import LinkedIn.DOM.Headline;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlHeading3;

/**
 * Created by adyachenko on 24.01.17.
 */
public class GetHeadline {
    public String getHeadline (HtmlDivision header) {
        String headlineContent="";

        HtmlHeading3 headline = null;
        try {
            headline = (HtmlHeading3) header.getByXPath(DomClasses.HEADLINE).get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(headline!=null){headlineContent=headline.asText();}
        return headlineContent;
    }
}
