package net.metrosystems.demo.utils;
import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestNGListener implements ITestListener {
	
	public void onTestFailure(ITestResult results) {
		try {
			Screenshots.screenshot("TestFailure");
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
}
