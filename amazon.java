package trip;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class amazon {
	public static String url="https://www.amazon.com/";
	WebDriver driver;
	@BeforeTest
	public void bt() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.getTitle();
		System.out.println(driver.getTitle());
	
	
	}
	
	@Test
	public void mobiles() throws InterruptedException {
		Thread.sleep(20000);
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		Thread.sleep(3000);
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		Thread.sleep(3000);
		search.click();
		Thread.sleep(3000);
		search.sendKeys("Samsung s23 Ultra Black");
		Thread.sleep(3000);
		driver.findElement(By.id("nav-search-submit-button")).click();
		Thread.sleep(3000);
		driver.getTitle();
		System.out.println(driver.getTitle());
		//WebElement m = 
		//driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[2]/div/div/div/div/div/div/div/div[2]/div/div/div[1]/h2/a/span")).click();
		driver.findElement(By.xpath("//*[@class='a-size-medium a-color-base a-text-normal']")).click();
		//	driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/div/div/div/div[2]/div/div/div[1]/h2/a/span")).click();
		//if we use webelement to this above xpath it will trow the exception as stale element reference to solve that exception we can
		//use try and catch method
		
		//m.click();
		driver.getTitle();
		System.out.println(driver.getTitle());
		Thread.sleep(3000);
		driver.findElement(By.id("add-to-cart-button")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("attach-close_sideSheet-link")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("nav-cart")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//*[@type='submit'])[5]")).click();// if we have same xpath for the multiple elements then  we can use the index for the the particular elelement
		//delete element is visible in the 5th index...this is the exact xpath
		Thread.sleep(3000);
		driver.findElement(By.tagName("h1")).getText();
		System.out.println("Your CART is EMPTY");
		
		
	}
	
	@Test(enabled=false)
	public void others() throws InterruptedException {
		Thread.sleep(20000);

		driver.findElement(By.xpath("(//*[@type='submit'])[2]")).click();//xpath for dont change
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//*[@class='nav-a  '])[1]")).click();
		Thread.sleep(5000);
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("window.scrollby(0,800)");
		//js.executeScript("window.scrollBy(0,800)");
		driver.findElement(By.xpath("(//*[@class='nav-a  '])[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//*[@class='nav-a  '])[3]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//*[@class='nav-a  '])[4]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//*[@class='nav-a  '])[5]")).click();
		Thread.sleep(3000);

	}
	@Test(enabled=false)
	public void sarees() throws InterruptedException {
		driver.findElement(By.xpath("")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("")).click();
		Thread.sleep(3000);


	}
	@AfterTest
	public void close() {
        driver.close();
	}
}
