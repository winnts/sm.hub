package LinkedIn.Getters.Feeds;

import LinkedIn.Feeds.CompanyShareArticle;
import LinkedIn.Getters.Elements.*;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlHeading3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by win on 24.01.17.
 */
public class GetCompanyShareArticle {
    public List<CompanyShareArticle> companyShareArticles = new ArrayList<>();

    public List<CompanyShareArticle> getCompanyShareArticle (HtmlDivision content) {
        String sideArticleContent = "";
        String textEntityContent = "";
        HtmlDivision header = new GetHeader().getHeader(content);
        HtmlDivision meta = new GetMeta().getMeta(header);
        HtmlHeading3 headline = new GetHeadline().getHeadline(header);
        HtmlDivision textEntityShort = new GetTextEntity().getTextEntityShort(content);
        HtmlDivision sideArticle = new GetSideArticle().getSideArticle(content);
        if (sideArticle != null) {sideArticleContent = sideArticle.asText();}
        if (textEntityShort != null) {textEntityContent = textEntityShort.asText();}
        companyShareArticles.add(new CompanyShareArticle(header.asText(), meta.asText(), headline.asText(),
                textEntityContent, sideArticleContent));

        return companyShareArticles;
    }
}
