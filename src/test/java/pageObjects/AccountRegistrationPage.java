package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{
	
	//Constructor
	
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	//Locators
	
	@FindBy(xpath="//input[@id='input-firstname']") WebElement txtfirstname;
	
	@FindBy(xpath="//input[@id='input-lastname']") WebElement txtlastname;
	
	@FindBy(xpath="//input[@id='input-email']") WebElement txtemail;
	
	@FindBy(xpath="//input[@id='input-telephone']") WebElement txttelephone;
	
	@FindBy(xpath="//input[@id='input-password']") WebElement txtpassword;
	
	@FindBy(xpath="//input[@id='input-confirm']") WebElement txtcnfrmpassword;
	
	@FindBy(xpath="//input[@name='agree']") WebElement chkbxagreepolicy;
	
	@FindBy(xpath="//input[@value='Continue']") WebElement btncontinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement msgconfirmation;
	
	
	//Action Methods
	
	public void setFirstName(String fname) {
		txtfirstname.sendKeys(fname);
		
	}
	public void setLastName(String lname) {
		txtlastname.sendKeys(lname);
	}
    public void setEmail(String email) {
    	txtemail.sendKeys(email);
    }
    public void setTelephone(String telephone) {
    	txttelephone.sendKeys(telephone);
    }
	public void setpaswd(String password) {
		txtpassword.sendKeys(password);
	}
	public void confirmpswd(String password) {
		txtcnfrmpassword.sendKeys(password);
	}
	public void setprivacypolicy() {
		chkbxagreepolicy.click();
	}
	public void clickContinue() {
		
		//sol1
		btncontinue.click();
		
		//sol2
		//btncontinue.submit();
		
		//sol3
		//Actions act=new Actions(driver);
		//act.moveToElement(btncontinue).click().perform();
		
		//sol4
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();", btncontinue);
		
		//sol5
		//btncontinue.sendKeys(Keys.RETURN);
		
		//sol6
		//WebDriverWait mywait=new WebDriverWait(driver, Duration.ofSeconds(10));
		//mywait.until(ExpectedConditions.elementToBeClickable(btncontinue)).click();
			
	}
	
	public String getConfirmationMsg() {
		try {
			return(msgconfirmation.getText());
		}catch(Exception e) {
			return(e.getMessage());		
		}	
	}		
}
