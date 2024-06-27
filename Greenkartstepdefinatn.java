package stepdefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
public class Greenkartstepdefinatn {
public WebDriver driver; 	 //to make driver method accessible to all
public String landingpageproductname;
public String offerpageproductname;

	@Given("User is on GreenCart landing page")
	public void user_is_on_green_cart_landing_page() {
	 
		//System.setProperty("webdriver.chrome.driver", "E:\\DIVYA\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
	}
	@When("user searched with Shortname {string} and extracted actual name of product")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortname) {
	   driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortname);
	   landingpageproductname = driver.findElement(By.cssSelector("h4.product-name")).getText();//.split("-")[0].trim();
	  // landingpageproductname = driver.findElement(By.xpath("// h4[@class='product-name']")).getText();
	   // h4[@class='product-name']
	   System.out.println(landingpageproductname + " is extracted from home page");
	   
	}
	@Then("user searched for {string} shortname in offers page")
	public void user_searched_for_same_shortname_in_offers_page(String shortname) throws InterruptedException {
	   driver.findElement(By.linkText("Top Deals")).click();
	   Set<String> s1 = driver.getWindowHandles();
	   Iterator<String> i1 =s1.iterator();
	   String parentwindow = i1.next();
	   String childwindow = i1.next();
	   
	   driver.switchTo().window(childwindow);
	   
	   driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortname);
	   
	   Thread.sleep(2000);
	   
	   offerpageproductname = driver.findElement(By.cssSelector("tr td:nth-child(2)")).getText();
	   }

	@Then("validate product name in offers page matches with landing page")
	public void validate_product_name_in_offers_page() {
		
		Assert.assertEquals(offerpageproductname, landingpageproductname);
	}
	
	
}
