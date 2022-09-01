package Locators;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ForgetPass {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\DELL\\Documents\\Automation\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://indy.fanxp-dev.pumpjackdataworks.com/login");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/section/div[1]/div[2]/form/a")).click();
		driver.findElement(By.xpath("//*[@id=\"app\"]/section/div[1]/div[2]/div/div/div/input")).sendKeys("umair@mailinator.com");
		driver.findElement(By.xpath("//*[@id=\"app\"]/section/div[1]/div[2]/div/button[1]")).click();
		Thread.sleep(2000);
		driver.navigate().to("https://www.mailinator.com/v4/public/inboxes.jsp?to=umair");
		List<WebElement> unreademail = driver.findElements(By.xpath("//*[@id=\"inbox_pane\"]/div[3]/div/div[4]/div/div/table"));
		Thread.sleep(2000);
		System.out.println("Total No. of Unread Mails: " + unreademail.size());

		for(int i=0;i<unreademail.size();i++)
		{

		System.out.println("Latest Mail : "+ unreademail.get(i).getText());

		}

		unreademail.get(0).click();
		
		//Scrolling
		
		Thread.sleep(2000);
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, 250)");
//		Thread.sleep(2000);
		
//		WebElement m = driver.findElement(By.className("tab-pane fade m-b-20 show active"));
//	    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", m);
	    Thread.sleep(3000);
		driver.close();
		
	}
}

