package LinkedIn;

import LinkedIn.Feeds.CompanyShareArticle;
import LinkedIn.Feeds.ManyMembersConnectMembers;
import LinkedIn.Feeds.MemberLikeShare;
import LinkedIn.Feeds.PulseContentPool;
import LinkedIn.Getters.GetCompanyShareArticle;
import LinkedIn.Getters.GetManyMembersConnectMembers;
import LinkedIn.Getters.GetMemberLikeShare;
import LinkedIn.Getters.GetPulseContentPool;
import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by Andrey Dyachenko on 25.01.17.
 */
public class ParseFeeds {
    public static void parseFeeds (Iterable<DomNode> feedAll){
        List<ArrayList> allFeeds = new ArrayList<>();
        for (DomNode domNode : feedAll) {
            String feedName = domNode.getAttributes().getNamedItem("class").getNodeValue();
            System.out.println(feedName);
            HtmlDivision content = (HtmlDivision) domNode.getByXPath("div[@class='content']").get(0);

            if (feedName.equals("feed-update company-share-article  has-snippets")){
                GetCompanyShareArticle companyShareArticle = new GetCompanyShareArticle();
//                companyShareArticle.getCompanyShareArticle(content);
                allFeeds.add(new ArrayList(companyShareArticle.getCompanyShareArticle(content)));
                for (CompanyShareArticle shareArticle : companyShareArticle.companyShareArticles) {
                    System.out.println("Header: " + shareArticle.header);
                    System.out.println("Headline: " + shareArticle.headline);
                    System.out.println("Meta: " + shareArticle.meta);
                    System.out.println("Text_entity: " + shareArticle.textEntityShort);
                    System.out.println("Side article: " +shareArticle.sideArticle);
                }
            }

            if (feedName.equals("feed-update member-like-share  has-snippets")) {
                GetMemberLikeShare memberLikeShare = new GetMemberLikeShare();
//                memberLikeShare.getMemberLikeShare(content);
                allFeeds.add(new ArrayList(memberLikeShare.getMemberLikeShare(content)));
                for (MemberLikeShare likeShare : memberLikeShare.memberLikeShares) {
                    System.out.println("Header: " +likeShare.header);
                    System.out.println("Meta: " +likeShare.meta);
                    System.out.println("Headline: " + likeShare.headline);
                    System.out.println("Author: " + likeShare.author);
                    System.out.println("Text_entity: " + likeShare.textEntity);
                }
            }

            if (feedName.equals("feed-update linkedin:pulseContentPool  has-snippets")) {
                GetPulseContentPool pulseContentPool = new GetPulseContentPool();
//                pulseContentPool.getPulseContentPool(content);
                allFeeds.add(new ArrayList(pulseContentPool.getPulseContentPool(content)));
                for (PulseContentPool contentPool : pulseContentPool.pulseContentPools) {
                    System.out.println("Header: " + contentPool.header);
                    System.out.println("Meta: " + contentPool.meta);
                    System.out.println("Headline: " + contentPool.headline);
                    System.out.println("Content: " + contentPool.contentDescription);
                }
            }

            if (feedName.equals("feed-update many-members-connect-members-rollup  has-snippets")) {
                GetManyMembersConnectMembers manyMembersConnectMembers = new GetManyMembersConnectMembers();
//                manyMembersConnectMembers.getManyMembersConnectMembers(content);
                allFeeds.add(new ArrayList(manyMembersConnectMembers.getManyMembersConnectMembers(content)));
                for (ManyMembersConnectMembers membersConnectMembers : manyMembersConnectMembers.manyMembersConnectMemberss) {
                    System.out.println("Headline: " + membersConnectMembers.headline);
                    System.out.println("Rollup: " + membersConnectMembers.rollup);
                }
            }
            System.out.println("####################");
        }
        for (ArrayList allFeed : allFeeds) {
            for (Object o : allFeed) {
                System.out.println(o.getClass().getFields());
            }
        }

    }

}
