package stepDefinition;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class testSteps {

	
	WebDriver driver;
	
	String usName = "";
	String expectedTitle = "Adactin.com - Search Hotel";
	
	@Before
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\Chrome_Driver\\chromedriver.exe");
		driver = new EdgeDriver();
		//driver.get("https://adactinhotelapp.com/");
		driver.manage().window().maximize();
		}
	
	
	@After
	public void teardown(Scenario scenario)
	{
		if (scenario.isFailed())
			
	
	{
		final byte[] screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", scenario.getName());
		}
		driver.quit();
	}
	
@Given("when the user is on the login page")
public void when_the_user_is_on_the_login_page() {
	
	System.setProperty("webdriver.edge.driver", "C:\\ShiftGear\\Drivers\\msedgedriver.exe");
	driver = new EdgeDriver();
	driver.get("http://adactinhotelapp.com");
	
	driver.manage().window().maximize();
    // Write code here that turns the phrase above into concrete actions
	//System.out.println("I am in Login Page");
	}



@When("user enters user name and password")
public void user_enters_user_name_and_password() {
	
	 	WebElement uName= driver.findElement(By.id("username"));
	    uName.sendKeys("RajendraBabu07");
	    usName = "RajendraBabu07";
	    driver.findElement(By.id("password")).sendKeys("8J1O4L");
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("User will enter Name and Password");
}


@When("user enters \"(.*)\", \"(.*)\"$")
public void user_enters(String userName,String passWord) {
	
	 	WebElement uName= driver.findElement(By.id("username"));
	    uName.sendKeys(userName);
	    usName = userName;	
	    driver.findElement(By.id("password")).sendKeys(passWord);
	    // Write code here that turns the phrase above into concrete actions
	    //System.out.println("User will enter Name and Password");
}

@When("user clicks on login button")
public void user_clicks_on_login_button() {

	driver.findElement(By.id("login")).click();
    // Write code here that turns the phrase above into concrete actions
	System.out.println("Login button is clicked");
}

@Then("login is successfull")
public void login_is_successfull() {
	String actualGreeting = driver.findElement(By.name("username_show")).getAttribute("value");
	
	//String greeting = driver.getTitle();
	//System.out.println(actualGreeting);

			
	//System.out.println("Page title is : " + driver.getTitle());
    // Write code here that turns the phrase above into concrete actions
	//System.out.println("Login Success");
	
	String expectedGreeting = "Hello "+usName+"!";
	assertEquals(expectedGreeting, actualGreeting);
	
	
}

@Then("Search page is displayed")
public void search_page_is_displayed() {
	
	String actualTitle = driver.getTitle();
	assertEquals(expectedTitle, actualTitle);
	
	
    // Write code here that turns the phrase above into concrete actions
	//System.out.println("Search page is disaplyed");


}



@When("user selects \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\"$")
public void user_selects(String location, String rooms, String checkindate, String checkoutdate, String adults) {
	  //Drop down  to select LOCATION
    new Select(driver.findElement(By.className("search_combobox"))).selectByValue(location);


    //Drop down to select Number of Rooms
     new Select(driver.findElement(By.id("room_nos"))).selectByValue(rooms);

     //Date picker-Enter check in date
     WebElement checkinDate = driver.findElement(By.id("datepick_in"));
     checkinDate.clear();
     checkinDate.sendKeys(checkindate);

     //Date picker-Enter checkout date
     WebElement checkoutDate = driver.findElement(By.id("datepick_out"));
     checkoutDate.clear();
     checkoutDate.sendKeys(checkoutdate);

     //Select Adults per room
     new Select(driver.findElement(By.id("adult_room"))).selectByValue(adults);

}



@When("user clicks on search")
public void user_clicks_on_search_button() {
//Click on Search
driver.findElement(By.id("Submit")).click();
}



@Then("search results should be displayed")
public void search_results_should_be_displayed() {
System.out.println("Successful search page");
//driver.quit();


}

@When("user clicks on selects hotel")
public void user_clicks_on_selects_hotel() {
    // Write code here that turns the phrase above into concrete actions
	driver.findElement(By.id("radiobutton_4")).click();
	
	
}

@When("user clicks on continue")
public void user_clicks_on_continue() {
    // Write code here that turns the phrase above into concrete actions
	driver.findElement(By.id("continue")).click();
	
	

}

//@When("user fills book hotel form")
//public void user_fills_book_hotel_form()

@When("user fills book hotel form \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\"$")
public void user_fills_book_hotel_form(String firstName, String LastName, String uAddress, String creditCardNumber, String creditCardType, String expiryMonth, String expiryYear, String cvvNumber ) {

 
    // Write code here that turns the phrase above into concrete actions
	WebElement fName= driver.findElement(By.id("first_name"));
	fName.sendKeys(firstName);
	
	WebElement lsName= driver.findElement(By.id("last_name"));
	lsName.sendKeys(LastName);
	
	WebElement uAdd= driver.findElement(By.id("address"));
	uAdd.sendKeys(uAddress);
	
	WebElement cCNumber= driver.findElement(By.id("cc_num"));
	cCNumber.sendKeys(creditCardNumber);
	
	new Select(driver.findElement(By.id("cc_type"))).selectByValue(creditCardType);

	//VISA
	
	new Select(driver.findElement(By.id("cc_exp_month"))).selectByVisibleText(expiryMonth);
	
	//January
	new Select(driver.findElement(By.id("cc_exp_year"))).selectByValue(expiryYear);
	
	//2022
	
	WebElement cvNumber= driver.findElement(By.id("cc_cvv"));
	cvNumber.sendKeys(cvvNumber);
	
	//123
}

@SuppressWarnings("deprecation")
@When("user clicks on book now")
public void user_clicks_on_book_now() {
    // Write code here that turns the phrase above into concrete actions
	
	driver.findElement(By.id("book_now")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	

}

@When("user click on my itinerary")
public void user_click_on_my_itinerary() {
    // Write code here that turns the phrase above into concrete actions
	driver.findElement(By.id("my_itinerary")).click();
	driver.quit();
	

}



@Given("This is a blank test")
public void this_is_a_blank_test() {
    // Write code here that turns the phrase above into concrete actions
   // throw new io.cucumber.java.PendingException();
	System.out.println("Blank Test");
}
}

