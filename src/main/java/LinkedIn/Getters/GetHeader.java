package LinkedIn.Getters;

import LinkedIn.DOM.Header;
import LinkedIn.DOM.Headline;
import LinkedIn.DOM.Meta;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by win on 23.01.17.
 */
public class GetHeader {
    public List<Header> getHeader (HtmlDivision content) {
        List<Header> headers = new ArrayList<>();
        HtmlDivision header = (HtmlDivision) content.getByXPath(Header.HEADER).get(0);
        HtmlDivision headline = (HtmlDivision) header.getByXPath(Headline.HEADLINE).get(0);
        headers.add(new Header(new Headline(headline.asText()), new Meta("")));
        return headers;
    }
}
