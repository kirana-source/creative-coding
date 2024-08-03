package com.utility;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtils extends BasePage {
	
	public WebDriverUtils(WebDriver driver) {
		super(driver);
		System.out.println("WebDriver instance in WebDriverUtils: " + (driver != null));
	}
	
	static String mainId = null;
	

	/**
	 * This method will usedTo Wait for  Visibility of Specific Element in GUI
	 * @param locator : Provide the Locator of the element for which you want to wait
	 * @param timeout : Provide how much time you want to wait in Seconds
	 * @return 
	 */
	public static WebElement waitForElementVisibility(By locator , long timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			return element;
		}
		catch(Exception ex) {
			System.out.println("Element Not Visible in Specified Time");
			return null;
		}

	}
	
	public static WebElement waitForElementVisibility(WebElement locator , long timeout) {
		try {
			WebElement element = new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.visibilityOfElementLocated((By) locator));
			return element;
		}
		catch(Exception ex) {
			System.out.println("Element Not Visible in Specified Time");
			return null;
		}

	}

	/**
	 * This method will usedTo Wait for  Presence of Specific Element in GUI
	 * @param locator : Provide the Locator of the element for which you want to wait
	 * @param timeout : Provide how much time you want to wait in Seconds
	 * @return 
	 */
	public static WebElement waitForElementPresence(By locator , long timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return element;
	}

	/**
	 * This method will usedTo Wait for  Page Title to be Available
	 * @param pageTitle : Provide the Title of the Page
	 * @param timeout : Provide the time in Seconds
	 */
	public static void waitForPageTitleVisibility(String pageTitle , long timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.titleContains(pageTitle));
	}

	/**
	 * This method will usedTo wait for checking WebElement with given locator has attribute which contains specificValue
	 * @param element : used to define WebElement to check its parameters
	 * @param attribute : used to define css or html attribute
	 * @param value :  used as expected attribute value
	 * @param timeout : Provide how much time you want to wait in Seconds
	 * @return 
	 */
	public static boolean waitForElementAttributeCointainsValue(By element ,String attribute, String value, long timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
			wait.until(ExpectedConditions.attributeContains(element, attribute, value));
			return true;
		}catch(Exception ex) {
			System.out.println("Element's Atrribute not Contains the Value");
			return false;
		}
	}

	/**
	 * This method will usedTo wait for checking WebElement with given locator has attribute which Not contains specificValue
	 * @param element : used to define WebElement to check its parameters
	 * @param attribute : used to define css or html attribute
	 * @param value :  used as expected attribute value
	 * @param timeout : Provide how much time you want to wait in Seconds
	 */
	public static void waitForElementAttributeNotCointainsValue(By element ,String attribute, String value, long timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
			wait.until(ExpectedConditions.not(ExpectedConditions.attributeContains(element, attribute, value)));
		}catch(Exception ex) {
			System.out.println("Element's Atrribute still Contains the Value");
		}
	}

	/**
	 * This method will usedTo Wait for  Specific Element to be Clickable
	 * @param locator : Provide the Locator of the element for which you want to wait to do click action
	 * @param timeout : Provide how much time you want to wait in Seconds
	 */
	public static WebElement waitForElementInterActibility(By locator , long timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		return element;
	}
	
	public static WebElement waitForElementInterActibility(WebElement locator , long timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		return element;
	}

	/**
	 * This method will usedTo Wait for  Visibility of All Elements in GUI
	 * @param locator : Provide the Locator of the List of elements for which you want to wait
	 * @param timeout : Provide how much time you want to wait in Seconds
	 * @return 
	 */
	public static List<WebElement> waitForVisibilityOfAllElements(By locator , long timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		List<WebElement> elementsList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		return elementsList;
	}

	/**
	 * This method will usedTo Wait for  Presence of All Elements in GUI
	 * @param locator : Provide the Locator of the List of elements for which you want to wait
	 * @param timeout : Provide how much time you want to wait in Seconds
	 * @return 
	 */
	public static List<WebElement> waitForPresenceOfAllElements(By locator , long timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		List<WebElement> elementsList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		return elementsList;
	}

	/**
	 * This method will usedTo Wait for  Invisibility of Specific Element in GUI
	 * @param locator : Provide the Locator of the element for which you want to wait
	 * @param timeout : Provide how much time you want to wait in Seconds
	 * @return 
	 */
	public static Boolean waitForInvisibilityOfElement(By locator , long timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		Boolean flag = wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
		return flag;
	}

	/**
	 * This method will usedTo Wait for  Invisibility of Specific Element With Specific Text in GUI
	 * @param locator : Provide the Locator of the element for which you want to wait
	 * @param text : text of the element
	 * @param timeout : Provide how much time you want to wait in Seconds
	 */
	public static Boolean waitForInvisibilityOfElementBySpecificText(By locator ,String text, long timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		Boolean flag = wait.until(ExpectedConditions.invisibilityOfElementWithText(locator, text));
		return flag;
	}


	/**
	 * This method will usedTo Select the value from the Dropdown Based On Value
	 * @param dropDownLocator
	 * @param text
	 */
	public static boolean selectByValue(By dropDownLocator , String text, long timeout) {
		try {
			WebElement dropDwnElmt = waitForElementVisibility(dropDownLocator, timeout);
			Select sel = new Select(dropDwnElmt);
			sel.selectByValue(text);
			return true;
		}

		catch(Exception e) {
			return false;
		}

	}

	/**
	 * This method will usedTo Select the value from the Dropdown Based On VisibleText
	 * @param dropDownLocator used to 
	 * @param text value need to select
	 * @return true if selected else false
	 */
	public static boolean selectByVisibleText(By dropDownLocator , String text, long timeout) {
		try{
			WebElement dropDwnElmt = waitForElementVisibility(dropDownLocator, timeout);
			Select sel = new Select(dropDwnElmt);
			sel.selectByVisibleText(text);
			return true;
		}
		catch(Exception e) {
			return false;
		}

	}

	/**
	 * This method will usedTo Select the value from the Dropdown Based On Index
	 * @param dropDownLocator
	 * @param index
	 */
	public static void selectByIndex(By dropDownLocator , int index, long timeout) {
		WebElement dropDwnElmt = waitForElementVisibility(dropDownLocator, timeout);
		Select sel = new Select(dropDwnElmt);
		sel.selectByIndex(index);

	}
	
	/**
	 * This method will usedTo Switch to new Window By Title of the Page
	 * @param pageTitle : Provide the Title of the Page you want to switch
	 */
	public static void switchToNewTab(String pageTitle) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();

		while (it.hasNext()) {
			String winID = it.next();
			driver.switchTo().window(winID);
			String currentPageTitle = driver.getTitle();
			if(currentPageTitle.contains(pageTitle)) {
				break;
			}

		}
	}
	/**
	 * This method will usedTo Switch to popup window
	 */
	public static void switchToPoupWindow() {
		mainId = driver.getWindowHandle();
		Set<String> allId = driver.getWindowHandles();
		for(String id : allId) {
			if(!id.equals(mainId)) {
				driver.switchTo().window(id);
			}
		}
	}
	/**
	 * This method will usedTo Switch to Main window
	 */
	public static void switchToMainWindow() {
		driver.switchTo().window(mainId);
	}

	/**
	 * This method will usedTo Accept Alert
	 */
	public static void alertOk() {
		driver.switchTo().alert().accept();
	}
	/**
	 * This method will usedTo Cancel Alert
	 */
	public static void alertCancel() {
		driver.switchTo().alert().dismiss();

	}
	/**
	 * This method will usedTo Fetch Alert text
	 * @return alertText
	 */
	public static String getAlertText() {
		return driver.switchTo().alert().getText();
	}

	/**
	 * This method will usedTo Mouse Hover on Element
	 * @param locator
	 */
	public static boolean moveMouseToElemnet(By locator, long timeout)
	{
		try{
			WebElement element = waitForElementVisibility(locator, timeout);
			Actions act= new Actions(driver);
			act.moveToElement(element).perform();	
			return true;
		}
		catch(Exception ex){
			return false;
		}

	}

	/**
	 * This method will usedTo Double Click on Element
	 * @param element
	 */
	public static void doubleClick(WebElement element) {
		Actions act= new Actions(driver);
		act.doubleClick(element).perform();

	}
	/**
	 * This method will usedTo Right Click on Element
	 * @param element
	 */
	public static void rightClick(WebElement element) {
		Actions act= new Actions(driver);
		act.contextClick(element).perform();

	}

	/**
	 * This method will usedTo Returns a random number in String format
	 * @param count : Provide the size of digits for the random number
	 * @return RandomNumber : Returns a random Number with digit size equal to "count"
	 */
	public static String getRandomNumber(int count) {
		String randomNumeric = RandomStringUtils.randomNumeric(count);
		return randomNumeric;
	}

	/**
	 * This method will usedTo Returns the random alphabets in String format
	 * @param count : Provide the size of letters for the random alphabets
	 * @return RandomAlphabets : Returns the random alphabets with letters size equal to "count"
	 */
	public static String getRandomAlphabet(int count) {
		String randomAlphabetic = RandomStringUtils.randomAlphabetic(count);
		return randomAlphabetic;
	}

	public static void switchToFrame(String att) {
		driver.switchTo().frame(att);
	}
	public static void switchToFrame(int index) {
		driver.switchTo().frame(index);
	}
	public static void switchToFrame(WebElement elemnent) {
		driver.switchTo().frame(elemnent);
	}

	/**
	 * This method will usedTo Execute the JavaScripts over a Object
	 * @param javaScript : Provide the JavaScript you want to execute
	 * @param obj : Provide the Object on which the JavaScript will execute
	 */
	public static void executeJavaScript(String javaScript , Object obj) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript(javaScript,obj);
	}


	/**
	 * This method will usedTo Execute the JavaScript
	 * @param javaScript : Provide the JavaScript you want to execute
	 * @return One of Boolean, Long, Double, String, List, Map or WebElement. Or null
	 */
	public static Object executeJavaScriptWithoutArg(String javaScript) {
		try{
			JavascriptExecutor js = (JavascriptExecutor)driver;
			return js.executeScript(javaScript);
		}catch(Exception ex) {
			System.out.println("JavaScriptExecutor not performed.");
			return null;
		}
	}

	 /**
	 * This method will usedTo Scroll to the Element using JavaScripts
	 * @param locator used to locate the web element in "By"
	 */
		
		 public static boolean scrollIntoView(By locator) { try {
			 JavascriptExecutor js = (JavascriptExecutor)driver;
			 js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		 WebDriverUtils.executeJavaScript("arguments[0].scrollIntoView(true);",
		 driver.findElement(locator)); 
		 return true; } 
		 catch (Exception e) {
		 e.printStackTrace();
		 return false; 
		 } 
		 
	}
		 
	

	/**This method is used to wait for Cync Loader Using Locator to Disappear in GUI
	 * @param loaderLocator in "By" used to locate the element  
	 * @param waitTimeforLoaderVisiblity in "Seconds"
	 * @param waitTimeforLoaderInvisibility in "Seconds"
	 * @return true if disappeared else false
	 */
	public static boolean waitForCyncLoaderByLocator(By loaderLocator, long waitTimeforLoaderVisiblity, long waitTimeforLoaderInvisibility) {
		boolean cyncLoader = false;
		try {
			waitForElementVisibility(loaderLocator, waitTimeforLoaderVisiblity);
			cyncLoader = waitForInvisibilityOfElement(loaderLocator, waitTimeforLoaderInvisibility);
		}
		catch(Exception ex) {
			cyncLoader = false;
			System.out.println("Loader Not Present");
		}
		return cyncLoader;

	}

	/**This method is used to wait for Cync Loader Using Attribute and Value to Disappear in GUI
	 * @param loaderLocator in "By" used to locate the element
	 * @param attribute used to define css or html attribute in "String"
	 * @param value used as expected attribute value in "String"
	 * @param waitTimeforAttrbtValueVisiblity in "Seconds"
	 * @param waitTimeforAttrbtValueInvisibility in "Seconds"
	 */
	public static void waitForCyncLoaderByAttributeValue(By loaderLocator, String attribute, String value, long waitTimeforAttrbtValueVisiblity, long waitTimeforAttrbtValueInvisibility) {

		try {
			waitForElementAttributeCointainsValue(loaderLocator, attribute, value, waitTimeforAttrbtValueVisiblity);
			waitForElementAttributeNotCointainsValue(loaderLocator, attribute, value, waitTimeforAttrbtValueInvisibility);
		}
		catch(Exception ex) {
			System.out.println("Loader Not Present");
		}

	}

	/**This method is used to Click and wait for the Element to come to Original condition
	 * @param locator used to identify the element
	 * @param timeout used to specify the time within which the element has to come to original condition
	 * @return true is successfully clicked and waited for the specified time , else false
	 */
	public static boolean clickAndWaitforElementToNormal(By locator, long timeout) {
		try{

			waitForElementInterActibility(locator, timeout).click();
			waitForElementInterActibility(locator, timeout);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	/**This method is UsedTo check the Attribute Presence By passing CssSelector
	 * @param element used to locate by only CssSelector
	 * @param attribute used to check the presence of it in the Element
	 * @return true if element contains the attribute else false
	 */
	public boolean isAttribtuePresentByJavaScript(By element, String attribute) {
		boolean flag = false;
		try {
			String locatorString = element.toString();
			String actuallocatorPath = locatorString.substring(locatorString.indexOf(":")+1, locatorString.length()).trim();
			String javaScriptToCheckLoaderPresence = "return document.querySelector(\""+actuallocatorPath+"\").hasAttribute(\""+attribute+"\");";
			flag = (boolean)executeJavaScriptWithoutArg(javaScriptToCheckLoaderPresence);
		} catch (Exception e) {}

		return flag;
	}

	/**This method is UsedTo check the Attribute Presence
	 * @param element used to locate by any Locator
	 * @param attribute used to check the presence of it in the Element
	 * @return true if element contains the attribute else false
	 */
	public static boolean isAttribtuePresent(By element, String attribute) {
		Boolean flag = false;
		try {
			String value = driver.findElement(element).getAttribute(attribute);
			if (StringUtils.isNotEmpty(value)){
				flag = true;
			}
		} catch (Exception e) {}

		return flag;
	}

	public static boolean selectDropdownAndWaitForLoadingComplete(By dropDownLocator, By loaderLocator, String visibleText, String attributeName, String value, long timeout) {
		try {
			selectFromDropdown(dropDownLocator, visibleText, timeout);			
			boolean flag = isAttribtuePresent(loaderLocator, attributeName);
			if(flag == true)
				waitForCyncLoaderByAttributeValue(loaderLocator, attributeName, value, timeout,timeout);
			return true;
		} 
		catch (Exception ex)
		{
			return false;
		}

	}

	public static boolean searchAndWaitForLoadingComplete(By searchBoxLocator, By loaderLocator, String searchText, String attributeName, String value, long timeout) {

		try {
			addToValue(searchBoxLocator, searchText, timeout);
			waitForCyncLoaderByAttributeValue(loaderLocator, attributeName, value, timeout,timeout);
			return true;
		} 
		catch (Exception ex)
		{
			return false;
		}

	}


	public static boolean isDisplay(By locator, long timeout)
	{
		try{

			waitForElementVisibility(locator, timeout).isDisplayed();
			return true;
		}
		catch(Exception ex){
			return false;
		}

	}
	
	public static  boolean isDisplay(WebElement locator, long timeout)
	{
		try{

			waitForElementVisibility(locator, timeout).isDisplayed();
			return true;
		}
		catch(Exception ex){
			return false;
		}

	}
	
	public static boolean scrollToElementAndVerifyDisplay(By locator, long timeout)
	{
		try{
			scrollIntoView(locator);
			waitForElementVisibility(locator, timeout).isDisplayed();
			return true;
		}
		catch(Exception ex){
			return false;
		}

	}
	

	public static boolean VerifyText(By locator, String value, long timeout) {
		try {

			WebElement element = waitForElementVisibility(locator, timeout);
			String text = element.getText().trim().replace(",", "");

			if (element.getText().trim().equalsIgnoreCase(value.trim())) {
				System.out.println(element.getText());

				return true;

			} else {
				System.out.println("Verification Failed - Expected " + value + " Actual " + text);
				return false;
			}
		}

		catch (Exception ex) {
			return false;
		}

	}
	
	public static boolean VerifyText(WebElement locator, String value, long timeout) {
		try {

			WebElement element = waitForElementVisibility(locator, timeout);
			String text = element.getText().trim().replace(",", "");

			if (element.getText().trim().equalsIgnoreCase(value.trim())) {
				System.out.println(element.getText());

				return true;

			} else {
				System.out.println("Verification Failed - Expected " + value + " Actual " + text);
				return false;
			}
		}

		catch (Exception ex) {
			return false;
		}

	}
	
	public static boolean VerifyTextByAttribute(By locator, String value, long timeout) {
		try {

			WebElement element = waitForElementVisibility(locator, timeout);
			String text = element.getAttribute("value").trim();

			if (text.equalsIgnoreCase(value.trim())) {
				System.out.println(text);

				return true;

			} else {
				System.out.println("Verification Failed - Expected " + value + " Actual " + text);
				return false;
			}
		}

		catch (Exception ex) {
			return false;
		}

	}
	
	
	
	/**
	 * @Reviewer : Deepak 
	 * @ReviewComment : Logic for this method is wrong, Its duplicate of "VerifyText()"
	 * @Date:08/08/2022
	 */
	public static boolean verifymsg(By locator, String value, long timeout) {
		try{



		WebElement element = waitForElementVisibility(locator, timeout);
		if(element.getText().trim().equalsIgnoreCase(value.trim()))
		{
		System.out.println(element.getText());
		}
		}
		catch(Exception ex){
		return false;
		}
		return true;
		}
	
	

	/**Used to Verify the Field Presence and Verify the Text 
	 * @param fieldNameLocator used to locate field
	 * @param fieldTextLoactor used to locate value
	 * @param value used to validate with field Text value
	 * @param timeout used for visibility of field and text
	 * @return true if validation satisfy else false
	 */
	public static boolean verifyFieldAndText(By fieldNameLocator, By fieldTextLoactor, String value, long timeout) {
		try{
			if(isDisplay(fieldNameLocator, timeout) && scrollToElementAndVerifyText(fieldTextLoactor, value, timeout))
			{
				return true;
			}
			else
			{
				return false;
			}
		}

		catch(Exception ex){
			return false;
		}
	}
	
	/**This method is used to scroll To Element And Verify the Text
	 * @param locator
	 * @param value
	 * @param timeout
	 * @return
	 */
	public static boolean scrollToElementAndVerifyText(By locator, String value, long timeout) {
		try{
			scrollIntoView(locator);
			WebElement element = waitForElementVisibility(locator, timeout);
			if(element.getText().trim().equalsIgnoreCase(value.trim()))
			{
				System.out.println(element.getText());
				return true;
			}
			else
			{
				return false;
			}

		}

		catch(Exception ex){
			return false;
		}
	}

	/**This method is used to Click to WebElement
	 * @param locator
	 * @param timeout
	 * @return
	 */
	public static boolean ClickToElement(By locator, long timeout) {
		try{

			waitForElementInterActibility(locator, timeout).click();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public static  boolean ClickToElement(WebElement locator, long timeout) {
		try{

			waitForElementInterActibility(locator, timeout).click();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public static boolean addToValue(By locator ,String value, long timeout) {
		try{

			WebElement element = waitForElementInterActibility(locator, timeout);
			element.click();
			element.clear();
			element.sendKeys(value);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public static boolean addToValue(WebElement locator ,String value, long timeout) {
		try{

			WebElement element = waitForElementInterActibility(locator, timeout);
			element.click();
			element.clear();
			element.sendKeys(value);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}


	public static boolean selectFromDropdown(By dropDownLocator,String visibleText, long timeout) {

		try {
			
			selectByVisibleText(dropDownLocator, visibleText, timeout);


			return true;
		} 
		catch (Exception ex)
		{
			return false;
		}

	}


	public static String getText(By locator, long timeout) {
		try{

			return waitForElementVisibility(locator, timeout).getText();
		}
		catch(Exception ex){
			return null;
		}

	}
	public static String getText(WebElement locator, long timeout) {
		try{

			return waitForElementVisibility(locator, timeout).getText();
		}
		catch(Exception ex){
			return null;
		}

	}
	public static String getAtrributeData(By locator, String attributeValue, long timeout) {
		try{

			return waitForElementPresence(locator, timeout).getAttribute(attributeValue);
		}
		catch(Exception ex){
			return null;
		}

	}
}
