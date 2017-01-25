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

/**
 * Created by Andrey Dyachenko on 25.01.17.
 */
public class ParseFeeds {
    public static void parseFeeds (Iterable<DomNode> feedAll){
        for (DomNode domNode : feedAll) {
            String feedName = domNode.getAttributes().getNamedItem("class").getNodeValue();
            System.out.println(feedName);
            HtmlDivision content = (HtmlDivision) domNode.getByXPath("div[@class='content']").get(0);

            if (feedName.equals("feed-update company-share-article  has-snippets")){
                GetCompanyShareArticle companyShareArticle = new GetCompanyShareArticle();
                companyShareArticle.getCompanyShareArticle(content);
                for (CompanyShareArticle shareArticle : companyShareArticle.companyShareArticles) {
                    System.out.println(shareArticle.header);
                    System.out.println(shareArticle.headline);
                    System.out.println(shareArticle.meta);
                    System.out.println(shareArticle.textEntityShort);
                    System.out.println(shareArticle.sideArticle);
                }
            }

            if (feedName.equals("feed-update member-like-share  has-snippets")) {
                GetMemberLikeShare memberLikeShare = new GetMemberLikeShare();
                memberLikeShare.getMemberLikeShare(content);
                for (MemberLikeShare likeShare : memberLikeShare.memberLikeShares) {
                    System.out.println(likeShare.header);
                    System.out.println(likeShare.meta);
                    System.out.println(likeShare.headline);
                    System.out.println(likeShare.author);
                    System.out.println(likeShare.textEntity);
                }
            }

            if (feedName.equals("feed-update linkedin:pulseContentPool  has-snippets")) {
                GetPulseContentPool pulseContentPool = new GetPulseContentPool();
                pulseContentPool.getPulseContentPool(content);
                for (PulseContentPool contentPool : pulseContentPool.pulseContentPools) {
                    System.out.println(contentPool.header);
                    System.out.println(contentPool.meta);
                    System.out.println(contentPool.headline);
                    System.out.println(contentPool.contentDescription);
                }
            }

            if (feedName.equals("feed-update many-members-connect-members-rollup  has-snippets")) {
                GetManyMembersConnectMembers manyMembersConnectMembers = new GetManyMembersConnectMembers();
                manyMembersConnectMembers.getManyMembersConnectMembers(content);
                for (ManyMembersConnectMembers membersConnectMembers : manyMembersConnectMembers.manyMembersConnectMemberss) {
                    System.out.println(membersConnectMembers.headline);
                    System.out.println(membersConnectMembers.rollup);
                }
            }
            System.out.println("####################");
        }
    }
}
