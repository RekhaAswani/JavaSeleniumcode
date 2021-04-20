package TestNgSessions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestngBasics {

	/**
	 * Global Pre Conditions: @BeforeSuite, @BeforeTest, @BeforeClass Pre
	 * Conditions: @BeforeMethod Test Steps: @Test, @DataProvider Actual vs Expected
	 * Result -- Assertions Post Steps : @AfterMethod Global Post steps
	 * : @AfterClass, @AfterTest, @AfterSuite
	 */
	
	/**
	 * BS - createUserInDB
      BT -giveuerPermisssion
      BC --Open the browser and launch App
      
      BM --Login to app
      AddTocartTest
      AM--Logout
      BM --Login to app
      appLogoTest
      AM--Logout
      BM --Login to app
      searchProductTest
      AM--Logout
          AC -- close the browser 
          AT -- delete the browser
          AS Close DB Connection

PASSED: AddTocart
PASSED: logoTest
PASSED: searchProductTest

	 * 
	 * 	 */

	@BeforeSuite
	public void createUserInDB() {
		System.out.println("BS - createUserInDB");

	}

	@BeforeTest
	public void giveUserPermission() {
		System.out.println("BT -giveuerPermisssion");
	}

	@BeforeClass
	public void launchApp() {
		System.out.println("BC --Open the browser and launch App");
	}

	@BeforeMethod
	public void login() {
		System.out.println("BM --Login to app");
	}

	@Test
	public void logoTest() {
		System.out.println("appLogoTest");
	}

	@Test
	public void searchProductTest() {
		System.out.println("searchProductTest");
	}

	@Test
	public void AddTocart() {
		System.out.println("AddTocartTest");
	}

	@AfterMethod
	public void logout() {
		System.out.println("AM--Logout");
	}

	@AfterClass
	public void CloseBrowser() {
		System.out.println("AC -- close the browser");
	}

	@AfterTest
	public void DeleteTheUser() {
		System.out.println("AT -- delete the browser");
	}

	@AfterSuite
	public void CloseDBConnection() {
		System.out.println("AS Close DB Connection");
	}
}
