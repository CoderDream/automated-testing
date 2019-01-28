package com.billjc.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverUtil {

	public static WebDriver getDriver() {
		// String baseUrl = PropertyUtil.getValue("config.properties",
		// "base_url");// "http://10.100.254.162:8099/common-rbac/function/";
		String relativelyPath = System.getProperty("user.dir");
		System.out.println(relativelyPath);
		System.setProperty("webdriver.chrome.driver",
				relativelyPath + "\\src\\main\\resources\\chromedriver.exe");
		// Chrome去掉提示“Chrome正受到自动化测试软件的控制”
		ChromeOptions option = new ChromeOptions();
		option.addArguments("disable-infobars");
		WebDriver driver = new ChromeDriver(option);

		// 设置10秒
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// 自定义浏览器窗口大小
		// driver.manage().window().setSize(new Dimension(540, 720));
		// 浏览器最大化
		driver.manage().window().maximize();

		return driver;
	}
	
	
}
