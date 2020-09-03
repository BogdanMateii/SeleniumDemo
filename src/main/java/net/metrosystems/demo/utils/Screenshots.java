package net.metrosystems.demo.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Screenshots extends DriverInit {
	public static void screenshot(String testCaseName) throws IOException {
		TakesScreenshot screenshot = ((TakesScreenshot) driver);
		File fileSource = screenshot.getScreenshotAs(OutputType.FILE);
		String fileName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
		FileUtils.copyFile(fileSource, new File("./screenshots/" + testCaseName + "_" + fileName + ".png"));
	}

}
