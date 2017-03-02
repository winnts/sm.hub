package LinkedIn2017;


import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptJobManager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;

/**
 * Created by win on 11.01.17.
 */
public class LoginLI {
//    public WebClient webClient = new WebClient(BrowserVersion.CHROME);

    public DomNode getFeed(HtmlPage homePage) throws Exception {
        //Enable JS for home page
//        webClient.setAjaxController(new NicelyResynchronizingAjaxController());
//        webClient.getOptions().setJavaScriptEnabled(true);
//        webClient.getOptions().setCssEnabled(false);

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

    public HtmlPage login(String login, String passwd) throws IOException, InterruptedException {
        Iterable<DomNode> feedAll = null;
        java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF);
        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");

//            String url = "https://www.linkedin.com/uas/login?goback=&trk=hb_signin";
        String url = "https://www.linkedin.com";
        final WebClient webClient = new WebClient(BrowserVersion.CHROME);

        //Disabling JS for Login page

//            webClient.setAjaxController(new NicelyResynchronizingAjaxController());
        webClient.getOptions().setJavaScriptEnabled(false);
        webClient.getOptions().setCssEnabled(false);
//        webClient.getOptions().setThrowExceptionOnScriptError(false);
//            webClient.waitForBackgroundJavaScriptStartingBefore(50000);

        //Set browser size
        webClient.getWebWindows().get(0).setInnerWidth(1920);
        webClient.getWebWindows().get(0).setInnerHeight(1024);

        HtmlPage loginPage = null;
        try {
            loginPage = webClient.getPage(url);
        } catch (Exception e) {
            System.out.println("Get page error");
        }
        JavaScriptJobManager manager = loginPage.getEnclosingWindow().getJobManager();
        while (manager.getJobCount() > 0) {
            Thread.sleep(1000);
        }
        try (PrintWriter out = new PrintWriter("login.html")) {
            out.println(loginPage.asXml());
        }

        //Get Form By name
//            final HtmlForm loginForm = loginPage.getFormByName("login");
        final HtmlForm loginForm = (HtmlForm) loginPage.getByXPath("//div[@id='application-body']//form[@class='login-form ']").get(0);
//            final HtmlSubmitInput button = loginForm.getInputByName("signin");
        final HtmlSubmitInput button = (HtmlSubmitInput) loginForm.getByXPath("//div[@id='application-body']//input[@id='login-submit']").get(0);
//            final HtmlTextInput usernameTextField = loginForm.getInputByName("session_key");
        final HtmlTextInput loginName = (HtmlTextInput) loginForm.getByXPath("//div[@id='application-body']//input[@id='login-email']").get(0);
//            final HtmlPasswordInput passwordTextField = loginForm.getInputByName("session_password");
        final HtmlPasswordInput loginPasswd = (HtmlPasswordInput) loginForm.getByXPath("//div[@id='application-body']//input[@id='login-password']").get(0);
//            final HtmlTextInput loginInput = loginPage.
        loginName.setValueAttribute(login);
        loginPasswd.setValueAttribute(passwd);
//        usernameTextField.setValueAttribute(login);//your Linkedin Username
//            passwordTextField.setValueAttribute(passwd);//Your Linkedin Password
        final HtmlPage responsePage = button.click();
        //Enable JS for home page
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.waitForBackgroundJavaScript(50000);
        webClient.waitForBackgroundJavaScriptStartingBefore(50000);

        try (PrintWriter out = new PrintWriter("afterloginpage.html")) {
            out.println(responsePage.asXml());
        }

        String homeUrl = "https://www.linkedin.com/feed/";
//            final HtmlPage homePage = webClient.getPage(homeUrl);

        HtmlPage homePage = null;
        try {
            homePage = webClient.getPage(homeUrl);
        } catch (Exception e) {
            System.out.println("Get page error");
        }
        JavaScriptJobManager manager1 = homePage.getEnclosingWindow().getJobManager();
        while (manager1.getJobCount() > 0) {
            Thread.sleep(50000);
        }
        try (PrintWriter out = new PrintWriter("responsepage1.html")) {
            out.println(homePage.asXml());
        }
        homePage.refresh();

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

    public static void main(String[] args) throws Exception {
//        new LoginLI().getFeed(new LoginLI().login("andrey.dyachenko@outlook.com", "GfHjkm777"));
        new LoginLI().login("", "");
    }
}
