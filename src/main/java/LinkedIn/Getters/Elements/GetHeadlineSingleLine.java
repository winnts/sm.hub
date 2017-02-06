package LinkedIn.Getters.Elements;

import LinkedIn.DOM.DomClasses;
import LinkedIn.DOM.Headline;
import LinkedIn.DOM.HeadlineSingleLine;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlHeading3;

/**
 * Created by adyachenko on 24.01.17.
 */
public class GetHeadlineSingleLine {
    public String getHeadlineSingleLine (HtmlDivision header) {
        String headlineContent = "";
        HtmlHeading3 headlineSingleLine = null;
        try {
            headlineSingleLine = (HtmlHeading3) header.getByXPath(DomClasses.HEADLINE_SINGLELINE).get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(headlineSingleLine!=null){headlineContent=headlineSingleLine.asText();}
        return headlineContent;
    }
}
