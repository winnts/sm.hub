package LinkedIn.Getters.Feeds;

import LinkedIn.DOM.DomClasses;
import LinkedIn.Feeds.MemberLikeShare;
import LinkedIn.Feeds.MemberShareArticle;
import LinkedIn.Getters.Elements.GetHeadline;
import LinkedIn.Getters.Elements.GetMeta;
import LinkedIn.Getters.Elements.GetTextEntity;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrey Dyachenko on 28.01.17.
 */
public class GetMemberShareArticle {
    public List<MemberShareArticle> memberShareArticles = new ArrayList<>();
    public List<MemberShareArticle> getMemberShareArticles(HtmlDivision content){
        HtmlDivision header = (HtmlDivision) content.getByXPath(DomClasses.HEADER).get(0);
        String meta = new GetMeta().getMeta(header);
        String headline = new GetHeadline().getHeadline(header);
        String textEntity = new GetTextEntity().getTextEntity(content);
        memberShareArticles.add(new MemberShareArticle(header.asText(), meta, headline, textEntity));
        return memberShareArticles;
    }
}
