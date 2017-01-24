package LinkedIn.Getters;

import LinkedIn.DOM.TextEntity;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adyachenko on 24.01.17.
 */
public class GetTextEntity {
    public List<TextEntity> textEntities = new ArrayList<>();

    public List<TextEntity> getTextEntity (HtmlDivision content) {
        String result = "";
        HtmlDivision textEntity = null;
        try {
            textEntity = (HtmlDivision) content.getByXPath(TextEntity.TEXTENTITY).get(0);
            result = textEntity.asText();
        } catch (Exception e) {
            e.printStackTrace();
        }
        textEntities.add(new TextEntity(result));
        return textEntities;
    }
}
