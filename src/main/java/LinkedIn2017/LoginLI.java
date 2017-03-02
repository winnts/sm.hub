package LinkedIn2017;


import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;

/**
 * Created by win on 11.01.17.
 */
public class LoginLI {
    public WebClient webClient = new WebClient();

    public DomNode getFeed (HtmlPage homePage) throws Exception {
        //Enable JS for home page
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.getOptions().setCssEnabled(false);

//        //Waiting for page loading
//        webClient.waitForBackgroundJavaScriptStartingBefore(15000);
//        for (int i = 0; i < 20; i++) {
//            if (homePage.getElementById("voyager-feed").isDisplayed()) {
//                System.out.println("Condition: " + homePage.getElementById("voyager-feed").isDisplayed());
//                break;
//            }
////            if (homePage.getElementById("core-rail").isDisplayed())
//            synchronized (homePage) {
//                homePage.wait(5000);
//            }
//        }
//        try (PrintWriter out = new PrintWriter("page.html")) {
//            out.println(homePage.asXml());
//        }
        //Getting feed
        DomNode feed = (DomNode) homePage.getByXPath("//div[@class='ember-view']" +
                "//div[@class='application-outlet ']//div[@class='core-rail']//div[@class='ember-view']").get(0);


//        DomElement ozFeed = homePage.getElementById("ozfeed");
        //Getting inner feeds
//        Iterable<DomNode>feedAll = ozFeed.getFirstChild().getChildren();
//            ParseFeeds.parseFeeds(feedAll);
    return feed;
    }

    public HtmlPage login (String login, String passwd) throws IOException, InterruptedException {
        Iterable<DomNode> feedAll = null;
        java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF);
        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");

            String url = "https://www.linkedin.com/uas/login?goback=&trk=hb_signin";
//            final WebClient webClient = new WebClient();

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
        webClient.getOptions().setCssEnabled(true);
        webClient.waitForBackgroundJavaScriptStartingBefore(15000);

            String homeUrl = "https://www.linkedin.com/feed/";
            final HtmlPage homePage = webClient.getPage(homeUrl);

//Waiting for page loading
        webClient.waitForBackgroundJavaScriptStartingBefore(50000);
        try (PrintWriter out = new PrintWriter("responsepage.html")) {
            out.println(homePage.asXml());
        }
        for (int i = 0; i < 20; i++) {
            System.out.println("Condition: " + homePage.getElementById("voyager-feed").isDisplayed());
            if (homePage.getElementById("voyager-feed").isDisplayed()) {
                break;
            }
//            if (homePage.getElementById("core-rail").isDisplayed())
            synchronized (homePage) {
                homePage.wait(5000);
            }
        }
        try (PrintWriter out = new PrintWriter("page.html")) {
            out.println(homePage.asXml());
        }

        return homePage;
    }

    public static void main(String[] args) throws Exception{
        new LoginLI().getFeed(new LoginLI().login("", ""));
    }
}
