package pages;


import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage {

private WebDriver driver;
private ElementsActions elements;

	public SignUpPage(WebDriver driver) throws AWTException {
		
		this.driver=driver;
		elements=new ElementsActions(driver);
	}
		
	
	private By signIn = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a");
	
	private By createEmail = By.id("email_create");
         
	private By createAnAccountButton = By.id("SubmitCreate");
	private By customerFirstname = By.id("customer_firstname");
	private By customerLastname = By.id("customer_lastname");
	private By password = By.id("passwd");
	private By address = By.id("address1");
	private By city = By.id("city");
         
	private By id_country = By.id("id_country");   
	private By state = By.id("id_state");
	private By postCode = By.id("postcode");
	private By MobileNumber = By.id("phone_mobile");
	private By submitAccount = By.id("submitAccount");
	private By athenticate_New_User_Message= By.xpath("//*[@id=\"center_column\"]/p");
	private By signOut = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a");
	
         
	
         
       
	
	public void EnterUserData(String Email , String FirstName , 
			String LastName , String Password , String Address , String City ,
		    String State  , String PostCode , String PhoneNumber
			) {
		
		elements.click(signIn);
		elements.write(createEmail, Email);
		elements.click(createAnAccountButton);
		elements.write(customerFirstname, FirstName);
		elements.write(customerLastname, LastName);
		elements.write(password, Password);
		elements.write(address, Address);
		elements.write(city, City);
		elements.SelectFromDropDown(state, State);		
		elements.write(postCode, PostCode);
		elements.write(MobileNumber, PhoneNumber);
		elements.click(submitAccount);
		
		
		
		}
	
	
	
	public String getSuccessMessage () {
		
		return elements.getElementText(athenticate_New_User_Message);

	}
		
	
	public void SignOut() {
		elements.click(signOut);

	}	
		
		
}	
