package dealsDray;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BulkOrders {
	public static String url = "https://demo.dealsdray.com/";
	WebDriver driver;

	@BeforeTest
	public void browsers() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C://Users//anama//Documents//workspace-spring-tool-suite-4-4.16.0.RELEASE//com.Automation-FunctionalTesting//chromedriver-new.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	@Test
	public void login() throws InterruptedException, IOException {
		
	
	System.out.println(driver.getTitle());
	driver.findElement(By.xpath("//*[@name=\"username\"]")).sendKeys("prexo.mis@dealsdray.com");
	driver.findElement(By.xpath("//*[@name=\"password\"]")).sendKeys("prexo.mis@dealsdray.com");
	
	driver.findElement(By.xpath("//*[@type=\"submit\"]")).click();
	
	}
	
	@Test
	
	public void orders() throws InterruptedException, IOException {
	
		Thread.sleep(2000);
		driver.navigate().to("https://demo.dealsdray.com/mis/orders");
		

		driver.findElement(By.xpath("//*[@class=\"MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButtonBase-root  css-vwfva9\"]")).click();
		Thread.sleep(2000);

		 WebElement file = driver.findElement(By.xpath("//*[@class=\"MuiOutlinedInput-input MuiInputBase-input MuiInputBase-inputSizeSmall css-1imb3v5\"]"));

		 file.sendKeys("C:\\Users\\anama\\Downloads\\demo-data.xlsx");
		 Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class=\"MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButtonBase-root  css-6aomwy\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class=\"MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButtonBase-root  css-6aomwy\"]")).click();
		Thread.sleep(2000);
		Alert alt = driver.switchTo().alert();
		alt.accept();

		Date today = new Date();
		String screenshot1 = today.toString().replace(":", "-");
		System.out.println(screenshot1);
		
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(".//screenshot//" + screenshot1 + ".png"));
	
	}
	@AfterTest
	public void close() {
//		driver.close();
	}
}
