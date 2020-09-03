package net.metrosystems.demo.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestNGExampleTest {
	int nr;
	boolean param;
	
	@Test
	public void testing() {
		System.out.println("testing");
	}
	
	@BeforeSuite // tagul din testng.xml
	public void beforeSuite() {
		System.out.println("Before suite");
	}
	
	@AfterSuite // tagul din testng.xml
	public void afterSuite() {
		System.out.println("after Suite");
	}
	
	@BeforeGroups
	public void beforeGroups() {
		System.out.println("beforeGroups");
	}
	
	@AfterGroups
	public void afterGroups() {
		System.out.println("afterGroups");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("BeforeClass");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("AfterClass");
	}
	
	@BeforeTest // tagul din testng.xml
	public void beforeTest() { 
		System.out.println("BeforeTest");
	}
	
	@AfterTest // tagul din testng.xml
	public void afterTest() { 
		System.out.println("AfterTest");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("BeforeMethod");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("afterMethod");
	}
	
	@Test(invocationCount = 7, invocationTimeOut = 4000)
	public void method2() throws InterruptedException {	
		Thread.sleep(1000);
		System.out.println("method2");
	}
	


	@Test
	private void metoda1() {
		param = false;
		if (param == true) {
			System.out.println("metoda 1");
			nr = 1;
		}
		assertEquals(nr, 1);
	}

	@Test(dependsOnMethods = "metoda1", alwaysRun = true)
	public void metoda2() {
		if (nr == 1) {
			System.out.println("metoda 2");
			nr = 2;
		}
		assertEquals(nr, 2);

	}
	

}


