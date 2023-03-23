package com.datadriven;

import java.io.IOException;

import org.testng.annotations.Test;

public class Execution extends BaseClass {
	@Test
	private void tc1() throws IOException, InterruptedException {

		browserLaunch("https://adactinhotelapp.com/");

		LoginPage a = new LoginPage();
		inputText(a.getUser(), stringData(1, 0));
		inputText(a.getPass(), stringData(1, 1));
		btnClick(a.getLoginbtn());

	}
}
