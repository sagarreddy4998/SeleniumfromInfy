package seleniumm;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {
	WebDriver driver;
	String url="https://www.hyrtutorials.com/p/frames-practice.html";

	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		driver.get(url);
	}
	@Test
	public void test() {
		driver.switchTo().frame("1");
		WebElement dropp=driver.findElement(By.xpath("//select[@id='selectnav1']"));
		Select select = new Select(dropp);
		select.selectByIndex(1);
		}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
