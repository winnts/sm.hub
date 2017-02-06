package LinkedIn.Getters.Feeds;

import LinkedIn.DOM.DomClasses;
import LinkedIn.Feeds.PulseContentPool;
import LinkedIn.Getters.Elements.GetContentDescription;
import LinkedIn.Getters.Elements.GetMeta;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlHeading3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrey Dyachenko on 24.01.17.
 */
public class GetPulseContentPool {
    public List<PulseContentPool> pulseContentPools = new ArrayList<>();

    public List<PulseContentPool> getPulseContentPool (HtmlDivision content) {
        HtmlDivision header = (HtmlDivision) content.getByXPath(DomClasses.HEADER).get(0);
        String meta = new GetMeta().getMeta(header);
        HtmlHeading3 headline = (HtmlHeading3) header.getByXPath(DomClasses.HEADLINE).get(0);
        String contentDescription = new GetContentDescription().getContentDescription(content);

        pulseContentPools.add(new PulseContentPool(header.asText(), meta, headline.asText(), contentDescription));

        return pulseContentPools;
    }
}
