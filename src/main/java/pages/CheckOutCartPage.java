package pages;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckOutCartPage {

	
	
	
	private WebDriver driver;
	private ElementsActions elements;

		public CheckOutCartPage(WebDriver driver) throws AWTException {
			
			this.driver=driver;
			elements=new ElementsActions(driver);
		}
		
		private By signIn = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a");
        private By email = By.id("email");
        private By password = By.id("passwd");
        private By login = By.id("SubmitLogin");
        private By userProfile = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span");
        
        private By selectWomen = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a");
        private By selectTops = By.xpath("//*[@id=\"subcategories\"]/ul/li[1]/div[1]/a");
        private By selectBlouses = By.xpath("//*[@id=\"subcategories\"]/ul/li[2]/div[1]/a");
		private By More = By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[2]");
	    private By selectColor = By.xpath("//*[@id=\"color_8\"]");
	    private By selectSizeDrobDown = By.id("group_1");
	    private By AddToCart = By.xpath("//*[@id=\"add_to_cart\"]/button");
        private By ProceedToCheckout1 = By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a");
        private By ProceedToCheckoutPage2 = By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]");
        private By ProceedToCheckoutPage3 = By.name("processAddress");
        private By agreeTerms = By.name("cgv");
        private By ProceedToCheckOutPage4 = By.name("processCarrier");
 	    private By PayByBankWire = By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a");
        private By IConfirmMyOrder = By.xpath("//*[@id=\"cart_navigation\"]/button");
        private By BackToMyOrders = By.xpath("//*[@id=\"center_column\"]/p/a");
        private By orderStatus= By.xpath("//*[@id=\"order-list\"]/tbody/tr[1]/td[5]/span");
        
        public void Login (String Email , String Password) {
        	
        	elements.click(signIn);
        	elements.write(email, Email);
        	elements.write(password, Password);
        	elements.click(login);
        	
        }
		
		public String getUserProfile() {
			
			return elements.getElementText(userProfile);
			
		}
		
		
		
		public void CreateOrder () {
			elements.click(selectWomen);
			elements.click(selectTops);
			elements.click(selectBlouses);
			elements.click(More);
			elements.click(selectColor);
			elements.SelectFromDropDown(selectSizeDrobDown, "2");
			elements.click(AddToCart);
			elements.ScrollDown();
			elements.click(ProceedToCheckout1);
			elements.ScrollDown();
			elements.click(ProceedToCheckoutPage2);
			elements.ScrollDown();
			elements.click(ProceedToCheckoutPage3);
			elements.click(agreeTerms);
			elements.click(ProceedToCheckOutPage4);
			elements.ScrollDown();
			elements.click(PayByBankWire);
			elements.click(IConfirmMyOrder);
			elements.click(BackToMyOrders);

			
		}
		
public String getOrderCompletionMessage() {
			
			return elements.getElementText(orderStatus);
			
		}
		
}

