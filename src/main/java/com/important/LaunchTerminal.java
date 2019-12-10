package com.important;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class LaunchTerminal {

	public static void main(String[] args) throws Throwable {
		String s = "/usr/local/bin/appium -p " + 4724;
		//Process p = Runtime.getRuntime().exec(new String[]{"/Applications/Utilities/Terminal.app/Contents/MacOS/Terminal","/usr/local/bin/appium","-p","4723"});
		//Process p = Runtime.getRuntime().exec(new String[]{"/Applications/Utilities/Terminal.app/Contents/MacOS/Terminal","/bin/ls"});
		Runtime.getRuntime().exec(new String[]{"sh","/Users/ahamedabdulrahman/Documents/launchTerminal.sh"});
		/*Thread.sleep(2000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyPress(KeyEvent.VK_A);
		r.keyPress(KeyEvent.VK_P);
		r.keyPress(KeyEvent.VK_P);
		r.keyPress(KeyEvent.VK_I);
		r.keyPress(KeyEvent.VK_U);
		r.keyPress(KeyEvent.VK_M);
		r.keyPress(KeyEvent.VK_SPACE);
		r.keyPress(KeyEvent.VK_MINUS);
		r.keyPress(KeyEvent.VK_SPACE);
		r.keyPress(KeyEvent.VK_4);
		r.keyPress(KeyEvent.VK_7);
		r.keyPress(KeyEvent.VK_2);
		r.keyPress(KeyEvent.VK_3);*/
	}
}
