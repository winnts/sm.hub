package LinkedIn.Getters;

import LinkedIn.Feeds.CompanyShareArticle;
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
        HtmlDivision header = (HtmlDivision) content.getByXPath(CompanyShareArticle.HEADER).get(0);
        HtmlDivision meta = (HtmlDivision) header.getByXPath(CompanyShareArticle.META).get(0);
        HtmlHeading3 headline = (HtmlHeading3) header.getByXPath(CompanyShareArticle.HEADLINE).get(0);
        HtmlDivision textEntityShort = (HtmlDivision) content.getByXPath(CompanyShareArticle.TEXT_ENTITY_SHORT).get(0);
        HtmlDivision sideArticle = (HtmlDivision) content.getByXPath(CompanyShareArticle.SIDE_ARTICLE).get(0);

        companyShareArticles.add(new CompanyShareArticle(header.asText(), meta.asText(), headline.asText(),
                textEntityShort.asText(), sideArticle.asText()));

        return companyShareArticles;
    }
}
