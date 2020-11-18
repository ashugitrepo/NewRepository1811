package com.automationpratice.pageclasses.homepage.home;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Testing {

	WebDriver driver;
	
	@Test
	@Parameters({"browser","url"})
	public void loginScreen(String browser, String url) throws InterruptedException {
		
		if(browser=="ff") {
			System.setProperty("webdriver.frirefox.driver", "C:\\Ashu\\Selenium\\eclipse-workspace\\Project_Selenium\\exe\\geckodriver.exe");
			driver= new FirefoxDriver();
		}
		else if(browser=="ch") {
			System.setProperty("webdriver.chrome.driver", "C:\\Ashu\\Selenium\\eclipse-workspace\\Project_Selenium\\exe\\chromedriver.exe");
			driver= new ChromeDriver();
		}
		
		else if(browser=="ch") {
			System.setProperty("webdriver.ie.driver", "C:\\Ashu\\Selenium\\eclipse-workspace\\Project_Selenium\\exe\\IEDriverServer.exe");
			driver= new InternetExplorerDriver();
		}
		
		
			driver.get(browser);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Sign in")).click();
		
	}
	
//@Test(priority=0)	
public void signUp() {
	/*
	System.setProperty("webdriver.chrome.driver", "C:\\Ashu\\Selenium\\eclipse-workspace\\Selenium_Practice\\exe\\chromedriver.exe");
	
	driver= new ChromeDriver();
	driver.get("http://automationpractice.com/index.php");
	driver.manage().window().maximize();
	driver.findElement(By.linkText("Sign in")).click();*/
	driver.findElement(By.id("email_create")).sendKeys("ashutosh.singh123@gmail.com");
	
	driver.findElement(By.id("SubmitCreate")).click();
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
	driver.findElement(By.xpath("//label[text()='Title']"));
	driver.findElement(By.id("customer_firstname")).sendKeys("Ashutosh");
	driver.findElement(By.id("customer_lastname")).sendKeys("Singh");
	driver.findElement(By.id("passwd")).sendKeys("ashu123");
	WebElement day=driver.findElement(By.id("days"));
	WebElement month=driver.findElement(By.id("months"));
	WebElement year=driver.findElement(By.id("years"));
	Select dropdown=new Select(day);
	dropdown.selectByValue("29");
	Select dropdown1=new Select(month);
	dropdown1.selectByIndex(5);
	Select dropdown2=new Select(year);
	dropdown2.selectByValue("1982");
	driver.findElement(By.id("address1")).sendKeys("Sector-50, Noida-2010");
	driver.findElement(By.id("address2")).sendKeys("Sector-50, Noida-2010");
	driver.findElement(By.id("city")).sendKeys("Noida");
	WebElement state=driver.findElement(By.id("id_state"));
	Select dropdown3=new Select(state);
	dropdown3.selectByValue("9");
	driver.findElement(By.id("postcode")).sendKeys("20130");
	driver.findElement(By.id("phone_mobile")).sendKeys("7838084928");
	driver.findElement(By.id("alias")).sendKeys("Sector-50, Noida-2010");
	//driver.findElement(By.id("submitAccount")).click();
}
//@Test
public void login() {
	
driver.findElement(By.id("email")).sendKeys("ashutosh.singh12@gmail.com");	
driver.findElement(By.id("passwd")).sendKeys("ashu123");
driver.findElement(By.id("SubmitLogin")).click();
	//System.out.println("Login Method Executed");
	
	
}
//@Test//(dependsOnMethods = { "login" })
public void getAllLinks() throws Exception {
	driver.findElement(By.id("email")).sendKeys("ashutosh.singh12@gmail.com");	
	driver.findElement(By.id("passwd")).sendKeys("ashu123");
	driver.findElement(By.id("SubmitLogin")).click();
List<WebElement> links=driver.findElements(By.tagName("a"));
String[] linktexts = new String[links.size()];
int i=0;
for(WebElement link : links) {
		if(!link.equals(null)) {
	linktexts[i]=link.getText();
		}
	System.out.println(linktexts[i]);
	i++;
		}
	
	
	for(String st : linktexts) {
		if (st.equalsIgnoreCase("Ashutosh Singh")) {							
            System.out.println("No action required");			
        } 
		
		else if (st.equalsIgnoreCase("Sign out")) {							
            System.out.println("No action required");			
        }
		else if (st.equalsIgnoreCase("")) {							
            System.out.println("Empty String");			
        }
		
		else {			
       try {
    	   System.out.println("\n");
    	   System.out.println(" Link "+st+" Started ");
		driver.findElement(By.partialLinkText(st)).click();
		System.out.println(" Link "+st+" Executed ");
		Thread.sleep(5000);
		
       }
       catch(Exception e) {
    	   
    	   System.out.println(e);
    	   continue;
       }
       
       
		driver.navigate().back();
		
	}
	}
	
	
}






//@AfterMethod	

public void tearDown() throws InterruptedException {
	Thread.sleep(3000);
driver.close();	
	
	
}
	
	
	
	
	
}
