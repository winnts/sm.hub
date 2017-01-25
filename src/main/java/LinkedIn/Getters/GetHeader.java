package LinkedIn.Getters;

import LinkedIn.DOM.DomClasses;
import LinkedIn.DOM.Header;
import LinkedIn.DOM.Headline;
import LinkedIn.DOM.Meta;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlHeading3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by win on 23.01.17.
 */
public class GetHeader {
    public HtmlDivision getHeader(HtmlDivision content) {
        HtmlDivision header = (HtmlDivision) content.getByXPath(DomClasses.HEADER).get(0);
        return header;
    }
}
