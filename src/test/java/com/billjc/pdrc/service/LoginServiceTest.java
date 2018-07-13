package com.billjc.pdrc.service;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.billjc.pdrc.util.DriverUtil;

public class LoginServiceTest {

	private WebDriver driver;
	private LoginService loginService;
	private PrizeService prizeService;

	@BeforeClass
	public void setUp() throws Exception {
		driver = DriverUtil.getDriver();
		loginService = new LoginService();
		prizeService = new PrizeService();
	}

	@Test
	public void login() throws Exception {

		String loginPageUrl = "/Index/Index";
		loginService.openPage(driver, loginPageUrl);

		Thread.sleep(2000);
		// [B-17268]姚志红
		String workId = "B-17268";
		String password = "123";

		loginService.login(driver, workId, password);

		Thread.sleep(3000);
		// 项目BSM分配 /PDRC_Project/PDRC_ProjectList
		String linkText = "项目BSM分配";
		loginService.openPageByLinkText(driver, linkText);

		// D-00105-20161230-60
		String projectNewNo = "D-00105-20161230-60";
		prizeService.dispatchBsm(driver, projectNewNo);

		prizeService.bsmDetail(driver, projectNewNo);

	}

	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
		Runtime.getRuntime().exec("taskkill /F /im " + "chromedriver.exe");
		// Runtime.getRuntime().exec("taskkill /F /im " + "chrome.exe");
		// 结束进程。以上是用于在发生异常时结束chromedriver进程，避免chromedriver占用内存资源。close()，和quit()方法有时候是无法结束chromedriver进程的。
	}
}
