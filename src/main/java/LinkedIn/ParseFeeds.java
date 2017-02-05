package LinkedIn;

import LinkedIn.Getters.Feeds.*;
import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.google.gson.Gson;

import java.io.PrintWriter;
import java.util.*;

/**
 * Created by Andrey Dyachenko on 25.01.17.
 */
public class ParseFeeds {
    public List<Object> parseFeeds(Iterable<DomNode> feedAll) {
        List<Object> allFeeds = new ArrayList<>();
        for (DomNode domNode : feedAll) {
            String feedName = domNode.getAttributes().getNamedItem("class").getNodeValue();
            System.out.println(feedName);
            HtmlDivision content = (HtmlDivision) domNode.getByXPath("div[@class='content']").get(0);

            if (feedName.equals("feed-update company-share-article  has-snippets")) {
                GetCompanyShareArticle companyShareArticle = new GetCompanyShareArticle();
                allFeeds.add(new ArrayList(companyShareArticle.getCompanyShareArticle(content)));
            }

            if (feedName.equals("feed-update member-like-share  has-snippets")) {
                GetMemberLikeShare memberLikeShare = new GetMemberLikeShare();
                allFeeds.add(new ArrayList(memberLikeShare.getMemberLikeShare(content)));
            }

            if (feedName.equals("feed-update linkedin:pulseContentPool  has-snippets")) {
                GetPulseContentPool pulseContentPool = new GetPulseContentPool();
                allFeeds.add(new ArrayList(pulseContentPool.getPulseContentPool(content)));
            }

            if (feedName.equals("feed-update many-members-connect-members-rollup  has-snippets")) {
                GetManyMembersConnectMembers manyMembersConnectMembers = new GetManyMembersConnectMembers();
                allFeeds.add(new ArrayList(manyMembersConnectMembers.getManyMembersConnectMembers(content)));
            }

            if (feedName.equals("feed-update member-people-follow-member  has-snippets")) {
                GetMemberPeopleFollowMember memberPeopleFollowMember = new GetMemberPeopleFollowMember();
                allFeeds.add(new ArrayList(memberPeopleFollowMember.getMemberPeopleFollowMembers(content)));
            }

            if (feedName.equals("feed-update member-share-article has-snippets")) {
            }
        }
        try (PrintWriter out = new PrintWriter("result.json")) {
            Gson t = new Gson();
            String jsonFeed = t.toJson(allFeeds);
            out.println(jsonFeed);
        } catch (Exception e) {
        }
        return allFeeds;
    }
}
