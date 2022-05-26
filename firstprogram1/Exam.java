package firstprogram1;

import java.sql.DriverManager;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class Exam {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://damp-sands-8561.herokuapp.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		driver.findElement(By.xpath("//input[@id='user_email']")).sendKeys("phanitestingqa@gmail.com");
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("codetheoryio");
		driver.findElement(By.xpath("//input[@value='Log in']")).submit();
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[text()='view']"))));
		driver.findElement(By.xpath("//a[text()='view']")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[text()='Monthly']"))));
		driver.findElement(By.xpath("//a[text()='Monthly']")).click();
		Thread.sleep(3000);
		String content=driver.findElement(By.xpath("//h3[text()='Monthly Report as of for May']//parent::div//following-sibling::div")).getText();
		if(content
				.equals("No data".trim())) {
			System.out.println("No Data");
			driver.findElement(By.xpath("//a[text()='Levels']")).click();
			for(int i=1;i<=5;i++) {
			driver.findElement(By.xpath("//a[text()='Add new']")).click();
			if(i<=5) {
			driver.findElement(By.xpath("//input[@id='entry_level']")).sendKeys(Integer.toString(i));
			driver.findElement(By.xpath("//input[@value='Submit']")).click();
			if(i==5) {
				if(driver.findElement(By.xpath("//div[text()='Maximum entries reached for this date.']")).isDisplayed()) {
					System.out.println("max limits exceed");
				}else {
					System.out.println("Applicationfails");
				}
		}
		
	}
			}
		}else {
			System.out.println("Data is available");
			
		}
	}
}
