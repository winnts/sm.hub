package LinkedIn.Getters;

import LinkedIn.DOM.DomClasses;
import LinkedIn.DOM.Meta;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;

/**
 * Created by adyachenko on 24.01.17.
 */
public class GetMeta {
    public HtmlDivision getMeta (HtmlDivision header) {
        HtmlDivision meta = (HtmlDivision) header.getByXPath(DomClasses.META).get(0);
        return meta;
    }
}
