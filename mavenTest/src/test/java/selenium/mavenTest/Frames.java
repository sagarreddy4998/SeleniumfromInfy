package selenium.mavenTest;



import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {
	
	@Test
	void test() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
		driver.findElement(By.xpath("//input[@class='frmTextBox']")).sendKeys("Test1");
		Thread.sleep(3000);
		driver.switchTo().frame("frm1");
		WebElement dropdown = driver.findElement(By.id("course"));
		Select selectdropdown=new Select(dropdown);
		selectdropdown.selectByVisibleText("Java");
		Thread.sleep(3000);
		driver.switchTo().parentFrame();
		driver.findElement(By.xpath("//input[@class='frmTextBox']")).clear();
		Thread.sleep(3000);
		driver.switchTo().frame("frm3");
		
		driver.findElement(By.xpath("//input[@class='frmTextBox']")).sendKeys("Test1");
		Thread.sleep(3000);
	
	driver.quit();
}
}
