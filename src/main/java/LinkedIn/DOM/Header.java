package LinkedIn.DOM;

/**
 * Created by adyachenko on 23.01.17.
 */
public class Header {
    private Headline headline;
    private HeadlineSingleLine headlineSingleLine;
    private Meta meta;

    public String getHeadline(){
        return headline.getText();
    }

    public String getHeadlineSingleLine() {
        return headlineSingleLine.getText();
    }

    public String getMeta(){
        return meta.getText();
    }

    public Header(String inHeadline, String inHeadlineSingleLine, String inMeta) {
        this.headline = new Headline();
        this.headlineSingleLine = new HeadlineSingleLine();
        this.meta = new Meta();
        headline.setText(inHeadline);
        headlineSingleLine.setText(inHeadlineSingleLine);
        meta.setText(inMeta);
    }
}
