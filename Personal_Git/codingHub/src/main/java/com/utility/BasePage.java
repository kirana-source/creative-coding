package com.utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {
	
	public static WebDriver driver;

	public BasePage(WebDriver driver){
		this.driver=driver;
		 PageFactory.initElements(driver, this);
		System.out.println(this.driver+"base page");
	}

	
	public boolean isElementPresent(By xpath){
		try{
			List<WebElement> elementWebE=driver.findElements(xpath);
			
			if (elementWebE.size()==0){
				return false;
			}else
			return true;
		}catch(Exception ex){
			return false;
		}
		
	}
	
	public  void fileUpload(By chooseFile_xpath,String filepath){
		try{
			WebElement fileInput=new WebDriverWait(driver,Duration.ofSeconds(20)).
					until(ExpectedConditions.visibilityOfElementLocated(chooseFile_xpath)); 	
			
			fileInput.sendKeys(filepath);
			Thread.sleep(3000);
		}catch(Exception e){
			
		}
		
	}
	
	public void fileupload(String FilePath,By xpath){		
			 try {
			    	WebElement El = driver.findElement(xpath);
				((RemoteWebElement) El ).setFileDetector(new LocalFileDetector()); 
				El.sendKeys(FilePath);
				Thread.sleep(2000);
			} 
			 catch (Exception e) {
					e.printStackTrace();
		    }
	}
	
	 public static String largest(String[] s) 
     { 
         int i;       
         String max = s[0]; 
         for (i = 1; i < s.length; i++) 
             if (s[i].length() > max.length()) 
                 max = s[i]; 
        
         return max; 
     } 	
	


	/**
	 * @author kirana.l
	 * This method is used to get the borrower id from the URL 
	 */
	public String getBorrowerId() 
    { 
		String[] currentUrl = driver.getCurrentUrl().split("=");

		System.out.println(currentUrl[0]+">>>>>>>>> "+currentUrl[1]);
       
        return currentUrl[0].replaceAll("[^\\d]", " ").trim(); 
    } 	
	
	public String getCurrentDate() {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		String currentDate = dateFormat.format(new Date());
		return currentDate;

		}
	
	
}
