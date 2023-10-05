package stepsDef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import PageObject.Penampung;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Transaction {

	WebDriver driver = null;
	Penampung penampung;
	
	@Given("user is in login page")
	public void user_is_in_login_page() {
		System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver");
		 driver = new ChromeDriver();
	   driver.get("https://voila.id/");
	   Penampung penampung = new Penampung(driver);
	   driver.findElement(By.xpath(penampung.getMauLogin())).click();
	    
	}

	@When("user input username and password")
	public void user_input_username_and_password() {
	   
		Penampung penampung = new Penampung(driver);
		penampung.InputUsernameAndPassword(penampung.getEmail(), penampung.getPass());
		//driver.findElement(By.id("loginInputName")).sendKeys("lukman201094@gmail.com");
	}

	@And("click button login")
	public void click_button_login() {
	   
		Penampung penampung = new Penampung(driver);
		penampung.clickLogin();
	}

	@And("user will be success login and navigate to homepage")
	public void user_will_be_success_login_and_navigate_to_homepage() throws InterruptedException {
	   
		Penampung penampung = new Penampung(driver);
		penampung.VerifySuccessLogin();
		penampung.CheckCategory();
	}
	
	@Then("user will be choose one product")
	public void user_will_be_choose_one_product() {
	   
		Penampung penampung = new Penampung(driver);
		penampung.CheckHarga();
	}
	
	@And("user do checkout")
	public void user_do_checkout() {
	   
		Penampung penampung = new Penampung(driver);
		penampung.tryCheckOut();
		
		
	}
	
	@And("confirm payment")
	public void confirm_payment() throws InterruptedException {
	   
		Penampung penampung = new Penampung(driver);
		String amtTotal = penampung.getAmount();
		System.out.println("Harga Total " + amtTotal);
		penampung.goToPaymentPage();
		penampung.validationAmount(amtTotal);
		System.out.println("Success");
		driver.quit();
	}
	
	
	
}
