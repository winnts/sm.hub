package LinkedIn.Getters.Feeds;

import LinkedIn.DOM.DomClasses;
import LinkedIn.Feeds.MemberLikeShare;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlHeading3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrey Dyachenko on 24.01.17.
 */
public class GetMemberLikeShare {
    public List<MemberLikeShare> memberLikeShares = new ArrayList<>();

    public List<MemberLikeShare> getMemberLikeShare(HtmlDivision content) {
        String text = "";
        HtmlDivision header = (HtmlDivision) content.getByXPath(DomClasses.HEADER).get(0);
        HtmlDivision meta = (HtmlDivision) header.getByXPath(DomClasses.META).get(0);
        HtmlHeading3 headline = (HtmlHeading3) header.getByXPath(DomClasses.HEADLINE).get(0);
        HtmlDivision viralEntity = (HtmlDivision) content.getByXPath(DomClasses.VIRAL_ENTITY).get(0);
        HtmlDivision viralEntityContent = (HtmlDivision) viralEntity.getByXPath(DomClasses.CONTENT).get(0);
        HtmlDivision author = (HtmlDivision) viralEntityContent.getByXPath(DomClasses.AUTHOR).get(0);
        HtmlDivision authorContent = (HtmlDivision) author.getByXPath(DomClasses.CONTENT).get(0);
        HtmlDivision textEntity = null;

        try {
            textEntity = (HtmlDivision) viralEntityContent.getByXPath(DomClasses.TEXT_ENTITY).get(0);
            text = textEntity.asText();
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        try {
            textEntity = (HtmlDivision) viralEntityContent.getByXPath(DomClasses.TEXT_ENTITY_SHORT).get(0);
            text = textEntity.asText();
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
               }


        memberLikeShares.add(new MemberLikeShare(header.asText(), meta.asText(), headline.asText(),
                author.asText(), text));

        return memberLikeShares;

    }
}
