package LinkedIn.Getters.Feeds;

import LinkedIn.DOM.DomClasses;
import LinkedIn.Feeds.ManyMembersConnectMembers;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlHeading3;
import com.gargoylesoftware.htmlunit.html.HtmlUnderlined;
import com.gargoylesoftware.htmlunit.html.HtmlUnorderedList;
import com.gargoylesoftware.htmlunit.javascript.host.html.HTMLUListElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrey Dyachenko on 25.01.17.
 */
public class GetManyMembersConnectMembers {
    public List<ManyMembersConnectMembers> manyMembersConnectMemberss = new ArrayList<>();

    public List<ManyMembersConnectMembers> getManyMembersConnectMembers (HtmlDivision content) {
        HtmlDivision header = (HtmlDivision) content.getByXPath(DomClasses.HEADER).get(0);
        HtmlHeading3 headline = (HtmlHeading3) header.getByXPath(DomClasses.HEADLINE).get(0);
        HtmlUnorderedList rollUp = (HtmlUnorderedList) content.getByXPath(DomClasses.ROLLUP).get(0);

        manyMembersConnectMemberss.add(new ManyMembersConnectMembers(headline.asText(), rollUp.asText()));
        return manyMembersConnectMemberss;
    }
}
