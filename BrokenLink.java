package Locators;

import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.WebDriver;
import java.net.URL;
import java.net.HttpURLConnection;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLink
{
    public static void main(final String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Downloads\\chromedriver_win32\\chromedriver.exe");
        final WebDriver driver = (WebDriver)new ChromeDriver();
        final String URL = "https://indy.fanxp-dev.pumpjackdataworks.com/login";
        HttpURLConnection Con = null;
        int respCode = 200;
        String url = "";
        driver.get(URL);
        driver.manage().window().maximize();
        driver.findElement(By.name("user")).sendKeys(new CharSequence[] { "superadmin@pumpjackdataworks.com" });
        driver.findElement(By.name("password")).sendKeys(new CharSequence[] { "7&H6T@qU" });
        driver.findElement(By.xpath("//*[@id=\"app\"]/section/div[1]/div[2]/form/button")).click();
        driver.manage().timeouts().implicitlyWait(60L, TimeUnit.SECONDS);
        Thread.sleep(2000);
        final List<WebElement> links = (List<WebElement>)driver.findElements(By.tagName("a"));
        System.out.println("The number of links are = " + links. size());
        final Iterator<WebElement> it = links.iterator();
        while (it.hasNext()) {
            url = it.next().getAttribute("href");
            System.out.println(url);
            try {
                Con = (HttpURLConnection)new URL(url).openConnection();
                Con.setRequestMethod("HEAD");
                Con.connect();
                respCode = Con.getResponseCode();
                if (respCode >= 400) {
                    System.err.println(String.valueOf(url) + " " + "is a broken link");
                }
                else {
                    System.out.println(String.valueOf(url) + " " + "is a valid link");
                }
            }
            catch (Exception e) {
                System.out.println(e);
            }
        } driver.close();
    }
}