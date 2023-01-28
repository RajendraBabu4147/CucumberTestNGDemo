package cucumbertest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class loginTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		WebDriver driver;
		
		System.setProperty("webdriver.edge.driver", "C:\\ShiftGear\\Drivers\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.get("http://adactinhotelapp.com");
		
		driver.manage().window().maximize();
		
	    WebElement uName= driver.findElement(By.id("username"));
	    uName.sendKeys("RajendraBabu07");
	    driver.findElement(By.id("password")).sendKeys("8J1O4L");
	    driver.findElement(By.id("login")).click();
	}

}
