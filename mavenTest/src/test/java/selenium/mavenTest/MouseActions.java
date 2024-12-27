package selenium.mavenTest;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

class MouseActions {

	@Test
	void test() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		driver.get("https://dhtmlx.com/docs/products/dhtmlxTree/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		try {
			WebElement prod=driver.findElement(By.xpath("/html/body/div/header/div/div/div/div/div/nav/ul/li[1]/span"));
			WebElement gant=driver.findElement(By.xpath("//span[.='Gantt']"));
			WebElement kanban=driver.findElement(By.xpath("//span[.='Kanban']"));
			Actions Act = new Actions(driver);
			Act.moveToElement(prod).perform();
			Thread.sleep(3000);
			Act.moveToElement(gant).click().build().perform();
			Thread.sleep(10000);
			System.out.println(driver.getTitle());
			System.out.println("Done");
			driver.navigate().back();
			Thread.sleep(10000);
			Act.moveToElement(prod).perform();
			Thread.sleep(3000);
			Act.moveToElement(kanban).click().build().perform();
			Thread.sleep(10000);
			System.out.println(driver.getTitle());
			System.out.println("Done");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("you got error \n"+e);
		}
		finally {
		driver.quit();
	}}

}
