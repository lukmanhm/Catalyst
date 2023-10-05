package PageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Penampung {

	WebDriver driver;
	
	//Data Saat Login
	private String mauLogin = "//div[@class='tt-account tt-dropdown-obj']//button[@class='tt-dropdown-toggle']";
	private String email = "lukman201094@gmail.com";
	private String pass = "MasukPak";
	
	//xpath login
	private By txt_username = By.id("loginInputName");
	private By txt_password = By.id("loginInputPassword");
	private By btn_login = By.id("btn-login");
	private By text_username = By.xpath("//i[contains(@class, 'tt-account-name')]");
	
	//Catalog
	private By MenCategory = By.xpath("//a[@href='/collections/men']//span[contains(text(),'Men')]");
	private By AddToCart = By.xpath("//button[@class='btn btn-lg btn-addtocart addtocart-js']");
	private By modalDialog = By.xpath("//div[@class=\"modal-dialog\"]");
	private By goToCart = By.xpath("//div[@class=\"modal-dialog\"]/div/div[2]/div/a[@class=\"btn btn-border ttmodalbtn ttmodalbtn\"]");
	private By Checkout = By.id("btn-checkout");
	private By ukuranKaki = By.xpath("//ul[@class=\"tt-options-swatch options-large\"]/li[2]/a");
	
	//Checkout
	private By btn_Checkout =  By.xpath("//*[@id=\"pay-button-container\"]/div/div/button");
	private By harga_total = By.xpath("//*[@id=\"app\"]/div/div/div/div[1]/div[1]/div/div[2]/div/div[2]/div/div/aside/div/section/div[2]/div[3]/div[2]/div/div/strong");
	private By payment_amount = By.xpath("//div[@class=\"header-amount\"]");
	
	
	
	
	public void tryCheckOut() {
		driver.findElement(ukuranKaki).click();
		driver.findElement(AddToCart).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until((ExpectedConditions.visibilityOfElementLocated(modalDialog)));
		System.out.println("===I Already in modal===");
		driver.findElement(goToCart).click();
		driver.findElement(Checkout).click();
		
	}
	
	public void CheckCategory() throws InterruptedException {
		Actions action = new Actions(driver);
		WebElement ele = driver.findElement(MenCategory);
		action.moveToElement(ele).perform();
		String bag = "Bags";
		String Watch = "Watches";
		
		for (int i=1; i<=5;i++) {
		    WebElement elem = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/div/div/nav/ul/li[4]/div/div/div[1]/div/div[1]/ul/li[" + i + "]/a/span"));
		    System.out.println("Data yg diambil before "+elem.getText());
		    if(!elem.getText().equals(bag) && !elem.getText().equals(Watch)) {
		    	
		    	System.out.println("Data yg diambil "+elem.getText());
		    	elem.click();
		    	Thread.sleep(1000);
		    	break;
		    }
		}
	}
	
	public boolean validationAmount(String amount) {
		boolean valid = false ;
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until((ExpectedConditions.visibilityOfElementLocated(payment_amount)));
		System.out.println("==I ALready in midtrans page===");
		String paymentPage = driver.findElement(payment_amount).getText();
		String clean = paymentPage.replace("Rp", "");
	    String clean1 = clean.replace(".", "");
	    System.out.println("Harga Payment "+clean1);
		
		if(clean1.equals(amount)) {
			valid = true;
		}
		
		return valid;
	}
	
	public String getAmount() {
		String amt = driver.findElement(harga_total).getText();
	    String clean = amt.replace("Rp ", "");
	    String clean1 = clean.replace(".", "");
	    String clean2 = clean1.replace(",00", "");
		return clean2;
	}
	
	public void goToPaymentPage() {
		driver.findElement(btn_Checkout).click();

	}
	
	public Penampung(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void CheckHarga() {
		
		for (int i=1; i<=10; i++) {
		    WebElement elem = driver.findElement(By.xpath("//*[@id=\"shopify-section-collection-template-boost-pfs-filter\"]/div[2]/div[1]/div[2]/div[4]/div[" + i + "]/div/div[2]/div/p/span"));
		    String temp = elem.getText();
		    String clean = temp.replace("IDR ", "");
		    String clean1 = clean.replace(".", "");
		    System.out.println("Harganya "+clean1);
		    
		    int a = 10000000;
		    int b = Integer.valueOf(clean1);
		    
		    if(b < a) {
		    	WebElement elem1 = driver.findElement(By.xpath("//*[@id=\"shopify-section-collection-template-boost-pfs-filter\"]/div[2]/div[1]/div[2]/div[4]/div[" + i + "]/div/div/a"));
		    	elem1.click();
		    	break;
		    }
		}

	}
	
	public void InputUsernameAndPassword(String username, String password) {
		driver.findElement(txt_username).sendKeys(username);
		driver.findElement(txt_password).sendKeys(password);
	}
	
	public void VerifySuccessLogin() {
		String text = driver.findElement(text_username).getText();
		if(!text.contains("lukman")){
			throw new IllegalStateException("Belum Login");
		}
		
	}
	
	public void clickLogin() {
		driver.findElement(btn_login).click();
	}

	public String getMauLogin() {
		return mauLogin;
	}

	public void setMauLogin(String mauLogin) {
		this.mauLogin = mauLogin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
}
