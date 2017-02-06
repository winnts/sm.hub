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
        String meta = new GetMeta().getMeta(header);
        String headline = new GetHeadline().getHeadline(header);
        HtmlDivision recentPost = new GetRecentPost().getRecentPost(content);
        HtmlDivision author = new GetAuthor().getAuthor(recentPost);
        String sideArticle = new GetSideArticle().getSideArticle(recentPost);
        memberPeopleFollowMembers.add(new MemberPeopleFollowMember(header.asText(), headline, author.asText(), sideArticle));

        return memberPeopleFollowMembers;
    }
}
