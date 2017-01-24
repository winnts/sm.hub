package LinkedIn.Getters;

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
        HtmlDivision header = (HtmlDivision) content.getByXPath(PulseContentPool.HEADER).get(0);
        HtmlDivision meta = (HtmlDivision) header.getByXPath(PulseContentPool.META).get(0);
        HtmlHeading3 headline = (HtmlHeading3) header.getByXPath(PulseContentPool.HEADLINE).get(0);
        HtmlDivision contentDescription = (HtmlDivision) content.getByXPath(PulseContentPool.CONTENT_DESCRIPTION).get(0);

        pulseContentPools.add(new PulseContentPool(header.asText(), meta.asText(), headline.asText(),
                contentDescription.asText()));

        return pulseContentPools;
    }
}
