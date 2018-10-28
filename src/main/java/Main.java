import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Main {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		
	System.out.println("Hello World !!!!!!!!!!!!!!!!!!!!!!");
	
	AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
	service.start();
	//your test scripts logic...
	
	
	DesiredCapabilities dc=new DesiredCapabilities();
	
	dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android device");
	dc.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
	AndroidDriver<AndroidElement> driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),dc);
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("http://m.cricbuzz.com/");
	((JavascriptExecutor) driver).executeScript("window.scrollBy(0,400)", "");
	WebElement webElement=driver.findElement(By.xpath("//a[text()='Windows']"));
	((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,webElement);
	webElement.click();
	
	Thread.sleep(3000);
	driver.quit();
	
	service.stop();
	}

}
