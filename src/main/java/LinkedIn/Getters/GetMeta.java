package LinkedIn.Getters;

import LinkedIn.DOM.Meta;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;

/**
 * Created by adyachenko on 24.01.17.
 */
public class GetMeta {
    public String getMeta (HtmlDivision header) {
        String result = "";
        HtmlDivision meta = null;
        try {
            meta = (HtmlDivision) header.getByXPath(Meta.META).get(0);
            result = meta.asText();
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return result;
    }
}
