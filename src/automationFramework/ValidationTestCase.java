package automationFramework;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class ValidationTestCase {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String exePath = "C:\\Users\\mhuang\\Documents\\eclipse-java-luna-SR2-win32-x86_64\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor)driver;

		driver.get("http://cmstest.revivant.com/");
		 
        // Print a Log In message to the screen
        System.out.println("Open CMS");
 
		//Wait for 5 Sec
		Thread.sleep(8000);
		
		driver.findElement(By.cssSelector(".loginForm #userName")).sendKeys("testqa");
		driver.findElement(By.cssSelector(".loginForm #login-password")).sendKeys("123");
		driver.findElement(By.cssSelector(".loginForm #logInBtn")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".searchContainer #ccrSearch-CCRID")).sendKeys("30200");
		driver.findElement(By.cssSelector(".searchContainer #ccrSearch-CCRID")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".ccrResultTable .ccrid")).click();
		driver.findElement(By.cssSelector(".actionContainer .label")).click();
		
		Thread.sleep(1000);
		String CCRID = driver.findElement(By.cssSelector("#customerInfo-view #ccr-CCRID")).getAttribute("value");
		String ProcStatus = driver.findElement(By.cssSelector("#customerInfo-view #ccr-ProcStatus")).getAttribute("value");
		String SRNo = driver.findElement(By.cssSelector("#customerInfo-view #ccr-SRNo")).getAttribute("value");
		String CreatedBy = driver.findElement(By.cssSelector("#customerInfo-view #ccr-CreatedBy")).getAttribute("value");
		String CreatedLocCode = driver.findElement(By.cssSelector("#customerInfo-view #ccr-CreatedLocCode")).getAttribute("value");
		String CausedInjury = (String) js.executeScript("return document.querySelector('#ccr-CausedInjury .selected .label').innerHTML");
		String IncidentReportedDate = driver.findElement(By.cssSelector("#customerInfo-view #ccr-IncidentReportedDT")).getAttribute("value");
		String IncidentOccurredDT= driver.findElement(By.cssSelector("#customerInfo-view #ccr-IncidentOccurredDT")).getAttribute("value");
		String ProductLine = driver.findElement(By.cssSelector(".productContainer select")).getAttribute("value");
		
		///TRY FILE STREAM
		try{    
            FileOutputStream myExcel=new FileOutputStream("C:\\Users\\mhuang\\Documents\\eclipse-java-luna-SR2-win32-x86_64\\testout.txt");    
            myExcel.write(65);    
            myExcel.close();    
            System.out.println("success...");    
           }catch(Exception e){System.out.println(e);}
		
		//ITEM LEVEL
//		List<WebElement> ItemsList =driver.findElements(By.cssSelector(".productTable td"));
//		for (int i = 0; i < ItemsList.size(); i++) {
//			System.out.println(ItemsList.get(i));
//		}
//		
//		Map<String, String> Items = new HashMap<String, String>();

		
		
		System.out.println("CCRID: " + CCRID);
		System.out.println("Process Status: " + ProcStatus);
		System.out.println("SRNO: " + SRNo);
		System.out.println("Created By: " + CreatedBy);
		System.out.println("Created Location: " +CreatedLocCode);
		System.out.println("Caused Injury? " +CausedInjury);
		System.out.println("Incident Reported Date: " +IncidentReportedDate);
		System.out.println("Incident Occurred Date: " +IncidentOccurredDT);
		System.out.println("Product Line: " +ProductLine);
//		System.out.println(ItemsList);
	}

}
	