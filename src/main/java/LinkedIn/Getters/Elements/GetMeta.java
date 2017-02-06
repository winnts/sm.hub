package LinkedIn.Getters.Elements;

import LinkedIn.DOM.DomClasses;
import LinkedIn.DOM.Meta;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;

/**
 * Created by adyachenko on 24.01.17.
 */
public class GetMeta {
    public String getMeta (HtmlDivision header) {
        String metaContent = "";
        HtmlDivision meta = null;
        try {
            meta = (HtmlDivision) header.getByXPath(DomClasses.META).get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(meta!=null){metaContent=meta.asText();}
        return metaContent;
    }
}
