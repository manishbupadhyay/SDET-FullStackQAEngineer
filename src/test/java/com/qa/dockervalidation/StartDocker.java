package com.qa.dockervalidation;

import java.io.IOException;

import org.testng.annotations.Test;

public class StartDocker {

	@Test
	public void startFile() throws IOException {
		Runtime runtime = Runtime.getRuntime();
		runtime.exec("cmd /c start /SDET-FullStackQAEngineer/dockerUp.bat");
	}
}
