package com.sample;

import java.io.IOException;

public class TerminalJava 
{
	public static void main(String...arg) throws IOException
	{
		/*String[] command = { "appium" };
		Process proc = new ProcessBuilder(command).start();*/
		Process p = Runtime.getRuntime().exec(new String[]{"/Applications/Utilities/Terminal.app/Contents/MacOS/Terminal","/usr/local/bin/appium"});
		//Process p2 = Runtime.getRuntime().exec(new String[]{"/Applications/Utilities/Terminal.app/Contents/MacOS/Terminal","/bin/ls"});
	}
}
