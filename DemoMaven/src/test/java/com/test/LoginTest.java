package com.test;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.loginpage.DashboardPage;
import com.loginpage.LoginInPage;

public class LoginTest {
	WebDriver driver=null;
	DashboardPage dp=null;
	LoginInPage lp=null;
	@BeforeSuite
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///D:/selenium%20files/Offline%20Website/index.html");
		driver.manage().window().maximize();
		lp=new LoginInPage(driver);
	}
	
	@Test
	public void login() {
		
		//lp.loginToApplication("kiran@gmail.com", "123456");
		
		dp=lp.validLogin();
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");
	}
	
//	@Test
//	public void dashboard() {
//		ArrayList<String> expectedCourses=new ArrayList<String>();
//		expectedCourses.add("Selenium");
//		expectedCourses.add("Java / J2EE");
//		expectedCourses.add("Python");
//		expectedCourses.add("Php");
//		
//         dp=new DashboardPage(driver);
//        ArrayList<String> actualCourses= dp.verifyCourses();
//        Assert.assertEquals(actualCourses, expectedCourses);
//	}

	@Test
	public void Test03() {
		dp=new DashboardPage(driver);
		boolean flag=dp.verifyCourses1();
		Assert.assertFalse(flag);
	}
}
