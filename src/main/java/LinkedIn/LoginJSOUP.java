package LinkedIn;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by win on 11.01.17.
 */
public class LoginJSOUP {
    public static void main(String[] args) {
        try {
            String url = "https://www.linkedin.com/uas/login?goback=&trk=hb_signin";
            Connection.Response response = Jsoup
                    .connect(url)
                    .method(Connection.Method.GET)
                    .execute();

            Document responseDocument = response.parse();
            Element loginCsrfParam = responseDocument
                    .select("input[name=loginCsrfParam]")
                    .first();

            response = Jsoup.connect("https://www.linkedin.com/uas/login-submit")
                    .cookies(response.cookies())
                    .data("loginCsrfParam", loginCsrfParam.attr("value"))
                    .data("session_key", "")
                    .data("session_password", "")
                    .method(Connection.Method.POST)
                    .followRedirects(true)
                    .execute();

            Document document = response.parse();
            Element feed = document.getElementById("ozfeed-container");
            System.out.println(document);
//            System.out.println("Welcome "
//                    + document.select(".act-set-name-split-link").html());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
