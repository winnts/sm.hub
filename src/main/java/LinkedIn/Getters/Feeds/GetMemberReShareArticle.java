package LinkedIn.Getters.Feeds;

import LinkedIn.DOM.DomClasses;
import LinkedIn.Feeds.MemberLikeShare;
import LinkedIn.Feeds.MemberReShareArticle;
import LinkedIn.Getters.Elements.*;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrey Dyachenko on 24.01.17.
 */
public class GetMemberReShareArticle {
    public List<MemberReShareArticle> memberReShareArticles = new ArrayList<>();

    public List<MemberReShareArticle> getMemberReShareArticles(HtmlDivision content) {
        HtmlDivision header = (HtmlDivision) content.getByXPath(DomClasses.HEADER).get(0);
        String meta = new GetMeta().getMeta(header);
        String headline = new GetHeadlineSingleLine().getHeadlineSingleLine(header);
        String textEntity = new GetTextEntity().getTextEntity(content);
        String sideArticle = new GetSideArticle().getSideArticle(content);
        HtmlDivision viralEntity = (HtmlDivision) content.getByXPath(DomClasses.VIRAL_ENTITY).get(0);
        HtmlDivision viralEntityContent = (HtmlDivision) viralEntity.getByXPath(DomClasses.CONTENT).get(0);
//        HtmlDivision author = (HtmlDivision) viralEntityContent.getByXPath(DomClasses.AUTHOR).get(0);
//        HtmlDivision authorContent = (HtmlDivision) author.getByXPath(DomClasses.CONTENT).get(0);

        memberReShareArticles.add(new MemberReShareArticle(header.asText(), meta, headline, textEntity, viralEntity.asText()));

        return memberReShareArticles;

    }
}
