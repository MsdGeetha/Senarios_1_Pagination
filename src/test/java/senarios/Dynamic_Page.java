package senarios;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Dynamic_Page {
	@Test
	public void test () throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//h2[contains(text(),'Dynamic Web Table')]"));
		js.executeScript("arguments[0].scrollIntoView()",element);
		Thread.sleep(3000);
		
		String browser = "Firefox";
//		String cpu = driver.findElement(By.xpath("//table[@id='taskTable']/tbody/tr/td[contains(text(),'Chrome')]/following-sibling::td[contains(text(),'%')]")).getText();
//		System.out.println("cpu = "+cpu);
		
		String cpu=driver.findElement(By.xpath("//table[@id='taskTable']/tbody/tr/td[.='"+browser+"']/following-sibling::td[contains(text(),'%')]")).getText();
		System.out.println(cpu);
	}

}
