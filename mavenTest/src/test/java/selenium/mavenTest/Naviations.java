package selenium.mavenTest;


import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

class Naviations {

	@Test
	void test() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("Test");
		//Thread.sleep(3000);
		driver.navigate().refresh();
		driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("Test");
		//Thread.sleep(3000);
		driver.navigate().to("https://www.hyrtutorials.com/p/frames-practice.html");
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@class='frmTextBox']")).sendKeys("Test1");
		//Thread.sleep(3000);
		driver.navigate().back();
		//Thread.sleep(3000);
		driver.navigate().forward();
		//Thread.sleep(2000);
		try {
			driver.findElement(By.id("AVV"));
		} catch (Exception e) {
			System.out.println("exception"+e);
			// TODO Auto-generated catch block
			
		}
		driver.quit();
		
	}

}
