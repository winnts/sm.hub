package LinkedIn.Getters.Elements;

import LinkedIn.DOM.DomClasses;
import LinkedIn.DOM.Headline;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlHeading3;

/**
 * Created by adyachenko on 24.01.17.
 */
public class GetHeadline {
    public HtmlHeading3 getHeadline (HtmlDivision header) {
        HtmlHeading3 headline = (HtmlHeading3) header.getByXPath(DomClasses.HEADLINE).get(0);
        return headline;
    }
}
