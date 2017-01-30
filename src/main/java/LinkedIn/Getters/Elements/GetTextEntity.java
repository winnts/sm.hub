package LinkedIn.Getters.Elements;

import LinkedIn.DOM.DomClasses;
import LinkedIn.DOM.TextEntity;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adyachenko on 24.01.17.
 */
public class GetTextEntity {

    public HtmlDivision getTextEntity (HtmlDivision content) {
        HtmlDivision textEntity = (HtmlDivision) content.getByXPath(DomClasses.TEXT_ENTITY).get(0);
        return textEntity;
    }
    public HtmlDivision getTextEntityShort (HtmlDivision content) {
        HtmlDivision textEntityShort = (HtmlDivision) content.getByXPath(DomClasses.TEXT_ENTITY_SHORT).get(0);
        return textEntityShort;
    }
}
