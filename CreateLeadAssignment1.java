package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLeadAssignment1 {
	public static void main(String[] args) {

		//We have to call WDM for the browser driver
		WebDriverManager.chromedriver().setup(); //verifies the version , download, set up

		//Launch the Chrome Browser
		ChromeDriver driver = new ChromeDriver();

		//1. Launch URL "http://leaftaps.com/opentaps/control/login"
		driver.get("http://leaftaps.com/opentaps");

		//Maximize the browser
		driver.manage().window().maximize();

		//2. Enter UserName and Password Using Id Locator
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		// 3. Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();

		//We need to check if we are at correct page
		WebElement logout = driver.findElement(By.className("decorativeSubmit"));

		//Get the attribute and print
		String attribute=logout.getAttribute("value");
		if(attribute.equals("Logout")) {
			System.out.println("Login Successful");

			//4. Click on CRM/SFA Link
			driver.findElement(By.linkText("CRM/SFA")).click();

			//5. Click on Leads Button
			driver.findElement(By.linkText("Leads")).click();

			//6. Click on Create Lead 
			driver.findElement(By.linkText("Create Lead")).click();

			// 7. Enter CompanyName Field Using id Locator
			driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");

			//8. Enter FirstName Field Using id Locator
			driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Keerthana");

			// 9. Enter LastName Field Using id Locator
			driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Jayaprakash");

			//10. Enter FirstName(Local) Field Using id Locator
			driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("kee");

			//11. Enter Department Field Using any Locator of Your Choice
			driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Testing");

			//12. Enter Description Field Using any Locator of your choice 
			driver.findElement(By.id("createLeadForm_description")).sendKeys("Selenium refers to a suite of tools that are widely used in the testing community when it comes to cross-browser testing. Selenium cannot automate desktop applications; it can only be used in browsers. It is considered to be one of the most preferred tool suites for automation testing of web applications as it provides support for popular web browsers which makes it very powerful.");

			//13. Enter your email in the E-mail address Field using the locator of your choice
			driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("keerthanaj2505@gmail.com");

			//14. Select State/Province as NewYork Using Visible Text
			WebElement dropdown1=driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
			Select select = new Select(dropdown1);
			select.selectByVisibleText("New York");

			//15. Click on Create Button
			driver.findElement(By.className("smallSubmit")).click();

			//16. Get the Title of Resulting Page using driver.getTitle()
			String str = driver.getTitle();
			if(str.equalsIgnoreCase("View Lead | opentaps CRM")) {
				System.out.println("Title: " +str);
			}
			else {
				System.out.println("Title not Found");
			}
			System.out.println("Lead Created Successfully");

		}

	}

}
