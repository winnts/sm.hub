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
        HtmlDivision header = new GetHeader().getHeader(content);
        String meta = new GetMeta().getMeta(header);
        String headline = new GetHeadline().getHeadline(header);
        String textEntity = new GetTextEntity().getTextEntity(content);
        String sideArticle = new GetSideArticle().getSideArticle(content);
        companyShareArticles.add(new CompanyShareArticle(header.asText(), meta, headline, textEntity, sideArticle));

        return companyShareArticles;
    }
}
