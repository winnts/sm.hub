package LinkedIn.Getters.Feeds;

import LinkedIn.Feeds.MemberPeopleFollowMember;
import LinkedIn.Getters.Elements.*;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlHeading3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrey Dyachenko on 28.01.17.
 */
public class GetMemberPeopleFollowMember {
    public List<MemberPeopleFollowMember> memberPeopleFollowMembers = new ArrayList<>();

    public List<MemberPeopleFollowMember> getMemberPeopleFollowMembers (HtmlDivision content){
        String sideArticleContent = "";
        HtmlDivision header = new GetHeader().getHeader(content);
        HtmlDivision meta = new GetMeta().getMeta(header);
        HtmlHeading3 headline = new GetHeadline().getHeadline(header);
        HtmlDivision recentPost = new GetRecentPost().getRecentPost(content);
        HtmlDivision author = new GetAuthor().getAuthor(recentPost);
        HtmlDivision sideArticle = new GetSideArticle().getSideArticle(recentPost);
        if (sideArticle != null) {sideArticleContent = sideArticle.asText();}
        memberPeopleFollowMembers.add(new MemberPeopleFollowMember(header.asText(), headline.asText(),
                author.asText(), sideArticleContent));

        return memberPeopleFollowMembers;
    }
}
