package Browsers_resolution;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class firefoxBrowser {
	public static String url = "https://www.getcalley.com/calley-call-from-browser/";
	WebDriver driver;

	@BeforeTest
	public void browsers() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C://Users//anama//Documents//workspace-spring-tool-suite-4-4.16.0.RELEASE//com.Automation_uiTesting//geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	@Test
	public void Screenshotss() throws InterruptedException, IOException {
	
	System.out.println(driver.getTitle());
	Date today = new Date();
	String screenshot1 = today.toString().replace(":", "-");
	System.out.println(screenshot1);
	
	File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File(".//firefoxScreenshot//" + screenshot1 + ".png"));
	}
	@AfterTest
	public void close() {
		driver.close();
	}
}
