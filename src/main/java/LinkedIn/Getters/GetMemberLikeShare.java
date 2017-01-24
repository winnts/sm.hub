package LinkedIn.Getters;

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

    public List<MemberLikeShare> getMemberLiceShare (HtmlDivision content) {
        HtmlDivision header = (HtmlDivision) content.getByXPath(MemberLikeShare.HEADER).get(0);
        HtmlDivision meta = (HtmlDivision) header.getByXPath(MemberLikeShare.META).get(0);
        HtmlHeading3 headline = (HtmlHeading3) header.getByXPath(MemberLikeShare.HEADLINE).get(0);
        HtmlDivision author = (HtmlDivision) content.getByXPath(MemberLikeShare.AUTHOR).get(0);
        HtmlDivision textEntity = (HtmlDivision) content.getByXPath(MemberLikeShare.TEXT_ENTITY).get(0);

        memberLikeShares.add(new MemberLikeShare(header.asText(), meta.asText(), headline.asText(),
                author.asText(), textEntity.asText()));

        return memberLikeShares;

    }
}
