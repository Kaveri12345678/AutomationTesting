package dealsDray;

import java.io.IOException;

import org.jsoup.select.Evaluator.ContainsText;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class plexi {
	public static String url = "https://demo.dealsdray.com/";
	WebDriver driver;
	ExtentReports extent;
	ExtentHtmlReporter htmlreporter;
	ExtentTest test;

	@BeforeTest
	public void browser() throws InterruptedException {
		
		htmlreporter = new ExtentHtmlReporter("extent.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlreporter);

		System.setProperty("webdriver.chrome.driver", "C://Users//anama//Documents//workspace-spring-tool-suite-4-4.16.0.RELEASE//com.Automation-FunctionalTesting//chromedriver-new.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
				
	}
	@Test(enabled = true ,priority = 1)
	public void usernameclick() throws InterruptedException, IOException {
		
	
	System.out.println(driver.getTitle());
	test =extent.createTest("testcases for username field");
	WebElement username= driver.findElement(By.xpath("//*[@name=\"username\"]"));
	test.log(Status.INFO, "Staring the testcase");
	if(username.isDisplayed()) {
		System.out.println("Username field  is visible " + username.getText());
	}
	test.pass("Username is visible");
	username.click();
	Thread.sleep(2000);
	test.pass("Able to click username field");
	username.sendKeys("kkkkkkk");
	Thread.sleep(2000);
	test.pass("Successfully entered the text into the username field");	
	WebElement login  = driver.findElement(By.xpath("//*[@type=\"submit\"]"));
	if(login.isDisplayed()) {
		System.out.println("Login button is visible " + login.getText());
	}
	test.pass("login is visible");
	
	login.click();
	
	test.fail("unable to login into the home page need to enter the password");
	
	
	
//	o/p = uanble to login need to enter the password field
	}
	
	
@Test(enabled = true,priority = 2)
    public void PasswordClick() throws InterruptedException, IOException{
	
	Thread.sleep(2000);
	driver.navigate().refresh();
	WebElement password = driver.findElement(By.xpath("//*[@name=\"password\"]"));
	test =extent.createTest("Testcases for password field");
	if(password.isDisplayed()) {
		System.out.println("password is visible " + password.getText());
		
	}
	test.pass("password is visible");
	password.click();
	test.pass("Able to click the password");
	Thread.sleep(3000);
	password.sendKeys("zzzzz");
	test.pass("Able to send the keys into the password");
	driver.findElement(By.xpath("//*[@type=\"submit\"]")).click();
	
	test.fail("Able to click the login button but unable to login into the home page need to enter the text in username field to login into the home page of the website and it is showing like \"This field is required\".");
//	o/p = uanble to login need to enter the username field
	
}
@Test(enabled = true,priority = 3 )
public void InvalidData() throws InterruptedException, IOException {
     driver.navigate().refresh();
     Thread.sleep(2000);
     driver.findElement(By.xpath("//*[@name=\"username\"]")).sendKeys("prexo.mis@dealsdray.com1");
     
     driver.findElement(By.xpath("//*[@name=\"password\"]")).sendKeys("prexo.mis@dealsdray.com1");
     Thread.sleep(2000);
     test =extent.createTest("Testcases for username field and login field with invalid data");
     test.pass("Entered the the text in both username and password fields");
     driver.findElement(By.xpath("//*[@type=\"submit\"]")).click();
     test.fail("By clicking the login button along with username and password we are unabled to login it is showing like \"wrong username and password\"");

//  o/p = wrong username and password
}


 @Test(enabled = true,priority = 4 )
 public void OnlyLogin() throws InterruptedException {
	 
	 driver.navigate().refresh();
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//*[@type=\"submit\"]")).click();
	 test =extent.createTest("Testcases for login button");
	 test.fail("Able to click the login button but unable to login into the home page need to enter the text in both fields  to login into the home page of the website and it is showing like \"This field is required\".");
	 
	 // o/p= the both fields are required
 }

 
@Test(enabled = true ,priority = 5 )
public void login() throws InterruptedException, IOException {
	
	Thread.sleep(2000);
    driver.findElement(By.xpath("//*[@name=\"username\"]")).sendKeys("prexo.mis@dealsdray.com");
    driver.findElement(By.xpath("//*[@name=\"password\"]")).sendKeys("prexo.mis@dealsdray.com");
    test =extent.createTest("Testcases for username field and password field with valida data");
    test.pass("Successfully entered the text with valid username (prexo.mis@dealsdray.com)into the username fieldand the valid password(prexo.mis@dealsdray.com) into the passwprd field");

    driver.findElement(By.xpath("//*[@type=\"submit\"]")).click();
    test.pass("Successfully logged into the website by clicking the login button with username and password");
//driver.findElement(By.xpath("//*[@class=\"MuiSvgIcon-root MuiSvgIcon-fontSizeMedium MuiAvatar-fallback css-13y7ul3\"]")).click();

//driver.findElement(By.xpath("//*[@class=\"MuiAvatar-root MuiAvatar-circular MuiAvatar-colorDefault css-1v3x69\"]")).click();
//WebElement logout = driver.findElement(By.xpath("//*[@class=\"MuiBox-root css-1jfpitw\"]"));
//logout.click();
//Select se = new Select(logout);
//se.selectByIndex(1);

}

@AfterTest

public void at() {
	driver.close();
	extent.flush();
}
}

