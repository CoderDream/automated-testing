package com.billjc.pdrc.service;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.billjc.pdrc.util.DriverUtil;

public class LoginServiceTest {

	private LoginService loginService;

	@BeforeClass
	public void setUp() throws Exception {
		loginService = new LoginService();
		loginService.setDriver(DriverUtil.getDriver());
	}

	@Test
	public void login() throws Exception {
		loginService.openLoginPage();

		Thread.sleep(2000);
		// [B-17268]姚志红
		String workId = "B-17268";
		String password = "123";

		loginService.login(workId, password);
	}

	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		loginService.getDriver().quit();
	}
}
