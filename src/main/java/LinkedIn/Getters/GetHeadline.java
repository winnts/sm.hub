package LinkedIn.Getters;

import LinkedIn.DOM.Headline;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlHeading3;

/**
 * Created by adyachenko on 24.01.17.
 */
public class GetHeadline {
    public String getHeadline (HtmlDivision header) {
        String result = "";
        HtmlHeading3 headline = null;
        try {
            headline = (HtmlHeading3) header.getByXPath(Headline.HEADLINE).get(0);
            result = headline.asText();
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return result;
    }
}
