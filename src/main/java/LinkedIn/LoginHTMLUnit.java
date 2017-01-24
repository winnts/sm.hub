package LinkedIn;

import LinkedIn.DOM.Header;
import LinkedIn.DOM.TextEntity;
import LinkedIn.Feeds.CompanyShareArticle;
import LinkedIn.Feeds.MemberLikeShare;
import LinkedIn.Feeds.PulseContentPool;
import LinkedIn.Getters.*;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import org.apache.xpath.SourceTree;

import java.util.List;

/**
 * Created by win on 11.01.17.
 */
public class LoginHTMLUnit {
    public static void main(String[] args) {
        try {
            String url = "https://www.linkedin.com/uas/login?goback=&trk=hb_signin";
            final WebClient webClient = new WebClient();
            webClient.getOptions().setJavaScriptEnabled(false);
            webClient.getOptions().setCssEnabled(false);
            webClient.getOptions().setThrowExceptionOnScriptError(false);

            final HtmlPage loginPage = webClient.getPage(url);
            //Get Form By name
            final HtmlForm loginForm = loginPage.getFormByName("login");
            final HtmlSubmitInput button = loginForm.getInputByName("signin");
            final HtmlTextInput usernameTextField = loginForm.getInputByName("session_key");
            final HtmlPasswordInput passwordTextField = loginForm.getInputByName("session_password");
            usernameTextField.setValueAttribute(Credentials.LOGIN);//your Linkedin Username
            passwordTextField.setValueAttribute(Credentials.PSWD);//Your Linkedin Password
            final HtmlPage responsePage = button.click();
            webClient.setAjaxController(new NicelyResynchronizingAjaxController());
            webClient.getOptions().setJavaScriptEnabled(true);
            webClient.getOptions().setCssEnabled(false);

            String homeUrl = "https://www.linkedin.com/nhome/";

            final HtmlPage homePage = webClient.getPage(homeUrl);
            webClient.waitForBackgroundJavaScriptStartingBefore(50000);

            for (int i = 0; i < 20; i++) {
                System.out.println("Condition: " + homePage.getElementById("ozfeed").isDisplayed());
                if (homePage.getElementById("ozfeed").isDisplayed()) {
                    break;
                }
                synchronized (homePage) {
                    homePage.wait(500);
                }
            }
            DomElement ozFeed = homePage.getElementById("ozfeed");

            Iterable<DomNode> feedAll = ozFeed.getFirstChild().getChildren();

            GetHeader headers = new GetHeader();
            GetTextEntity textEntity = new GetTextEntity();


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
                    memberLikeShare.getMemberLiceShare(content);
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


                /*headers.getHeader(content);
                textEntity.getTextEntity(content);*/
            }


            /*for (Header header : headers.headers) {
                System.out.println(header.getMeta());
                System.out.println(header.getHeadline());
                System.out.println(header.getHeadlineSingleLine());
                System.out.println("########################################");
            }
            for (TextEntity entity : textEntity.textEntities) {
                System.out.println(entity.getText());
                System.out.println("########################################");

            }
*/

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
