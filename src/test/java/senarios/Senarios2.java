package senarios;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Senarios2 {
	@Test
	public void test() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.amazon.in/");
		WebElement element = driver.findElement(By.xpath("//span[@class='icp-nav-link-inner']"));
		
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		
		driver.findElement(By.xpath("//div[@id='nav-flyout-icp']/div[@class='nav-template nav-flyout-content nav-tpl-itemList']/ul/li/a[@lang=\"mr-IN\"]/span/i")).click();
		System.out.println("Checking the conflicts");
	}
}
