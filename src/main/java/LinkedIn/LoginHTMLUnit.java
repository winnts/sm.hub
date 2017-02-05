package LinkedIn;


import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;

import java.io.PrintWriter;
import java.util.logging.Level;

/**
 * Created by win on 11.01.17.
 */
public class LoginHTMLUnit {
    public Iterable<DomNode> getDomNode (String login, String passwd) {
        Iterable<DomNode> feedAll = null;
        java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF);
        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
        try {
            String url = "https://www.linkedin.com/uas/login?goback=&trk=hb_signin";
            final WebClient webClient = new WebClient();

            //Disabling JS for Login page
            webClient.getOptions().setJavaScriptEnabled(false);
            webClient.getOptions().setCssEnabled(false);
            webClient.getOptions().setThrowExceptionOnScriptError(false);

            //Set browser size
            webClient.getWebWindows().get(0).setInnerWidth(1920);
            webClient.getWebWindows().get(0).setInnerHeight(1024);

            final HtmlPage loginPage = webClient.getPage(url);

            //Get Form By name
            final HtmlForm loginForm = loginPage.getFormByName("login");
            final HtmlSubmitInput button = loginForm.getInputByName("signin");
            final HtmlTextInput usernameTextField = loginForm.getInputByName("session_key");
            final HtmlPasswordInput passwordTextField = loginForm.getInputByName("session_password");
            usernameTextField.setValueAttribute(login);//your Linkedin Username
            passwordTextField.setValueAttribute(passwd);//Your Linkedin Password
            final HtmlPage responsePage = button.click();

            //Enable JS for home page
            webClient.setAjaxController(new NicelyResynchronizingAjaxController());
            webClient.getOptions().setJavaScriptEnabled(true);
            webClient.getOptions().setCssEnabled(false);

            String homeUrl = "https://www.linkedin.com/nhome/";
            final HtmlPage homePage = webClient.getPage(homeUrl);
            //Waiting for page loading
            webClient.waitForBackgroundJavaScriptStartingBefore(5000);
            for (int i = 0; i < 20; i++) {
                System.out.println("Condition: " + homePage.getElementById("ozfeed").isDisplayed());
                if (homePage.getElementById("ozfeed").isDisplayed()) {
                    break;
                }
                synchronized (homePage) {
                    homePage.wait(5000);
                }
            }
            try(PrintWriter out = new PrintWriter("page.html")){
                out.println(homePage.asXml());
            }
            //Getting feed
            DomElement ozFeed = homePage.getElementById("ozfeed");
            //Getting inner feeds
            feedAll = ozFeed.getFirstChild().getChildren();
//            ParseFeeds.parseFeeds(feedAll);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return feedAll;
    }
}
