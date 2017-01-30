package LinkedIn.Getters.Elements;

import LinkedIn.DOM.DomClasses;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;

/**
 * Created by Andrey Dyachenko on 28.01.17.
 */
public class GetAuthor {
    public HtmlDivision getAuthor(HtmlDivision content) {
        HtmlDivision author = (HtmlDivision) content.getByXPath(DomClasses.AUTHOR).get(0);
        return author;
    }
}
