package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ChromeTest {

	@Test
	public void testChrome() {
		String relativelyPath = System.getProperty("user.dir");
		System.out.println(relativelyPath);
		System.setProperty("webdriver.chrome.driver",
				relativelyPath + "\\src\\main\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String baseUrl = "https://www.baidu.com/";
		driver.get(baseUrl);
		//driver.quit();
	}
}
