package LinkedIn.Getters;

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
    public List<Header> headers = new ArrayList<>();

    public List<Header> getHeader(HtmlDivision content) {
        HtmlDivision header = (HtmlDivision) content.getByXPath(Header.HEADER).get(0);
        headers.add(new Header(new GetHeadline().getHeadline(header),
                               new GetHeadlineSingleLine().getHeadlineSingleLine(header),
                               new GetMeta().getMeta(header)));
        return headers;
    }
}
