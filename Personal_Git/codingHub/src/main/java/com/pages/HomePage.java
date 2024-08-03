package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.BasePage;

public class HomePage extends BasePage{
	
	 public HomePage(WebDriver driver) throws InterruptedException {
	        super(driver);
	        System.out.println(driver+"home page");
	        Thread.sleep(10000);
	    }
	
	@FindBy(xpath = "//h1")
    private WebElement main_Header;

    @FindBy(xpath = "//*[text()='Revenue Calculator']")
    private WebElement Revenue_Header;
    
    @FindBy(id = ":r0:")
    private WebElement text_Field;

    public WebElement getMainHeader() {
        return main_Header;
    }

    public WebElement getRevenueHeader() {
        return Revenue_Header;
    }
    
    public String getUrl() {
        return driver.getCurrentUrl();
    }
    
    public WebElement textField() {
        return text_Field;
    }

}
