package LinkedIn2017;


import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptJobManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;

/**
 * Created by win on 11.01.17.
 */
public class LoginLISel {



    public static void main(String[] args) throws Exception {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://linkedin.com");
        WebElement loginField = driver.findElement(By.xpath("//div[@id='application-body']//input[@id='login-email']"));
        WebElement loginPasswd = driver.findElement(By.xpath("//div[@id='application-body']//input[@id='login-password']"));
        loginField.sendKeys("");
        loginPasswd.sendKeys("");
        driver.findElement(By.xpath("//div[@id='application-body']//input[@id='login-submit']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("voyager-feed")));
        WebElement feed = driver.findElement(By.id("voyager-feed"));
        System.out.println(feed.getText());
        driver.close();
    }
}
