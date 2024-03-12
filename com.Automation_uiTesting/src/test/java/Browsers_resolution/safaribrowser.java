package Browsers_resolution;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class safaribrowser {
	public static String url = "https://www.getcalley.com/";
	WebDriver driver;

	@BeforeTest
	public void browsers() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C://Users//anama//Documents//workspace-spring-tool-suite-4-4.16.0.RELEASE//com.Automation_uiTesting//chromedriver-new.exe");
		driver = new SafariDriver();
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
	FileUtils.copyFile(src, new File(".//screenshot//" + screenshot1 + ".png"));
	}
	@AfterTest
	public void close() {
		driver.close();
		
	}
	

}
