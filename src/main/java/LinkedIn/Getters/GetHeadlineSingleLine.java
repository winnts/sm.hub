package LinkedIn.Getters;

import LinkedIn.DOM.Headline;
import LinkedIn.DOM.HeadlineSingleLine;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlHeading3;

/**
 * Created by adyachenko on 24.01.17.
 */
public class GetHeadlineSingleLine {
    public String getHeadlineSingleLine (HtmlDivision header) {
        String result = "";
        HtmlHeading3 headlineSingleLine = null;
        try {
            headlineSingleLine = (HtmlHeading3) header.getByXPath(HeadlineSingleLine.HEADLINE_SINGLELINE).get(0);
            result = headlineSingleLine.asText();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
