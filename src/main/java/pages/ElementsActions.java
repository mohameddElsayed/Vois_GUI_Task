package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class ElementsActions {
	
	
	
	private WebDriver driver;
	
	private Select select;
	     FluentWait wait;


	    public ElementsActions(WebDriver driver) throws AWTException {
	        this.driver = driver;
	      
	    }

	    private void waitForElementTobeClickable(By locator) {
	        try {
	            wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(10)).ignoring(NoSuchElementException.class);
	            wait.until(ExpectedConditions.elementToBeClickable(locator));
	        } catch (NoSuchElementException | TimeoutException e) {
	            System.out.println("Failed to find element with locator " + locator.toString());
	        }
	    }

	    public void waitForElementTobeVisible(By locator) {
	        try {
	            wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
	            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	        } catch (NoSuchElementException | TimeoutException e) {
	            System.out.println("Failed to find element with locator " + locator.toString());
	        }
	    }
	    

	    public void click(By locator) {
	        waitForElementTobeClickable(locator);
	        driver.findElement(locator).click();
	        System.out.println("Successfully clicked on element with locator '" + locator.toString() + "'");
	    }

	    public void write(By locator, String text) {
	        waitUntilElementClickableThenSendkeys(locator,text);
	        System.out.println("Successfully wrote text '" + text + "' in element with locator '" + locator.toString() + "'");
	    }

	   


	    public void clearText(By locator){
	        waitForElementTobeVisible(locator);
	        driver.findElement(locator).clear();
	    }



	    public void scrollDownToElement(WebElement element) {
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
	    }


	    public void waitUntilElementClickableThenSendkeys(By element, String data) {
	        // Wait for Element to be visible.
	        try {
	            wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(10)).ignoring(NoSuchElementException.class);
	            wait.until(ExpectedConditions.elementToBeClickable(element));
	            driver.findElement(element).click();
	            driver.findElement(element).sendKeys(data);

	        } catch (Exception e) {
	            System.out.println( "Element not found - sendkeys"+element.toString());
	        }

	    }

	    

	public void ScrollDown (){
	    ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,900)");
}


public String getElementText(By locator) {
    waitForElementTobeVisible(locator);
    String text = driver.findElement(locator).getText();
    System.out.println("Successfully got text '" + text + "' from element with locator '" + locator.toString() + "'");
    return text;
}
public void SelectFromDropDown(By locator,String index) {

	WebElement element = driver.findElement(locator);
	select = new Select(element);
	select.selectByValue(index);
}
}
