package CommonLibrary;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.Base.Base_Class;

public class Generic_Function extends Base_Class{
	
		
		// Explicit wait for  click able elements 

			public static void clickOn(WebDriver driver, WebElement locator, int timeout) {
				new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class)
						.until(ExpectedConditions.elementToBeClickable(locator));
				locator.click();
			}
			
			
		// Sync wait for page load timeout
			public static void PageLoad() {
				driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
			}
		// ImplicitWait
			public static void ImplicitWait() {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			}
			
		// Delete all cookies
			public static void DeleteAllCookies() {
				driver.manage().deleteAllCookies();
			}
		// Sleep methods
			public static void Wait() throws Exception {
				int sleep = 5000;
				Thread.sleep(sleep);
			}
			
			public void Select_dropdown_value(By locator,String type, String value) {
			
			}
			
		//Delete Download folder file
			public static void Delete_ExportExcel_File() {
				File file = new File("./Downloads/Survey.xlsx");

				if (file.delete())
					System.out.println("Excel File deleted successfully");
				else
					System.out.println("Failed to delete the Excel file");
			}
		//
			public void Browser_Setup(String BrowserName) {
				if (BrowserName.equalsIgnoreCase("Chrome")) {
					System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
					driver=new ChromeDriver();			
				}
				else if(BrowserName.equalsIgnoreCase("Firefox")){
					System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
					driver=new ChromeDriver();
				}
			}
		
	}


