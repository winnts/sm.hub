package LinkedIn;

import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;

/**
 * Created by win on 11.01.17.
 */
public class LoginHTMLUnit {
    public static void main(String[] args) {
        try {
            String url = "https://www.linkedin.com/uas/login?goback=&trk=hb_signin";
            final WebClient webClient = new WebClient();
            webClient.getOptions().setJavaScriptEnabled(true);
            webClient.getOptions().setCssEnabled(false);
//            webClient.setAjaxController(new NicelyResynchronizingAjaxController());
            final HtmlPage loginPage = webClient.getPage(url);
            //Get Form By name
            final HtmlForm loginForm = loginPage.getFormByName("login");
            final HtmlSubmitInput button = loginForm.getInputByName("signin");
            final HtmlTextInput usernameTextField = loginForm.getInputByName("session_key");
            final HtmlPasswordInput passwordTextField = loginForm.getInputByName("session_password");
            usernameTextField.setValueAttribute("");//your Linkedin Username
            passwordTextField.setValueAttribute("");//Your Linkedin Password
            final HtmlPage responsePage = button.click();
            webClient.waitForBackgroundJavaScript(30000);
            webClient.waitForBackgroundJavaScriptStartingBefore(30000);
            String htmlBody = responsePage.getWebResponse().getContentAsString();
            webClient.waitForBackgroundJavaScript(30000);
            webClient.waitForBackgroundJavaScriptStartingBefore(30000);
            System.out.println(htmlBody);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
