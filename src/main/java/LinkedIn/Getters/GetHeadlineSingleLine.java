package LinkedIn.Getters;

import LinkedIn.DOM.DomClasses;
import LinkedIn.DOM.Headline;
import LinkedIn.DOM.HeadlineSingleLine;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlHeading3;

/**
 * Created by adyachenko on 24.01.17.
 */
public class GetHeadlineSingleLine {
    public HtmlHeading3 getHeadlineSingleLine (HtmlDivision header) {
        HtmlHeading3 headlineSingleLine = (HtmlHeading3) header.getByXPath(DomClasses.HEADLINE_SINGLELINE).get(0);
        return headlineSingleLine;
    }
}
