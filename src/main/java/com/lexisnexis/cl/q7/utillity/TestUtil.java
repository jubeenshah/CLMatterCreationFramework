package com.lexisnexis.cl.q7.utillity;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.lexisnexis.cl.q7.base.Base;

public class TestUtil extends Base{
	public static long pageLoadTimeout = 20;
	public static long implicitllyWait = 20;
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
			File srcFile=  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String currentDir = System.getProperty("user.dir");
			FileHandler.copy(srcFile, new File(currentDir + "/screenshots" +System.currentTimeMillis() + "/.png"));
			
	}
	
}


