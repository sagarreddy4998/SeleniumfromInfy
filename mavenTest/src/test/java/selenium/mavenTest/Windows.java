package selenium.mavenTest;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

class Windows {
	WebDriver driver;
	String url="https://www.hyrtutorials.com/p/window-handles-practice.html";

	@BeforeMethod
	public void setup() {
		}

	@Test
	public void test() throws InterruptedException {
		driver= new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		driver.get(url);
		driver.manage().window().maximize();
		String Parenthandle=driver.getWindowHandle();
		System.out.println(Parenthandle +" " + driver.getTitle());
		 driver.findElement(By.xpath("//button[@id='newWindowBtn']")).click();
		 Thread.sleep(3000);
		 Set <String> allhandles =driver.getWindowHandles();
		 for (String child1 : allhandles) {
			 if (!Parenthandle.equals(child1)) {
				 driver.switchTo().window(child1);
				 driver.manage().window().maximize();
				 driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Test");
				 Thread.sleep(3000);
				
		}
		System.out.println(child1+" " +driver.getTitle());
		}
		 driver.close();
		 driver.switchTo().window(Parenthandle);
		 driver.findElement(By.id("name")).sendKeys("Test2");
		 Thread.sleep(3000);
		 //Tab
		 driver.findElement(By.id("name")).clear();
		driver.findElement(By.xpath("//button[@id=\"newTabBtn\"]")).click();
		Set <String> tabb=driver.getWindowHandles();
		for (String Tabs : tabb) {
			if (!Tabs.equals(Parenthandle)) {
				
		driver.switchTo().window(Tabs);
		Thread.sleep(3000);
		System.out.println("whatisOutput1"+driver.findElement(By.id("output")).getText());
		driver.findElement(By.xpath("//button[text()='Click me']")).click();
		System.out.println(driver.switchTo().alert().getText());
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		System.out.println("whatisOutput2"+driver.findElement(By.id("output")).getText());
		Thread.sleep(3000);
		System.out.println("Done");
		
		}}
			driver.close();
			 driver.switchTo().window(Parenthandle);
			 driver.findElement(By.id("name")).sendKeys("Test2");
			 Thread.sleep(5000);
			 //Tab
			 driver.findElement(By.id("name")).clear();
			 Thread.sleep(3000);
			 driver.quit();
			 System.out.println("Done");
			 }		 
}
