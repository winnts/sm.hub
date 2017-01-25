package LinkedIn.Getters;

import LinkedIn.DOM.DomClasses;
import LinkedIn.Feeds.PulseContentPool;
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
        HtmlDivision meta = (HtmlDivision) header.getByXPath(DomClasses.META).get(0);
        HtmlHeading3 headline = (HtmlHeading3) header.getByXPath(DomClasses.HEADLINE).get(0);
        HtmlDivision contentDescription = (HtmlDivision) content.getByXPath(DomClasses.SIDE_ARTICLE).get(0);

        pulseContentPools.add(new PulseContentPool(header.asText(), meta.asText(), headline.asText(),
                contentDescription.asText()));

        return pulseContentPools;
    }
}
