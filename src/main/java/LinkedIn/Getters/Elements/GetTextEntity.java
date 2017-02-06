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

    public String getTextEntity (HtmlDivision content) {
        String textEntityContent = "";
        HtmlDivision textEntity = null;
        try {
            textEntity = (HtmlDivision) content.getByXPath(DomClasses.TEXT_ENTITY).get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            textEntity = (HtmlDivision) content.getByXPath(DomClasses.TEXT_ENTITY_SHORT).get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (textEntity!=null){textEntityContent=textEntity.asText();}
        return textEntityContent;
    }
}
