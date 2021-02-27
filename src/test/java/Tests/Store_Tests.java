package Tests;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ahmed.excelizer.ExcelReader;
import com.automation.remarks.testng.UniversalVideoListener;
import com.automation.remarks.video.annotations.Video;

import pages.CheckOutCartPage;
import pages.SignUpPage;
@Listeners(UniversalVideoListener.class)

public class Store_Tests extends BaseTest {
	SignUpPage signup ;
	CheckOutCartPage checkout;

	
	String ExcelPath = System.getProperty("user.dir")+"\\src\\test\\java\\TestData\\User_Data.xlsx";
	
	@DataProvider (name="SignUpData")
	public Object[][] UserRegistration()
	{
	return  ExcelReader.loadTestData(ExcelPath,"SignUpData");
	}
	
	@DataProvider (name="SignInData")
	public Object[][] UserLogin()
	{
	return  ExcelReader.loadTestData(ExcelPath,"SignInData");
	}
	
	
	@BeforeClass
	public void initialize() throws AWTException
	{

		signup = new SignUpPage(driver);
		checkout= new CheckOutCartPage(driver);

	}



	@Test(priority=1  , dataProvider ="SignUpData" , enabled=false )
	@Video
	public void SignUp (String email , String fname, String lname, String password, String address, String city , String state , String postcode, String mobilenumber) {
		logger = report.createTest("Sign Up With Valid Data");
		signup.EnterUserData(email ,fname , lname , password , address , city , state , postcode , mobilenumber);

		Assert.assertEquals(signup.getSuccessMessage(), "Welcome to your account. Here you can manage all of your personal information and orders.");

		signup.SignOut();
	}


	@Test (priority=2 , dataProvider = "SignInData" )
	@Video
	public void SignIn( String Email , String Password , String UserProfile) {
		logger = report.createTest("Sign In with Created details");
		checkout.Login(Email , Password );

		Assert.assertEquals(checkout.getUserProfile(), UserProfile);



	}



	@Test (priority=3 , dependsOnMethods ="SignIn")
	@Video
	public void CheckoutOrder() {
		logger = report.createTest("Create Order");

		checkout.CreateOrder();
		Assert.assertEquals(checkout.getOrderCompletionMessage(),"On backorder");
	}
}
