package org.task;

import java.util.Date;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment {
	
 static WebDriver driver;
 
	
	@BeforeClass
	public static void beforeClass() {
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		driver.manage().window().maximize();
		}
	
	@Before
	public void before() {
		Date d=new Date();
		System.out.println("Before test is"+d);
		
	}
	@After
	public void after() {
		Date d=new Date();
		System.out.println("after test is"+d);
	}
	
	@Test
	public  void test1 () throws InterruptedException {
		driver.get("http://www.htmlcanvasstudio.com/");
		WebElement cv = driver.findElement(By.id("imageTemp"));
		Actions a=new Actions(driver);
		WebElement draw = driver.findElement(By.xpath("//input[@title='Draw a line']"));
		draw.click();
		
		Actions mte = a.moveToElement(cv);
		 
		 mte.perform();
	
		mte.clickAndHold().perform();
		mte.moveByOffset(150, 150).perform();
		mte.moveByOffset(20, -150);
		mte.click().perform();
	}

		@Test
		public void test2() throws InterruptedException  {
			WebElement cv = driver.findElement(By.id("imageTemp"));
			Actions a=new Actions(driver);
			Actions mte = a.moveToElement(cv);
			mte.moveToElement(cv, 80, -40);
			mte.clickAndHold().perform();
			mte.moveByOffset(0,  90);
			mte.click().perform();
			mte.release(cv);
}
		@Test
		public void test3() throws InterruptedException {
			WebElement cv = driver.findElement(By.id("imageTemp"));
			Actions a=new Actions(driver);
			WebElement fe1 = driver.findElement(By.xpath("//input[@title='Draw a rectangle']"));
			fe1.click();
			Actions mte = a.moveToElement(cv);
			mte.dragAndDropBy(cv, -120, 100).perform();
			mte.release(cv);
		}
		
		@Test
		public void test4() {
			WebElement cv = driver.findElement(By.id("imageTemp"));
			Actions a=new Actions(driver);
			Actions mte = a.moveToElement(cv);
			
			
			WebElement fe2 = driver.findElement(By.xpath("//input[@title='Use eraser']"));
			fe2.click();
			 mte.moveToElement(cv, 3, 0);
			mte.clickAndHold().perform();
			
			mte.moveByOffset(180, 0).perform();
			
			mte.click().release().perform();

}
		@AfterClass
		public static void afterClass() {
		}
}
