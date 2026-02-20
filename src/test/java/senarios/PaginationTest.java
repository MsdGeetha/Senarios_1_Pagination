package senarios;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PaginationTest {
	@Test
	public void checkingEReader() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//h2[contains(text(),'Pagination Web Table')]"));
		js.executeScript("arguments[0].scrollIntoView()",element);
		
		String productName = "Soundbar";
		int pages=4;
		for(int count = 1;count<=pages+1;count++) {
			try {
				driver.findElement(By.xpath("//table[@id='productTable']//td[contains(text(),'"+productName+"')]"));				
				String price = driver.findElement(By.xpath("//table[@id='productTable']//td[contains(text(),'"+productName+"')]/following-sibling::td[1]")).getText();
				System.out.println("Price = "+price);
//				Thread.sleep(3000);
				driver.findElement(By.xpath("//table[@id='productTable']//td[contains(text(),'"+productName+"')]/following-sibling::td[2]/input")).click();
				break;
			} catch (Exception e) {
				System.out.println("coming to the catch blocks"+count);
//				Thread.sleep(3000);
				driver.findElement(By.xpath("//ul[@id='pagination']/li/a[contains(text(),'"+count+"')]")).click();
			}
		}
	}
}
