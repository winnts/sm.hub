package LinkedIn;

import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;

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
//            webClient.waitForBackgroundJavaScript(10000);
//            webClient.waitForBackgroundJavaScriptStartingBefore(10000);
            //Get Form By name
            final HtmlForm loginForm = loginPage.getFormByName("login");
            final HtmlSubmitInput button = loginForm.getInputByName("signin");
            final HtmlTextInput usernameTextField = loginForm.getInputByName("session_key");
            final HtmlPasswordInput passwordTextField = loginForm.getInputByName("session_password");
            usernameTextField.setValueAttribute("andrey.dyachenko@outlook.com");//your Linkedin Username
            passwordTextField.setValueAttribute("GfHjkm777");//Your Linkedin Password
            final HtmlPage responsePage = button.click();
            webClient.setAjaxController(new NicelyResynchronizingAjaxController());
            webClient.getOptions().setJavaScriptEnabled(true);
            webClient.getOptions().setCssEnabled(true);
            String homeUrl = "https://www.linkedin.com/nhome/";
            final HtmlPage homePage = webClient.getPage(homeUrl);
//            webClient.waitForBackgroundJavaScript(10000);
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
            System.out.println("Element: " + homePage.getElementById("ozfeed"));
            DomElement ozFeed = homePage.getElementById("ozfeed");
            DomNode feedUpdates = ozFeed.getFirstChild().getFirstChild().getFirstChild();
            System.out.println(feedUpdates.asText());



            String htmlBody = homePage.getWebResponse().getContentAsString();
//            System.out.println(htmlBody);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
